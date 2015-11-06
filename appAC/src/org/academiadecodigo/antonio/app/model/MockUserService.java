package org.academiadecodigo.antonio.app.model;

import java.util.HashMap;

/**
 * Created by cadet on 02/11/15.
 */
public class MockUserService implements UserService {

    private HashMap<String, User> dataBase;

    public MockUserService(){

        dataBase = new HashMap<>();
    }


    @Override
    public boolean authenticate(String username, String password) {

        return dataBase.containsKey(username) && dataBase.get(username).getPassword().equals(password);

    }

    @Override
    public void addUser(User user) {
        dataBase.put(user.getUsername(), user);
    }

    @Override
    public User findbyName(String name) {

        return dataBase.get(name);
    }

    @Override
    public int count() {
        return dataBase.size();
    }


}
