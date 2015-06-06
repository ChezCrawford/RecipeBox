package org.hestia.RecipeBox;

import org.bson.types.ObjectId;
import org.hestia.RecipeBox.model.Direction;
import org.hestia.RecipeBox.model.Ingredient;
import org.hestia.RecipeBox.model.Recipe;

import java.util.*;

public class TestRecipeProvider implements IRecipeProvider
{
    private HashMap<ObjectId, Recipe> cache = new HashMap<>();

    public  TestRecipeProvider()
    {
        this.loadRecipes();
    }

    @Override
    public Collection<Recipe> getRecipes()
    {
        return this.cache.values();
    }

    @Override
    public Collection<Recipe> getRecipesForUser(String userId)
    {
        ObjectId toComp = new ObjectId(userId);
        Collection<Recipe> ret = new LinkedList<>();
        for (Recipe recipe : this.cache.values())
        {
            if (recipe.getCreatedBy().equals(toComp))
            {
                ret.add(recipe);
            }
        }
        return ret;
    }

    @Override
    public Collection<Recipe> getRecipes(List<String> ids)
    {
        Collection<Recipe> ret = new LinkedList<>();
        for (String id : ids)
        {
            ObjectId objectId = new ObjectId(id);
            Recipe recipe = this.cache.get(objectId);
            if (recipe != null)
            {
                ret.add(recipe);
            }
        }
        return ret;
    }

    @Override
    public Recipe getRecipeById(String id)
    {
        return this.cache.get(new ObjectId(id));
    }

    @Override
    public void loadRecipes()
    {
        Recipe sample = new Recipe(ObjectId.get(), "My first recipe");
        sample.setCreatedBy(ObjectId.get());
        String userId1 = sample.getCreatedByStr();
        sample.setCreatedDate(new Date());
        Ingredient ingredient = new Ingredient();
        ingredient.setAmount("1/2 tsp");
        ingredient.setIngredient("ore-gano");
        sample.getIngredients().add(ingredient);

        Direction direction = new Direction();
        direction.setInstruction("Do some stuff");
        direction.setStep(1);
        sample.getDirections().add(direction);
        direction = new Direction();
        direction.setInstruction("Make it good");
        direction.setStep(2);
        sample.getDirections().add(direction);

        this.cache.put(sample.getId(), sample);

        sample = new Recipe(ObjectId.get(), "My second recipe");
        sample.getSharedWith().add(userId1);
        sample.setCreatedBy(ObjectId.get());
        sample.setCreatedDate(new Date());
        ingredient = new Ingredient();
        ingredient.setAmount("1/2 tsp");
        ingredient.setIngredient("Jai-la-pain-yo");
        sample.getIngredients().add(ingredient);

        ingredient = new Ingredient();
        ingredient.setAmount("1/2 cup");
        ingredient.setIngredient("cheddar cheese");
        sample.getIngredients().add(ingredient);

        direction = new Direction();
        direction.setInstruction("Do something different this time.");
        direction.setStep(1);
        sample.getDirections().add(direction);
        direction = new Direction();
        direction.setInstruction("And as always, kill Hitler!");
        direction.setStep(2);
        sample.getDirections().add(direction);

        this.cache.put(sample.getId(), sample);
    }

}
