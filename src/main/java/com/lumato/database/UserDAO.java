package com.lumato.database;

import java.sql.*;
import java.util.*;

public class UserDAO extends DAO {

    public UserDAO() {
        connection = DataBaseConnector.connectToDB();
    }

    public int countRecords(){
        int recordCount = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(*) as RECORDCOUNT FROM users");
            if (resultSet.next()) {
                recordCount = resultSet.getInt("RECORDCOUNT");
            }
        } catch (SQLException e) {
            System.out.println("Problem whith DB connection");
            e.printStackTrace();
        }
        return recordCount;
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

    public void addNewUser(User newUser) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users VALUES(NULL, ?, ?, ?, ?, FALSE)");
            statement.setString(1, newUser.getUserLogin());
            statement.setString(2, newUser.getUserPassword());
            statement.setNull(3, Types.VARCHAR);
            if (newUser.getUserLastLogin() != null) {
                java.util.Date date = newUser.getUserLastLogin().getTime();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                statement.setDate(4, sqlDate);
            } else {
                statement.setNull(4, java.sql.Types.DATE);

            }
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillUserProperties(ResultSet resultSet, User tempUser) {
        try {
            tempUser.setUserId(resultSet.getInt("user_id"));
            tempUser.setUserLogin(resultSet.getString("user_login"));
            tempUser.setUserPassword(resultSet.getString("user_password"));
            if (resultSet.getString("user_email") != null) {
                tempUser.setUserEmail(resultSet.getString("user_email"));
            } else {
                tempUser.setUserEmail("no-email");
            }
            Calendar lastLogin = Calendar.getInstance();
            if (resultSet.getDate("user_last_login") != null) {
                lastLogin.setTime(resultSet.getDate("user_last_login"));
            } else {
                lastLogin.set(9999,8,9);
            }
            tempUser.setUserLastLogin(lastLogin);
            tempUser.setUserBlocked(resultSet.getBoolean("user_blocked"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
