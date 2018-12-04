package main.java.appNavigation.login;

import main.java.inout.SessionData;
import main.java.tools.AppExit;
import main.java.tools.CLS;
import main.java.inout.UserInput;
import appNavigation.menuChoice.ShowMenu;
import appNavigation.menuChoice.MenuChoice;
import appNavigation.menuChoice.MenuSelect;

import java.io.IOException;


/**
 * Login Panel
 */
public class SignIn {

    private final String userListPath = "resources/userList.txt";
    private final String currentUserPath = "resources/currentUser.txt";
    private boolean loginExists = false;
    private boolean passwordMatches = false;
    private String userLogin = "";
    private String userPassword = "";

    public void init() throws Exception {

        while (loginExists == false || passwordMatches == false) {
            showInformation();
            //ask for login and check
            userLogin = askForUserLogin();
            checkQuitOptions(userLogin);
            loginExists = checkIfLoginExists(userLogin, userListPath);
            //ask for password and check
            String userPassword = askForUserPassword();
            checkQuitOptions(userPassword);
            passwordMatches = checkIfPasswordMatches(userLogin, userPassword, userListPath);
            if (loginExists == false || passwordMatches == false) {
                CLS.clearScreen();
                System.out.println("Niepoprawny login lub hasło!");
                loginExists = false;
                passwordMatches = false;
            }
        }
        SessionData.saveSessionData(userLogin);
        CLS.clearScreen();

        //uruchomienie menu głównego
        ShowMenu.showMenu();
        char c = MenuSelect.validateInput(("[1-3]"),"q", "quit");
        MenuChoice.menuChoice(c);
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
    private static boolean checkIfLoginExists(String userLogin, String userListPath){
        if ("adam".equals(userLogin) || "ewa".equals(userLogin)){
            return true;
        } else {
            return false;
        }
    }

    //metoda nieskończona, wersja prowizoryczna
    private static boolean checkIfPasswordMatches(String userLogin, String userPassword, String userListPath){
        if ("adam".equals(userLogin) && "abcd".equals(userPassword) || "ewa".equals(userLogin) && "mak".equals(userPassword)){
            return true;
        } else {
            return false;
        }
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
}
