package webservice;

import model.events.FoodEvent;
import model.users.FoodType;
import model.users.MovieGenre;
import model.users.MusicalGenre;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/appData")
public class AppDataRest {

	@GET
	@Path("/musicGenres")
	@Produces("application/json")
	public Response getMusicGenres() {
		MusicalGenre[] musicalGenres = MusicalGenre.values();
		return Response.ok(musicalGenres).build();
	}

	@GET
	@Path("/movieGenres")
	@Produces("application/json")
	public Response getMovieGenres() {
		MovieGenre[] movieGenres = MovieGenre.values();
		return Response.ok(movieGenres).build();
	}

	@GET
	@Path("/foodTypes")
	@Produces("application/json")
	public Response getFoodTypes() {
		FoodType[] foodTypes = FoodType.values();
		return Response.ok(foodTypes).build();
	}
}
