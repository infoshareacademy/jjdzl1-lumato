package appnavigation.login;

import main.java.inout.FilePaths;
import tools.AppExit;
import tools.CLS;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
        userPassword = encodeMD5(userPassword);

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
        System.out.print("Niepoprawne hasło! ");
        System.out.print("Hasło musi składać się z minimum 5 znaków. ");
        System.out.println("Hasło nie może zawierać znaku \";\"");
    }

    public static void wrongLoginMessage(){
        System.out.print("Niepoprawny login! ");
        System.out.print("Nazwa użytkownika musi składać się minimum z 4 znaków. ");
        System.out.println("Nazwa użytkownika nie może zawierać znaku \";\".");
    }

    public static void userExistsMessage() {
        System.out.println("Użytkownik o takim nicku już istnieje!");
    }

    //proste szyfrowanie hasła
    public static String encodeMD5(String text) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytesOfMessage = text.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        text = Arrays.toString(thedigest);
        text = text.replaceAll("[, \\]\\[]", "");
        return text; //returns encoded text
    }

    public static boolean checkQuit(String text) throws Exception {
        if ("q".equals(text) || "p".equals(text)) {
            return true;
        } else {
            return false;
        }
    }

    public static void quitSignInSignUp(String text) throws Exception {
        if ("q".equals(text)) {
            CLS.clearScreen();
            AppExit.exitApplication();

        } else if ("p".equals(text)){
            CLS.clearScreen();
            main.java.appnavigation.Shortcuts.runInitialWindow();
        }
    }
}
