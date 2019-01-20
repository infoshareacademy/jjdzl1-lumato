package com.lumato.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public abstract class DAO {
    protected Connection connection;

    public boolean isConnected() {
        return (connection != null) ? true : false;
    }

    public void connectToDB(){
        if (connection!=null) {
            System.out.println("You are already connected to DB!");
        } else {
            connection = DataBaseConnector.connectToDB();
        }
    }

    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DatabaseMetaData getMetaData(){
        DatabaseMetaData metaData = null;
        try {
            metaData = connection.getMetaData();
        } catch (SQLException e) {
            System.out.println("Counldn't obtain DatabaseMetaData object");
            e.printStackTrace();
        }
        return metaData;
    }
}
