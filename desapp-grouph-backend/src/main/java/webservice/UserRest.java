package webservice;

import model.users.Profile;
import model.users.User;
import static model.builders.UserBuilder.*;
import service.UserService;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRest {

    private UserService userService;

    @GET
    @Path("/getByName/{name}")
    @Produces("application/json")
    public List<User> findUsersByName(@PathParam("name") String name){
        return userService.findByName(name);
    }

    @GET
    @Path("/getByUsername/{userName}")
    @Produces("application/json")
    public User findUserByUserName(@PathParam("userName") String userName) {
        return userService.findByUserName(userName);
    }

    @GET
    @Path("/getProfile/{userName}")
    @Produces("application/json")
    public Profile getProfileByUserName(@PathParam("userName") String userName) {
        return userService.getProfileByUserName(userName);
    }

    @GET
    @Path("/getById/{id}")
    @Produces("application/json")
    public User findUserByID(@PathParam("id") int id) {
        return userService.findByID(id);
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

    @POST
    @Path("/newUser")
    @Produces("application/json")
    public User createUser(@FormParam("userName") String userName) {
        User user = anyUser().withUserName(userName).build();
        userService.save(user);
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
