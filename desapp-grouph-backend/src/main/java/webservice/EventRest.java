package webservice;

import model.events.Event;
import service.EventService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

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

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
}
