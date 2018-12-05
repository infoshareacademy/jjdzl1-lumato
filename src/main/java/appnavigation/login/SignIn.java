package main.java.appNavigation.login;

import main.java.inout.SessionData;
import main.java.tools.AppExit;
import main.java.tools.CLS;
import main.java.inout.UserInput;
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
                loginExists = false;
                passwordMatches = false;
            }
        }

        executeSuccessfulLogin(userLogin);
    }

    private static void showInformation(){
        System.out.println("Jesteś w panelu logowania.");
        System.out.println("W obecnej wersji działające dane to:");
        System.out.println("Login: adam, hasło: abcd");
        System.out.println("Login: ewa, hasło: mak");
        System.out.println("Wpisz 'q' aby opuścić program");
        System.out.println("Wpisz 'p' aby wrócić do ekranu startowego");
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
            InitialWindow.init();
        }
    }

    public void executeSuccessfulLogin(String userLogin) throws IOException {
        SessionData.saveSessionData(userLogin);
        CLS.clearScreen();

        //uruchomienie menu głównego
        ShowMenu.showMenu();
        char c = MenuSelect.validateInput(("[1-3]"),"q", "quit");
        MenuChoice.menuChoice(c);
    }
}
