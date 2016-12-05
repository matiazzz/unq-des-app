package webservice;

import model.events.Event;
import model.events.Place;
import model.users.User;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import service.EventService;
import service.UserService;
import webservice.dtos.SizeClass;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static model.builders.EventBuilder.anyEvent;

@Path("/event")
public class EventRest {

	private EventService eventService;
	private UserService userService;

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
		Paginator paginator = new Paginator(eventService.getAll());
		return Response.ok(paginator.getPage(page, sizePage)).build();
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

	@GET
	@Path("/search/{word}/{page}/{sizePage}")
	@Produces("application/json")
	public Response searchPage(@PathParam("word") final String word, @PathParam("page") final int page, @PathParam("sizePage") final int sizePage) {
		Paginator paginator = new Paginator(eventService.search(word));
		if (paginator.getPage(page, sizePage).isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
		return Response.ok(paginator.getPage(page, sizePage)).build();
	}

	@GET
	@Path("/search/{word}")
	@Produces("application/json")
	public Response search(@PathParam("word") final String word) {
		List<Event> events = eventService.search(word);
		if (events.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
		return Response.ok(events).build();
	}

	@GET
	@Path("/searchSize/{word}")
	@Produces("application/json")
	public Response searchSize(@PathParam("word") final String word) {
		SizeClass size = new SizeClass(eventService.search(word).size());
		return Response.ok(size).build();
	}

	@POST
	@Path("/newEvent")
	@Produces("application/json")
	public Response createEvent(@FormParam("username") String username,
								@FormParam("title") String title,
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

		try {
			User user = userService.findByUserName(username);
			user.addEvent(event);
			eventService.save(event);
			userService.update(user);
		}
		catch (Exception e){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.ok().build();
	}

	@POST
	@Path("/attend")
	@Produces("application/json")
	public Response attendToEvent(@FormParam("username") String username, @FormParam("idEvent") int idEvent) {

			User user = userService.findByUserName(username);
			Event event = eventService.getById(idEvent);
			event.addAttendee(user);
			eventService.update(event);
			userService.update(user);


		return Response.ok().build();
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
