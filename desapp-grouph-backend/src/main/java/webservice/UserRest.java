package webservice;

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
    @Path("/users")
    @Produces("application/json")
    public List<User> findUsersByName(String name){
        return service.findByName(name);
    }

}
