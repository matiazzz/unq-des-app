package web.rest;

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
}
