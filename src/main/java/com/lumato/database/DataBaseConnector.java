package com.lumato.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnector {

    public static Connection connectToDB(){
        Connection connection = null;
        Properties dbProperties = new Properties();
        try {
            dbProperties.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    dbProperties.getProperty("dburl"),
                    dbProperties.getProperty("user"),
                    dbProperties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
