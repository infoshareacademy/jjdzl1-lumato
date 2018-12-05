package main.java.appNavigation.login;

import main.java.inout.FilePaths;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserDataValidation {

    private static String userListPath = FilePaths.getUserListPath();

    public static boolean checkIfUserExists(String userName){
        String line = "";
        boolean userExists = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userListPath));
            String userInCurrentLine;
            while ((line = reader.readLine()) != null){
                userInCurrentLine = line.substring(0, line.indexOf(';'));
                if (userInCurrentLine.equals(userName)){
                    userExists = true;
                    break;
                };
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userExists;
    }

}
