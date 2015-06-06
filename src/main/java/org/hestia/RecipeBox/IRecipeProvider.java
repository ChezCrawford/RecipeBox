package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.Recipe;

import java.util.Collection;
import java.util.List;

public interface IRecipeProvider
{
    public Collection<Recipe> getRecipes();

    public Collection<Recipe> getRecipesForUser(String userId);

    public Collection<Recipe> getRecipes(List<String> ids);

    public Recipe getRecipeById(String id);

    public void loadRecipes();
}
