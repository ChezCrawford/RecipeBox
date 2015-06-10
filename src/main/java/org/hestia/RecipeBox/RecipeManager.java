package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.Recipe;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Component
@Path("/recipes")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeManager
{
    private IRecipeProvider provider = new TestRecipeProvider();

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
