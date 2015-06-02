package org.hestia.RecipeBox;

import org.bson.types.ObjectId;
import org.hestia.RecipeBox.model.Recipe;

import java.util.Collection;

public interface IRecipeProvider
{
    public Collection<Recipe> getRecipes();

    public Recipe getRecipeById(ObjectId id);

    public void loadRecipes();
}
