package appdata;

import model.events.Event;
import model.events.EventData;
import model.events.MusicEvent;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import service.GeneralService;

import static model.users.MusicalGenre.*;

public class AppData {

    private GeneralService generalService;

    public void initData() {
        MusicEvent musicEvent1 = new MusicEvent();
        musicEvent1.addMusicGenre(ROCK);
        Event event1 = new Event(new EventData("Black Sabbath en Argentina",
                "Black Sabbath por última vez en vivo en Argentina",
                musicEvent1, 1200, "Estadio Velez", new LocalDate(2016, 11, 26), new LocalTime(21, 0),
                3, "https://i.ytimg.com/vi/Usqq2amB3QE/hqdefault.jpg"));

        MusicEvent musicEvent2 = new MusicEvent();
        musicEvent2.addMusicGenre(ROCK);
        musicEvent2.addMusicGenre(POP);
        musicEvent2.addMusicGenre(REAGGE);
        Event event2 = new Event(new EventData("Lollapalooza Argentina 2017",
                "El Festival donde música, arte, moda, gastronomía y espacios verdes son protagonistas ya tiene fecha para su cuarta edición. Los más chicos también tienen su lugar en el festival en el Kidzapalooza donde pueden vivir la experiencia Lollapalooza a través de la música, diferentes talleres y actividades para toda la familia.",
                musicEvent2, 1500, "Ipódromo de San Isidro", new LocalDate(2017, 3, 31), new LocalTime(14, 0),
                6, "https://cdn.boletius.com/lollapalooza-2017/cover-lolla.jpg"));

        Event event3 = new Event(new EventData("Descendents en Argentina",
                "DESCENDENTS POR FIN EN BUENOS AIRES!!! La banda Californiana llega por primera vez a nuestro país para presentar su nuevo disco \"Hypercaffium Spazzinate\"",
                musicEvent1, 750, "Teatro de Flores", new LocalDate(2016, 12, 4), new LocalTime(20, 0),
                3, "http://www.viamusicos.com.ar/repository/cartelera/7d49e29c1777d06285dca8bee0d21ed8.jpg"));

        generalService.getEventService().save(event1);
        generalService.getEventService().save(event2);
        generalService.getEventService().save(event3);
    }

    public void setGeneralService(GeneralService generalService) {
        this.generalService = generalService;
    }
}
