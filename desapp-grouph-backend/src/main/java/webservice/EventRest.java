package webservice;

import model.events.Event;
import service.EventService;
import webservice.dtos.SizeClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

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

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
}
