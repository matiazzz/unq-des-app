package appdata;

import model.events.Event;
import model.events.EventData;
import model.events.MusicEvent;
import model.events.Place;
import model.users.MovieGenre;
import model.users.Profile;
import model.users.User;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import service.GeneralService;

import static model.builders.EventBuilder.anyEvent;
import static model.builders.UserBuilder.anyUser;
import static model.users.FoodType.ITALIAN;
import static model.users.FoodType.PIZZA;
import static model.users.MovieGenre.ACTION;
import static model.users.MovieGenre.HORROR;
import static model.users.MusicalGenre.*;

public class AppData {

    private GeneralService generalService;

    public void initData() {
        MusicEvent musicEvent1 = new MusicEvent();
        musicEvent1.addMusicGenre(ROCK);
        Event event1 = new Event(new EventData("Black Sabbath en Argentina",
                "Black Sabbath por última vez en vivo en Argentina",
                musicEvent1, 1200, new Place("Estadio Velez", ""), new LocalDate(2016, 11, 26), new LocalTime(21, 0),
                3, "https://i.ytimg.com/vi/Usqq2amB3QE/hqdefault.jpg", true));

        MusicEvent musicEvent2 = new MusicEvent();
        musicEvent2.addMusicGenre(ROCK);
        musicEvent2.addMusicGenre(POP);
        musicEvent2.addMusicGenre(REAGGE);
        Event event2 = new Event(new EventData("Lollapalooza Argentina 2017",
                "El Festival donde música, arte, moda, gastronomía y espacios verdes son protagonistas ya tiene fecha para su cuarta edición. Los más chicos también tienen su lugar en el festival en el Kidzapalooza donde pueden vivir la experiencia Lollapalooza a través de la música, diferentes talleres y actividades para toda la familia.",
                musicEvent2, 1500, new Place("Ipódromo de San Isidro", ""), new LocalDate(2017, 3, 31), new LocalTime(14, 0),
                6, "https://cdn.boletius.com/lollapalooza-2017/cover-lolla.jpg", true));

        Event event3 = new Event(new EventData("Descendents en Argentina",
                "DESCENDENTS POR FIN EN BUENOS AIRES!!! La banda Californiana llega por primera vez a nuestro país para presentar su nuevo disco \"Hypercaffium Spazzinate\"",
                musicEvent1, 750, new Place("Teatro de Flores", "Avenida Rivadavia 7800"), new LocalDate(2016, 12, 4), new LocalTime(20, 0),
                3, "http://www.viamusicos.com.ar/repository/cartelera/7d49e29c1777d06285dca8bee0d21ed8.jpg", true));

        Profile profile = new Profile();
        profile.addFoodType(PIZZA);
        profile.addFoodType(ITALIAN);
        profile.addMusicalGenre(ROCK);
        profile.addMusicalGenre(JAZZ);
        profile.addMovieGenre(HORROR);
        profile.addMovieGenre(ACTION);
        User user1 = anyUser().withProfile(profile).build();
        User user2 = anyUser()
                .withUserName("mz.matiazzz")
                .withName("Matias")
                .withLastName("Z")
                .with(new LocalDate(1986, 12, 3))
                .with(user1)
                .withProfile(profile).build();

        generalService.getUserService().save(user1);
        generalService.getUserService().save(user2);
        generalService.getEventService().save(event1);
        generalService.getEventService().save(event2);
        generalService.getEventService().save(event3);

        for(int i=0; i<20; i++){
            Event event = anyEvent().withTitle("Event" + i).build();
            generalService.getEventService().save(event);
        }


    }


    public void setGeneralService(GeneralService generalService) {
        this.generalService = generalService;
    }
}
