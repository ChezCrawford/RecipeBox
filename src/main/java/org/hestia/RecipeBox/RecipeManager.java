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
@Produces(MediaType.APPLICATION_JSON)
public class RecipeManager
{
    private IRecipeProvider provider = TestRecipeProvider.Instance;

    @GET
    public Collection<Recipe> getRecipes()
    {
        return this.provider.getRecipes();
    }

    @GET
    @Path("/user/{id}")
    public Collection<Recipe> getRecipesForUser(@PathParam("id") String userId)
    {
        return this.provider.getRecipesForUser(userId);
    }

    @GET
    @Path("{id}")
    public Recipe getRecipe(@PathParam("id") String id)
    {
        return this.provider.getRecipeById(id);
    }
}
