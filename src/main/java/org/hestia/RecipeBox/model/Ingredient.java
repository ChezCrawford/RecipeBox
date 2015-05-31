package org.hestia.RecipeBox.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ingredient
{
    private String ingredient;
    private String amount;

    public String getIngredient()
    {
        return this.ingredient;
    }

    public void setIngredient(String ingredient)
    {
        this.ingredient = ingredient;
    }

    public String getAmount()
    {
        return this.amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }
}
