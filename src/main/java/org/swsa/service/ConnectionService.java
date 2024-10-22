package org.swsa.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService
{
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student1";
            String username = "root";
            String password = "Prakash@123";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        }
        catch (SQLException e)
        {
            System.out.println("Connection error: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}