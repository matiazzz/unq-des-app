package hibernate;

import model.users.Profile;
import model.users.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;
import static model.builders.UserBuilder.anyUser;
import static model.builders.ProfileBuilder.anyProfile;
import static model.users.FoodType.*;
import static model.users.MovieGenre.*;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldSaveUserTest(){
        User user = anyUser().withName("User").build();
        userService.save(user);
        assertEquals(1, userService.findByName("User").size());
    }

    @Test
    public void shouldUpgradeUser(){
        User user = anyUser().withName("anyName").build();
        userService.save(user);
        user.setName("aName");
        userService.update(user);
        assertEquals(0, userService.findByName("anyName").size());
        assertEquals(1, userService.findByName("aName").size());
    }

    @Test
    public void shouldFindAnUserByItsName(){
        User user1 = anyUser().withName("User1").build();
        User user2 = anyUser().withName("User2").build();
        User user3 = anyUser().withName("User3").build();

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);

        assertEquals(1, userService.findByName("User2").size());
    }

    @Test
    public void shouldFindAnUserByItsUserName(){
        User user1 = anyUser().withUserName("UserName1").build();
        User user2 = anyUser().withUserName("UserName2").build();
        User user3 = anyUser().withUserName("UserName3").build();
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        assertEquals(1, userService.findByUserName("UserName1").size());
        assertEquals("UserName1", userService.findByUserName("UserName1").get(0).getUserName());
    }

    @Test
    public void shouldFindAnUseByUserNameAnReturnTheProfile(){
        Profile profile = anyProfile()
                .with(ACTION)
                .build();
        User user = anyUser()
                .withUserName("UserWithProfile")
                .with(profile)
                .build();
        userService.save(user);
        assertTrue(userService.getProfileByUserName("UserWithProfile").likeMovieGenre(ACTION));
        assertFalse(userService.getProfileByUserName("UserWithProfile").likeFoodType(PASTA));
    }

}
