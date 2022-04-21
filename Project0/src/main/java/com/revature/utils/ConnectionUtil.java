package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil 
{
    //This method will eventually return an object of type Connection, which we'll use to connect to our databse
    public static Connection getConnection() throws SQLException{
        //For compatibility with other technologies/frameworks, we'll need to register our PostgreSQL driver
        //This process makes the application aware of what Driver class we're using
        try {
            Class.forName("org.postgresql.Driver");
            //searching for the postgres driver, which we have as a dependency
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //This tells in the console us what went wrong
            System.out.println("problem occurred locating driver");
        }

        //I'm going to put the credentials in Strings, and use those strings in a method that gets connections
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=bank";
        String username = "rabin";
        String password = "password";

        //This return statement is what returns out actual database Connection object
        //Note how this getConnection() method has a return type of Connection
        return DriverManager.getConnection(url, username, password);
    }

    // close postgreSQL database connection
    public static void close(Connection con, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public static void close(Connection con, Statement stmt, ResultSet rset) {
        try {
            if (rset != null) {
                rset.close();
                rset = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}