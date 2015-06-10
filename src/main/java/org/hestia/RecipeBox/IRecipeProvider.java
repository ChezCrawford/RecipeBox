package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.Recipe;

import java.util.Collection;

public interface IRecipeProvider
{
    public Collection<Recipe> getRecipes();

    public Collection<Recipe> getRecipesForUser(String userId);

    public Recipe getRecipeById(String id);

    public void deleteRecipe(String id);

    public void deleteRecipesForUser(String userId);

    public void loadRecipes();
}
