package org.hestia.RecipeBox.model;

import org.bson.types.ObjectId;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class User
{
    private String _name;
    private Date _joinedOn;
    private ObjectId _id;
    private List<Recipe> _myRecipes = new ArrayList<>();
    private List<Recipe> _sharedRecipes = new ArrayList<>();

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public Date getJoinedOn()
    {
        return _joinedOn;
    }

    public void setJoinedOn(Date joinedOn)
    {
        _joinedOn = joinedOn;
    }

    @XmlElement(name = "_id")
    public String getIdStr()
    {
        return _id.toString();
    }

    @XmlTransient
    public ObjectId getId()
    {
        return _id;
    }

    public void setId(ObjectId id)
    {
        _id = id;
    }

    public List<Recipe> getMyRecipes()
    {
        return _myRecipes;
    }

    public void setMyRecipes(List<Recipe> myRecipes)
    {
        _myRecipes = myRecipes;
    }

    public List<Recipe> getSharedRecipes()
    {
        return _sharedRecipes;
    }

    public void setSharedRecipes(List<Recipe> sharedRecipes)
    {
        _sharedRecipes = sharedRecipes;
    }
}
