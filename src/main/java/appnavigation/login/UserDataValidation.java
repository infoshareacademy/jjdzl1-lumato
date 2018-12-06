package appnavigation.login;

import inout.FilePaths;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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


    public static void wrongPasswordMessage(){
        System.out.println("Niepoprawne hasło!");
        System.out.println("Hasło musi składać się z minimum 5 znaków.");
        System.out.println("Hasło nie może zawierać znaku \";\"");
    }

    public static void wrongLoginMessage(){
        System.out.println("Niepoprawny login!");
        System.out.println("Nazwa użytkownika musi składać się minimum z 4 znaków.");
        System.out.println("Nazwa użytkownika nie może zawierać znaku \";\".");
    }

    public static void userExistsMessage() {
        System.out.println("Użytkownik o takim nicku już istnieje!");
    }
}
