package org.hestia.RecipeBox;

import org.hestia.RecipeBox.model.User;

import java.util.Collection;


public interface IUserProvider
{
    public Collection<User> getUsers();

    public User getUser(String userId);

    public void deleteUser(String id);

    public void loadUsers();
}
