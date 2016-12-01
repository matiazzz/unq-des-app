package webservice;

import model.events.Event;
import model.users.Profile;
import model.users.User;
import static model.builders.UserBuilder.*;

import service.EventService;
import service.UserService;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRest {

    private UserService userService;
    private EventService eventService;

    @GET
    @Path("/getByName/{name}")
    @Produces("application/json")
    public Response findUsersByName(@PathParam("name") String name){
        List<User> users = userService.findByName(name);
        if (users.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(users).build();
    }

    @GET
    @Path("/getProfile/{userName}")
    @Produces("application/json")
    public Response getProfileByUserName(@PathParam("userName") String userName) {
        Profile profile = userService.getProfileByUserName(userName);
        if (profile == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(profile).build();
    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Response getAllUsers() {
        List<User> users = userService.retriveAll();
        if (users.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(users).build();
    }

    @GET
    @Path("/{idUser}")
    @Produces("application/json")
    public Response getUserById(@PathParam("idUser") final int idUser) {
        User user = userService.findByID(idUser);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @GET
    @Path("/getByUsername/{username}")
    @Produces("application/json")
    public Response getUserByUsername(@PathParam("username") final String username) {
        try {
            User user = userService.findByUserName(username);
            return Response.ok(user).build();
        }
        catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/newUser")
    @Produces("application/json")
    public Response createUser(@FormParam("userName") String userName) {
        User user = anyUser().withUserName(userName).build();
        userService.save(user);
        return Response.ok().build();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
