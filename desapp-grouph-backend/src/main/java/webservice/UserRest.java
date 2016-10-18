package webservice;

import model.users.Profile;
import model.users.User;
import static model.builders.UserBuilder.*;
import service.UserService;
import java.util.List;

import javax.ws.rs.*;

@Path("/user")
public class UserRest {

    private UserService service;

    @GET
    @Path("/users/{name}")
    @Produces("application/json")
    public List<User> findUsersByName(@PathParam("name") String name){
        return service.findByName(name);
    }

    @GET
    @Path("/user/{userName}")
    @Produces("application/json")
    public User findUserByUserName(@PathParam("userName") String userName) { return service.findByUserName(userName); }

    @GET
    @Path("/userProfile/{userName}")
    @Produces("application/json")
    public Profile getProfileByUserName(@PathParam("userName") String userName) {return service.getProfileByUserName(userName); }

    @GET
    @Path("/user/{id}")
    @Produces("application/json")
    public User findUserByID(@PathParam("id") int id) {return service.findByID(id); }

    @GET
    @Path("/users")
    @Produces("application/json")
    public List<User> getAllUsers() { return service.retriveAll(); }

    @POST
    @Path("/newUser")
    @Produces("application/json")
    public User createUser(@FormParam("userName") String userName) {
        User user = anyUser().withUserName(userName).build();
        service.save(user);
        return user;
    }
}
