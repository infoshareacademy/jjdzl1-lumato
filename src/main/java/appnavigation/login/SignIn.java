package appnavigation.login;

import main.java.inout.SessionData;
import main.java.appnavigation.Shortcuts;
import tools.AppExit;
import tools.CLS;
import main.java.inout.UserInput;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

//panel logowania
public class SignIn {

    public static void init() throws Exception {
        boolean loginExists = false;
        boolean passwordMatches = false;
        String userLogin = "";
        String userPassword = "";
        boolean didUserQuit = false;
        while (loginExists == false || passwordMatches == false) {
            showInformation();
            userLogin = askForUserLogin(); //ask for user login
            if (UserDataValidation.checkQuit(userLogin)) break;
            userPassword = askForUserPassword(); //ask for user password
            if (UserDataValidation.checkQuit(userPassword) ) break;
            loginExists = validateLogin(userLogin);
            passwordMatches = validatePassword(userLogin, userPassword);
            if (loginExists == false || passwordMatches == false) {
                CLS.clearScreen();
                System.out.println("Niepoprawny login lub hasło!");
                System.out.println();
                loginExists = false;
                passwordMatches = false;
            }
            if (loginExists && passwordMatches) {
                executeSuccessfulLogin(userLogin);
            }
        }

    }

    private static void showInformation(){
        System.out.println("LOGOWANIE");
        System.out.println("Wpisz 'q' i naciśnij 'enter' aby opuścić program");
        System.out.println("Wpisz 'p' i naciśnij 'enter' aby wrócić do ekranu startowego");
    }

    private static String askForUserLogin() throws IOException {
        System.out.print("PODAJ LOGIN: ");
        return UserInput.getUserStringInput();
    }

    private static String askForUserPassword() throws IOException {
        System.out.print("PODAJ HASŁO: ");
        return UserInput.getUserStringInput();
    }

    private static boolean validateLogin(String userLogin){
        return UserDataValidation.checkIfUserExists(userLogin);
    }

    private static boolean validatePassword(String userLogin, String userPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return UserDataValidation.checkIfPasswordMatches(userLogin, userPassword);
    }

    public static void executeSuccessfulLogin(String userLogin) throws IOException {
        SessionData.saveSessionData(userLogin);
        CLS.clearScreen();
        Shortcuts.runMainMenu();
    }
}
