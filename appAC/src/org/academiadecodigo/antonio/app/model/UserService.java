package org.academiadecodigo.antonio.app.model;

/**
 * Created by cadet on 02/11/15.
 */
public interface UserService {

    boolean authenticate(String username, String password);

    void addUser(User user);

    User findbyName(String name);

    int count();


}
