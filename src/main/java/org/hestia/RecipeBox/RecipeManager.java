package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.Recipe;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

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
    @Path("/user/{id}")
    public Collection<Recipe> getRecipesForUser(@PathParam("id") String userId)
    {
        return this.provider.getRecipesForUser(userId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Recipe> getRecipes(@QueryParam("id") List<String> ids)
    {
        return this.provider.getRecipes(ids);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Recipe getRecipe(@PathParam("id") String id)
    {
        return this.provider.getRecipeById(id);
    }
}
