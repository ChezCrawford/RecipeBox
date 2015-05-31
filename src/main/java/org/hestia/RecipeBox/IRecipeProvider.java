package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.Recipe;

import java.util.Collection;

public interface IRecipeProvider
{
    public Collection<Recipe> getRecipes();

    public Recipe getRecipeById(int id);

    public void loadRecipes();
}
