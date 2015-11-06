package org.academiadecodigo.antonio.app.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by cadet on 05/11/15.
 */
public class ConnectionManager {


    Connection dbConnection;


    public Connection getDbConnection() {


        if (dbConnection == null) {
            System.out.println("new connection");

            try {
                return dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ac", "root", "");
            } catch (SQLException e) {

                System.out.println("Failure to connect to database : " + e.getMessage());
            }
        }

        return dbConnection;


    }

    public void close() {
        try {
            if (dbConnection!= null) {
                dbConnection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }
}