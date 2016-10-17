package service;

import model.users.Profile;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static model.builders.ProfileBuilder.anyProfile;
import static model.users.FoodType.CHINESE;
import static model.users.MovieGenre.ACTION;
import static model.users.MusicalGenre.POP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @Test
    public void shouldSaveAProfileTest(){
        Profile profile = anyProfile()
                .with(ACTION)
                .with(CHINESE)
                .with(POP)
                .build();
        profileService.save(profile);
        assertEquals(1, profileService.retriveAll().size());
        assertTrue(profileService.retriveAll().get(0).likeMovieGenre(ACTION));
        assertTrue(profileService.retriveAll().get(0).likeFoodType(CHINESE));
        assertTrue(profileService.retriveAll().get(0).likeMusicalGenre(POP));
    }
}
