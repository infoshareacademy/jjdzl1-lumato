package com.lumato.database;

import java.sql.*;
import java.util.*;

public class UserDAO extends DAO {

    public UserDAO() {
        connection = DataBaseConnector.connectToDB();
    }

    public LinkedList<User> getAllUsers(){
        LinkedList<User> allUsersList = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User tempUser = new User();
                fillUserProperties(resultSet, tempUser);
                allUsersList.add(tempUser);
            }
        } catch (SQLException e) {
            System.out.println("Problem whith DB connection");
            e.printStackTrace();
        }
        return allUsersList;
    }

    private void fillUserProperties(ResultSet resultSet, User tempUser) {
        try {
            tempUser.setUserId(resultSet.getInt("user_id"));
            tempUser.setUserLogin(resultSet.getString("user_login"));
            tempUser.setUserPassword(resultSet.getString("user_password"));
            if (resultSet.getString("user_email") != null) {
                tempUser.setUserEmail(resultSet.getString("user_email"));
            }
            Calendar lastLogin = Calendar.getInstance();
            if (resultSet.getDate("user_last_login") != null) {
                lastLogin.setTime(resultSet.getDate("user_last_login"));
            }
            tempUser.setUserLastLogin(lastLogin);
            tempUser.setUserBlocked(resultSet.getBoolean("user_blocked"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
