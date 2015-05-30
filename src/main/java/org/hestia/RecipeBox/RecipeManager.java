package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.Recipe;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/recipes")
public class RecipeManager
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> getRecipes()
    {
        Recipe sample = new Recipe(1, "My first recipe.");

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(sample);

        return recipes;
    }
}
