package com.lumato.database;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;


@Getter @Setter public class User {

    public static final String USER_EMAIL_NONE = null;
    public static final Calendar USER_LAST_LOGIN_NONE = null;

    private int userId;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private Calendar userLastLogin;
    private boolean userBlocked;

    public User(){

    }

    public User(int userId, String userName, String userPassword, String userEmail, Calendar userLastLogin, boolean userBlocked) {
        this.userId = userId;
        this.userLogin = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userLastLogin = userLastLogin;
        this.userBlocked = userBlocked;
    }

    @Override
    public String toString() {
        return String.format("\n%-4d %-16s %-20s %-30s %-20tF %b",
                userId,
                userLogin,
                userPassword,
                userEmail,
                userLastLogin,
                userBlocked);
    }
}
