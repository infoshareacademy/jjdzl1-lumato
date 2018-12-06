package appnavigation.login;

import inout.SessionData;
import main.java.appnavigation.Shortcuts;
import tools.AppExit;
import tools.CLS;
import inout.UserInput;

import java.io.IOException;

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
            if (checkQuitOptions(userLogin)){
                didUserQuit = true;
                break;
            };
            userPassword = askForUserPassword(); //ask for user password
            if (checkQuitOptions(userPassword) ){
                didUserQuit = true;
                break;
            }
            loginExists = validateLogin(userLogin);
            passwordMatches = validatePassword(userLogin, userPassword);
            if (loginExists == false || passwordMatches == false) {
                CLS.clearScreen();
                System.out.println("Niepoprawny login lub hasło!");
                System.out.println();
                loginExists = false;
                passwordMatches = false;
            }
        }
        if (!didUserQuit) {
            executeSuccessfulLogin(userLogin);
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

    private static boolean validatePassword(String userLogin, String userPassword){
        return UserDataValidation.checkIfPasswordMatches(userLogin, userPassword);
    }

    private static boolean checkQuitOptions(String text) throws Exception {
        if ("q".equals(text)) {
            CLS.clearScreen();
            AppExit.exitApplication();
            return true; //means that user decided to quit
        } else if ("p".equals(text)){
            CLS.clearScreen();
            SessionData.eraseSessionData();
            Shortcuts.runInitialWindow();
            return true; //means that user decided to go back to start menu
        }
        return false; //means that user didn't decide to quit
    }

    public static void executeSuccessfulLogin(String userLogin) throws IOException {
        SessionData.saveSessionData(userLogin);
        CLS.clearScreen();
        Shortcuts.runMainMenu();
    }
}
