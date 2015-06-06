package org.hestia.RecipeBox.model;

import org.bson.types.ObjectId;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class Collection
{
    private ObjectId _id;
    private String _name;
    private List<String> _recipes = new LinkedList<>();

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

    @XmlElement(name = "_id")
    public void setIdFromStr(String id)
    {
        _id = new ObjectId(id);
    }

    @XmlTransient
    public void setId(ObjectId id)
    {
        _id = id;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public List<String> getRecipes()
    {
        return _recipes;
    }

    public void setRecipes(List<String> recipes)
    {
        _recipes = recipes;
    }
}
