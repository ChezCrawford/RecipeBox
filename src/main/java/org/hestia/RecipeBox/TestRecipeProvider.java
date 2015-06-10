package org.hestia.RecipeBox;

import org.bson.types.ObjectId;
import org.hestia.RecipeBox.model.Direction;
import org.hestia.RecipeBox.model.Ingredient;
import org.hestia.RecipeBox.model.Recipe;
import org.hestia.RecipeBox.model.User;

import java.util.*;

public class TestRecipeProvider implements IRecipeProvider, IUserProvider
{
    private HashMap<ObjectId, Recipe> _recipes = new HashMap<>();
    private HashMap<ObjectId, User> _users = new HashMap<>();

    public static TestRecipeProvider Instance = new TestRecipeProvider();

    public  TestRecipeProvider()
    {
        this.loadUsers();
        this.loadRecipes();
    }

    @Override
    public Collection<Recipe> getRecipes()
    {
        return this._recipes.values();
    }

    @Override
    public Collection<Recipe> getRecipesForUser(String userId)
    {
        ObjectId toComp = new ObjectId(userId);
        Collection<Recipe> ret = new LinkedList<>();
        for (Recipe recipe : this._recipes.values())
        {
            if (recipe.getCreatedBy().equals(toComp))
            {
                ret.add(recipe);
            }
        }
        return ret;
    }

    @Override
    public Recipe getRecipeById(String id)
    {
        return this._recipes.get(new ObjectId(id));
    }

    @Override
    public void loadRecipes()
    {
        for (User user : _users.values())
        {
            Recipe sample = new Recipe(ObjectId.get(), "My first recipe");
            sample.setCreatedBy(user.getId());
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

            this._recipes.put(sample.getId(), sample);

            sample = new Recipe(ObjectId.get(), "My second recipe");
            sample.setCreatedBy(user.getId());
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

            this._recipes.put(sample.getId(), sample);
        }
    }

    @Override
    public void deleteRecipesForUser(String userId)
    {
        List<ObjectId> toRemove = new LinkedList<>();
        for (Recipe recipe : _recipes.values())
        {
            if (recipe.getCreatedByStr() == userId)
            {
                toRemove.add(recipe.getId());
            }
        }

        for (ObjectId id : toRemove)
        {
            _recipes.remove(id);
        }
    }

    @Override
    public void deleteRecipe(String id)
    {
        _recipes.remove(new ObjectId(id));
    }

    @Override
    public Collection<User> getUsers()
    {
        return  _users.values();
    }

    @Override
    public User getUser(String userId)
    {
        return _users.get(new ObjectId(userId));
    }

    @Override
    public void loadUsers()
    {
        User toAdd = new User();
        toAdd.setId(ObjectId.get());
        toAdd.setName("Bill Bob");
        toAdd.setJoinedOn(new Date());

        _users.put(toAdd.getId(), toAdd);

        toAdd = new User();
        toAdd.setId((ObjectId.get()));
        toAdd.setName("Donald R. Dicico");
        toAdd.setJoinedOn(new Date());

        _users.put(toAdd.getId(), toAdd);
    }

    @Override
    public void deleteUser(String id)
    {
        _users.remove(new ObjectId(id));
    }
}
