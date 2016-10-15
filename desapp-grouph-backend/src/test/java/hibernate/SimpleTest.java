package hibernate;

import model.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;
import static model.builders.UserBuilder.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class SimpleTest {

    @Autowired
    private UserService userService;


    @Test
    public void saveUserTest(){
        userService.save(new User());
        assertEquals(1, userService.retriveAll().size());
    }

    public void shouldUpgradeUser(){
        User user = anyUser().withUserName("NOMVRE").build();
        userService.save(user);

        user.setName("NOMBRE");
        userService.update(user);

        assertTrue(userService.retriveAll().contains(user));
    }
}
