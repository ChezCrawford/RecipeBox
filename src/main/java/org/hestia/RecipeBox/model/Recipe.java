package org.hestia.RecipeBox.model;

import org.bson.types.ObjectId;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class Recipe
{
    private ObjectId _id;
    private String _title;
    private ObjectId _createdBy;
    private Date _createdDate;
    private List<Ingredient> _ingredients = new LinkedList<>();
    private List<Direction> _directions = new LinkedList<>();
    private List<String> _sharedWith = new LinkedList<>();
    private List<String> _tags = new LinkedList<>();

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

    // JAM - is this XmlTransient annotation necessary?
    @XmlTransient
    public void setId(ObjectId id)
    {
        _id = id;
    }

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String title)
    {
        _title = title;
    }

    @XmlElement(name = "createdBy")
    public String getCreatedByStr()
    {
        return _createdBy.toString();
    }

    @XmlTransient
    public ObjectId getCreatedBy()
    {
        return _createdBy;
    }

    public void setCreatedBy(ObjectId createdBy)
    {
        _createdBy = createdBy;
    }

    public Date getCreatedDate()
    {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        _createdDate = createdDate;
    }

    public List<Ingredient> getIngredients()
    {
        return _ingredients;
    }

    public void setIngredients(List<Ingredient> ingredientList)
    {
        _ingredients = ingredientList;
    }

    public List<Direction> getDirections()
    {
        return _directions;
    }

    public void setDirections(List<Direction> directions)
    {
        _directions = directions;
    }

    public List<String> getSharedWith()
    {
        return _sharedWith;
    }

    public void setSharedWith(List<String> sharedWith)
    {
        _sharedWith = sharedWith;
    }

    public Recipe(ObjectId id, String title)
    {
        _id = id;
        _title = title;
    }

    public List<String> getTags()
    {
        return _tags;
    }

    public void setTags(List<String> tags)
    {
        _tags = tags;
    }
}
