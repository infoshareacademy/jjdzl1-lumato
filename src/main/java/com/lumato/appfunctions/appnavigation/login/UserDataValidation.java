package com.lumato.appfunctions.appnavigation.login;

import com.lumato.inout.FilePaths;

import java.io.*;
import java.security.NoSuchAlgorithmException;

public class UserDataValidation {

    private static String userListPath = FilePaths.getUserListPath();

    //SignIn login validation
    public static boolean checkIfUserExists(String userLogin){
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userListPath));
            String userInCurrentLine;
            while ((line = reader.readLine()) != null){
                userInCurrentLine = line.substring(0, line.indexOf(';'));
                if (userInCurrentLine.equals(userLogin)){
                    return true;
                };
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //SignIn password validation
    public static boolean checkIfPasswordMatches(String userLogin, String userPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        userPassword = Encoding.encodeMD5(userPassword);
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userListPath));
            String userInCurrentLine;
            String goodPassword;
            while ((line = reader.readLine()) != null){
                userInCurrentLine = line.substring(0, line.indexOf(';'));
                if (userInCurrentLine.equals(userLogin)){
                    goodPassword = line.substring(line.indexOf(';')+1);
                    if (goodPassword.equals(userPassword)) {
                        return true;
                    }
                };
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkIfPasswordIsOk(String attemptedPassword){
        if (attemptedPassword.length() < 5) {
            return false;
        }
        if (attemptedPassword.contains(";")){
            return false;
        }
        return true;
    }

    public static boolean checkIfLoginIsOk(String attemptedLogin){
        if (attemptedLogin.length() < 4) {
            return false;
        }
        if (attemptedLogin.contains(";")){
            return false;
        }
        return true;
    }
}
