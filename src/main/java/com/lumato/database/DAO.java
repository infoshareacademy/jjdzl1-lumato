package com.lumato.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public abstract class DAO {
    protected Connection connection;

    /** check if DAO is connected to Database */
    public boolean isConnected() {
        return (connection != null) ? true : false;
    }

    /** connect DAO to database if not connected */
    public void connectToDB(){
        if (connection!=null) {
            System.out.println("You are already connected to DB!");
        } else {
            connection = DataBaseConnector.connectToDB();
        }
    }

    /** close connection for DAO object */
    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** get basic DB data */
    public String getMetaData(){
        String metaData = "";
        try {
            DatabaseMetaData dbmd = connection.getMetaData();
            metaData += "DB product: " + dbmd.getDatabaseProductName();
            metaData += "\nDB version: " + dbmd.getDatabaseProductVersion();
            metaData += "\nDriver: " + dbmd.getDriverName();
            metaData += "\nDriver version: " + dbmd.getDriverVersion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metaData;
    }
}
