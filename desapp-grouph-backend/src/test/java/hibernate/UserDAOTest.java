package hibernate;

import model.users.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import persistence.UserDAO;
import service.UserService;
import static model.builders.UserBuilder.anyUser;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class UserDAOTest {

    @Autowired
    public UserDAO dao = new UserDAO();

    @Autowired
    public UserService service = new UserService(dao);

    @Test
    public void saveTest(){
        User user = anyUser().withUserName("NOMBRE").build();

        service.save(user);
        assertEquals(service.retriveAll().size(), 1);
    }

    @Test
    public void updateTest(){
        User user = anyUser().withUserName("NOMVRE").build();
        service.save(user);

        user.setName("NOMBRE");
        service.update(user);

        assertEquals("NOMBRE", service.retriveAll().get(0).getName());
    }


}
