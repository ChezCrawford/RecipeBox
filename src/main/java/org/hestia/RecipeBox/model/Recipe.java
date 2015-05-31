package org.hestia.RecipeBox.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class Recipe
{
    private int id;
    private String title;
    private String createdBy;
    private Date createdDate;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Direction> directions = new ArrayList<>();

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    public List<Ingredient> getIngredients()
    {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredientList)
    {
        this.ingredients = ingredientList;
    }

    public List<Direction> getDirections()
    {
        return directions;
    }

    public void setDirections(List<Direction> directions)
    {
        this.directions = directions;
    }

    public Recipe(int id, String title)
    {
        this.id = id;
        this.title = title;
    }
}
