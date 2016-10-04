package web.rest;

import model.events.Event;
import model.events.EventData;
import model.events.FoodEvent;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/events")
public class EventRest {

	@GET
	@Path("/example")
	@Produces("text/plain")
	public String example(){
		return "Works!";
	}

	@GET
	@Path("/example2")
	@Produces("application/json")
	public Event example2(){
		FoodEvent foodEvent = new FoodEvent();
		EventData ed = new EventData("Salida", "Con amigos", foodEvent, 100,
				"Calle 25, La Plata", new LocalDate(), new LocalTime(), 2);
		Event event = new Event(ed);
		return event;
	}
}
