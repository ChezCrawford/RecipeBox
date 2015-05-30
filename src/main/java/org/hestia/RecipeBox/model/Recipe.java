package org.hestia.RecipeBox.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Recipe
{
    private int id;
    private String title;

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public Recipe(int id, String title)
    {
        this.id = id;
        this.title = title;
    }
}
