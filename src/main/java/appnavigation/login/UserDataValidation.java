package main.java.appNavigation.login;

import main.java.inout.FilePaths;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserDataValidation {

    private static String userListPath = FilePaths.getUserListPath();

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

    public static boolean checkIfPasswordMatches(String userLogin, String userPassword){
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

}
