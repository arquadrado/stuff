package org.academiadecodigo.antonio.app.model;

import org.academiadecodigo.antonio.app.persistence.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cadet on 05/11/15.
 */
public class JdbcUserService implements UserService {

    private ConnectionManager connectionManager = new ConnectionManager();
    private Connection dbConnection = connectionManager.getDbConnection();
    private Statement statement;
    private ResultSet resultSet;



    @Override
    public boolean authenticate(String username, String password) {

        String dbUsername = null;
        String dbPassword = null;



        try {
            statement = dbConnection.createStatement();
            String query = "select username, password from users where username = '" + username + "';";
            resultSet = statement.executeQuery(query);

            System.out.println(query);

            if(resultSet.next()){
               dbUsername = resultSet.getString("username");
               dbPassword = resultSet.getString("password");
                System.out.println(resultSet.getString("username"));
            }

        } catch (SQLException e) {
           System.out.println("Failed to create statement");
        }

//        System.out.println(dbUsername.equals(username) && dbPassword.equals(password));

        return dbUsername.equals(username) && dbPassword.equals(password);


    }

    @Override
    public void addUser(User user) {
        String userUsername = user.getUsername();
        String userPass = user.getPassword();
        String userEmail = user.getEmail();

        try {
            statement = dbConnection.createStatement();
            System.out.println("statement ok");

            String query = "INSERT INTO users (username, password, email) VALUES ('" + userUsername + "', '" + userPass + "', '" + userEmail + "');";
            System.out.println(query);
            statement.execute(query);


        } catch (SQLException e) {
            System.out.println("Failed to create statement");
        }

    }

    @Override
    public User findbyName(String name) {

        try {
            statement = dbConnection.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + name + "';";
            System.out.println(query);
            resultSet = statement.executeQuery(query);


            if(resultSet.next()){

                return new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("email"));

            }



        } catch (SQLException e) {
            System.out.println("User not found");
        }
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
