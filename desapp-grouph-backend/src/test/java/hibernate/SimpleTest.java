package hibernate;

import model.users.User;
import org.junit.FixMethodOrder;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;
import static model.builders.UserBuilder.*;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class SimpleTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldSaveUserTest(){
        userService.save(new User());
        assertEquals(1, userService.retriveAll().size());
    }

    @Test
    public void shouldUpgradeUser(){
        User user = anyUser().withUserName("anyName").build();
        userService.save(user);
        user.setName("aName");
        userService.update(user);
        assertEquals(0, userService.findByName("anyName").size());
        assertEquals(1, userService.findByName("aName").size());
    }
}
