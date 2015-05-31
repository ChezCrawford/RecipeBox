package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.Recipe;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Component
@Path("/recipes")
public class RecipeManager
{
    private IRecipeProvider provider = new TestRecipeProvider();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Recipe> getRecipes()
    {
        return this.provider.getRecipes();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Recipe getRecipeById(@PathParam("id") Integer id)
    {
        return this.provider.getRecipeById(id);
    }
}
