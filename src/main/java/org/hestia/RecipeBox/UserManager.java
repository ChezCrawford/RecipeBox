package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Component
@Path("/users")
public class UserManager
{
    private IUserProvider _users = TestRecipeProvider.Instance;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getUsers()
    {
        return _users.getUsers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User getUser(@PathParam("id") String id)
    {
        return _users.getUser(id);
    }
}
