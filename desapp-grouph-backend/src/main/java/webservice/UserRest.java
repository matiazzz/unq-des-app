package webservice;

import model.users.Profile;
import model.users.User;
import service.UserService;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

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
}
