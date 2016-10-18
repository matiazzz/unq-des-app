package webservice;

import model.users.Profile;
import model.users.User;
import service.UserService;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/user")
public class UserRest {

    private UserService service;

    @GET
    @Path("/users/{name}")
    @Produces("application/json")
    public List<User> findUsersByName(String name){
        return service.findByName(name);
    }

    @GET
    @Path("/user/{userName}")
    @Produces("application/json")
    public User findUserByUserName(String userName) { return service.findByUserName(userName); }

    @GET
    @Path("/userProfile/{userName}")
    @Produces("application/json")
    public Profile getProfileByUserName(String userName) {return service.getProfileByUserName(userName); }

    @GET
    @Path("/user/{ID}")
    @Produces("application/json")
    public User findUserByID(int id) {return service.findByID(id); }
}
