package webservice;

import model.events.Event;
import model.events.MusicEvent;
import model.events.Place;
import model.users.MusicalGenre;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import service.EventService;
import webservice.dtos.SizeClass;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static model.builders.EventBuilder.anyEvent;

@Path("/event")
public class EventRest {

	private EventService eventService;

	@GET
	@Path("/mostPopular")
	@Produces("application/json")
	public Response getMostPopular() {
		List<Event> events = eventService.mostPopular();
		if (events.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
		return Response.ok(events).build();
	}

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public Response getAll() {
		List<Event> events = eventService.getAll();
		if (events.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
		return Response.ok(events).build();
	}

	@GET
	@Path("/size")
	@Produces("application/json")
	public Response size() {
		SizeClass size = new SizeClass(eventService.size());

		return Response.ok(size).build();
	}

	@GET
	@Path("/get/{page}/{sizePage}")
	@Produces("application/json")
	public Response get(@PathParam("page") final int page, @PathParam("sizePage") final int sizePage) {
		List<Event> events = eventService.getAll()
				.stream().skip((page-1) * sizePage).limit(sizePage).collect(Collectors.toList());
		return Response.ok(events).build();
	}

	@GET
	@Path("/musicEvents/{page}/{sizePage}")
	@Produces("application/json")
	public Response getMusicEvents(@PathParam("type") final int type, @PathParam("page") final int page, @PathParam("sizePage") final int sizePage) {
		List<Event> events = eventService.getMusicEvents();
		return Response.ok(events).build();
	}

	@GET
	@Path("/{idEvent}")
	@Produces("application/json")
	public Response getById(@PathParam("idEvent") final int idEvent) {
		Event event = eventService.getById(idEvent);
		if (event == null) return Response.status(Response.Status.NOT_FOUND).build();
		return Response.ok(event).build();
	}

	@POST
	@Path("/newEvent")
	@Produces("application/json")
	public Response createEvent(@FormParam("title") String title,
								@FormParam("description") String description,
								@FormParam("imgUrl") String imgUrl,
								@FormParam("day") int day,
								@FormParam("month") int month,
								@FormParam("year") int year,
								@FormParam("hour") int hour,
								@FormParam("minutes") int minutes,
								@FormParam("price") int price,
								@FormParam("placeName") String placeName,
								@FormParam("placeAddress") String placeAddress) {
		
		LocalDate date = new LocalDate(year, month, day);
		LocalTime time = new LocalTime(hour, minutes);
		Event event = anyEvent()
				.withTitle(title)
				.withDescription(description)
				.withImgUrl(imgUrl)
				.withDate(date)
				.withTime(time)
				.withPrice(price)
				.withPlace(new Place(placeName, placeAddress))
				.build();
		eventService.save(event);
		return Response.ok().build();
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
}
