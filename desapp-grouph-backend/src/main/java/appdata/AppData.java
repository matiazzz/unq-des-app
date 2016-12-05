package appdata;

import model.events.*;
import model.users.Profile;
import model.users.User;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import service.GeneralService;

import static model.builders.EventBuilder.*;
import static model.builders.UserBuilder.anyUser;
import static model.users.FoodType.ITALIAN;
import static model.users.FoodType.PIZZA;
import static model.users.MovieGenre.ACTION;
import static model.users.MovieGenre.HORROR;
import static model.users.MusicalGenre.*;

public class AppData {

    private GeneralService generalService;

    public void initData() {
        createEvents();
        createImportantEvents();
        createUsers();

        XMLParser xmlparser = new XMLParser();
        xmlparser.parseEvents("/desapp-grouph-backend/src/main/resources/events.xml");

        for (Event event : xmlparser.events) {
            generalService.getEventService().save(event);
        }
    }

    private void createUsers(){
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

        User user3 = anyUser().withUserName("martin.ramos292").withName("Martin").withLastName("Ramos").with(new LocalDate(1989, 4, 18)).with(user2).withProfile(profile).build();

        generalService.getUserService().save(user1);
        generalService.getUserService().save(user2);
        generalService.getUserService().save(user3);
    }

    private void createEvents(){
        Event e1 = anyEvent().withTitle("Event 1").withDescription("Description Event 1").withDateYesterday().build();
        Event e2 = anyEvent().withTitle("Event 2").withDescription("Description Event 2").withDateYesterday().withPrice(100).build();
        Event e3 = anyEvent().withTitle("Event 3").withDescription("Description Event 3").withDateYesterday().withPrice(200).build();

        Event e4 = anyEvent().withTitle("Event 4").withDescription("Description Event 4").withDateToday().withPrice(431).build();
        Event e5 = anyEvent().withTitle("Event 5").withDescription("Description Event 5").withDateToday().build();
        Event e6 = anyEvent().withTitle("Event 6").withDescription("Description Event 6").withDateToday().withPrice(65).build();

        Event e7 = anyEvent().withTitle("Event 7").withDescription("Description Event 7").withDateTomorrow().withPrice(567).build();
        Event e8 = anyEvent().withTitle("Event 8").withDescription("Description Event 8").withDateTomorrow().withPrice(987).build();
        Event e9 = anyEvent().withTitle("Event 9").withDescription("Description Event 9").withDateTomorrow().build();

        e1.setType(new MusicEvent());
        e4.setType(new MusicEvent());
        e7.setType(new MusicEvent());
        e1.setUrlImg("http://blog.feebbo.com/wp-content/uploads/2015/10/M%C3%BAsica.jpg");
        e4.setUrlImg("http://blog.feebbo.com/wp-content/uploads/2015/10/M%C3%BAsica.jpg");
        e7.setUrlImg("http://blog.feebbo.com/wp-content/uploads/2015/10/M%C3%BAsica.jpg");

        e2.setType(new MovieEvent());
        e5.setType(new MovieEvent());
        e8.setType(new MovieEvent());
        e2.setUrlImg("http://www.isecpost.com.ar/wp-content/uploads/2015/05/video_cine_10.jpg");
        e5.setUrlImg("http://www.isecpost.com.ar/wp-content/uploads/2015/05/video_cine_10.jpg");
        e8.setUrlImg("http://www.isecpost.com.ar/wp-content/uploads/2015/05/video_cine_10.jpg");

        e3.setType(new FoodEvent());
        e6.setType(new FoodEvent());
        e9.setType(new FoodEvent());
        e3.setUrlImg("https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?w=1260&h=750&auto=compress&cs=tinysrgb");
        e6.setUrlImg("https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?w=1260&h=750&auto=compress&cs=tinysrgb");
        e9.setUrlImg("https://images.pexels.com/photos/2232/vegetables-italian-pizza-restaurant.jpg?w=1260&h=750&auto=compress&cs=tinysrgb");

        generalService.getEventService().save(e1);
        generalService.getEventService().save(e2);
        generalService.getEventService().save(e3);
        generalService.getEventService().save(e4);
        generalService.getEventService().save(e5);
        generalService.getEventService().save(e6);
        generalService.getEventService().save(e7);
        generalService.getEventService().save(e8);
        generalService.getEventService().save(e9);
    }

    private void createImportantEvents(){
        MusicEvent musicEvent1 = new MusicEvent();
        musicEvent1.addMusicGenre(ROCK);
        Event event1 = new Event(new EventData("Black Sabbath en Argentina",
                "Black Sabbath por última vez en vivo en Argentina",
                musicEvent1, 0, new Place("Estadio Velez", ""), new LocalDate(2016, 11, 26), new LocalTime(21, 0),
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

        generalService.getEventService().save(event1);
        generalService.getEventService().save(event2);
        generalService.getEventService().save(event3);
    }

    public void setGeneralService(GeneralService generalService) {
        this.generalService = generalService;
    }
}
