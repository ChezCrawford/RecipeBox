package org.hestia.RecipeBox.model;

import org.bson.types.ObjectId;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class User
{
    private String _name;
    private Date _joinedOn;
    private ObjectId _id;
    private List<String> _friends = new LinkedList<>();
    private List<Collection> _collections = new LinkedList<>();

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

    public List<String> getFriends()
    {
        return _friends;
    }

    public void setFriends(List<String> friends)
    {
        _friends = friends;
    }

    public List<Collection> getCollections()
    {
        return _collections;
    }

    public void setCollections(List<Collection> collections)
    {
        _collections = collections;
    }
}
