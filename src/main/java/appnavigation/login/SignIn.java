package appnavigation.login;

import inout.SessionData;
import main.java.appnavigation.Shortcuts;
import tools.AppExit;
import tools.CLS;
import inout.UserInput;
import appnavigation.menuchoice.ShowMenu;
import appnavigation.menuchoice.MenuChoice;
import appnavigation.menuchoice.MenuSelect;

import java.io.IOException;


/**
 * Login Panel
 */
public class SignIn {

    private boolean loginExists = false;
    private boolean passwordMatches = false;
    private String userLogin = "";
    private String userPassword = "";

    public void init() throws Exception {

        while (loginExists == false || passwordMatches == false) {
            showInformation();
            userLogin = askForUserLogin(); //ask for user login
            checkQuitOptions(userLogin); //check if user decided to quit
            String userPassword = askForUserPassword(); //ask for user password
            checkQuitOptions(userPassword); //check if user decided to quit
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
        executeSuccessfulLogin(userLogin);
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

    //metoda jeszcze nieskońcozna, wersja prowizoryczna
    private static boolean validateLogin(String userLogin){
        return UserDataValidation.checkIfUserExists(userLogin);
    }

    //metoda nieskończona, wersja prowizoryczna
    private static boolean validatePassword(String userLogin, String userPassword){
//        if ("adam".equals(userLogin) && "abcd".equals(userPassword) || "ewa".equals(userLogin) && "mak".equals(userPassword)){
//            return true;
//        } else {
//            return false;
//        }
        return UserDataValidation.checkIfPasswordMatches(userLogin, userPassword);
    }

    private static void checkQuitOptions(String text) throws Exception {
        if ("q".equals(text)) {
            CLS.clearScreen();
            AppExit.exitApplication();
        } else if ("p".equals(text)){
            CLS.clearScreen();
            SessionData.eraseSessionData();
            Shortcuts.runStartWindow();
        }
    }

    public void executeSuccessfulLogin(String userLogin) throws IOException {
        SessionData.saveSessionData(userLogin);
        CLS.clearScreen();
        Shortcuts.runMainMenu();
    }
}
