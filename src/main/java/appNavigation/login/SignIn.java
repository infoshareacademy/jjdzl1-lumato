package appNavigationlogin;

import main.java.tools.AppExit;
import main.java.tools.CLS;
import main.java.inout.UserInput;

import java.io.IOException;


/**
 * Login Panel
 */
public class SignIn {

    private static UserData userData;

    /**
     * login panel initialization
     * needs big refactor...
     * @throws Exception
     */
    public void init() throws Exception{
        showInformation();
        String userName = askForUserName();
        if(!isQuit(userName)){; //sprawdza, czy użytkownik wpisał exit lub prev
            boolean isLoginGood = checkIfLoginExists(userName);
            String userPassword = askForUserPassword();
            if (!isQuit(userPassword)) { //sprawdza, czy użytkownik wpisał exit lub prev
                //tu będzie walidacja hasła
                this.userData = new UserData(userName, userPassword);
                executeLogin(isLoginGood, userName);
            }
        }
    }

    /**
     * show information what to do here (either try to log in, or quit or go back to starting window)
     */
    private static void showInformation(){
        System.out.println("Wprowadź poprawny login i haslo by wejść do aplikacji");
        System.out.println("(w obecnej wersji poprawne loginy to \"adam\" oraz \"ewa\")");
        System.out.println("(w obecnej wersji poprawne hasło to \"\")");
        System.out.println("Żeby wrócić do poprzedniego widoku wpisz \"prev\"");
        System.out.println("Żeby opuścić program wpisz \"exit\"");
        System.out.println();
    }

    private static String askForUserName() throws IOException {
        System.out.print("PODAJ NAZWE UŻYTKOWNIKA: ");
        return UserInput.getUserStringInput();
    }

    private static String askForUserPassword() throws IOException {
        System.out.print("PODAJ HASŁO: ");
        return UserInput.getUserStringInput();
    }

    //wersja biedna, póki co jedynym użytkownikiem mającym dostęp do aplikacji będą adam oraz ewa
    private static boolean checkIfLoginExists(String userName) throws Exception {
        if ("adam".equals(userName) || "ewa".equals(userName)) {
            return true;
        } else {
            return false;
        }
    }

    private static void executeLogin(boolean isLoginGood, String userName) throws Exception{

        if ("exit".equals(userName)){
            CLS.clearScreen();
            AppExit.exitApplication();
        }
        if ("prev".equals(userName)) {
            CLS.clearScreen();
            new SignIn().init();
        }

        if (isLoginGood){
                CLS.clearScreen();
                // TUTAJ URUCHOMIENIE MAIN MENU
                Test testMainMenu = new Test(userData);
                testMainMenu.test();
        } else {
            CLS.clearScreen();
            System.out.println("Zły login!");
            new SignIn().init();
        }
    }

    /**
     * This method checks if user wants to quit (one wants to quit by typing "prev" or "exit"
     * @param userInput login/password typed by user
     * @return
     * @throws Exception
     */
    private static boolean isQuit(String userInput) throws Exception {
        boolean isQuit = false;
        if ("exit".equals(userInput)){
            CLS.clearScreen();
            AppExit.exitApplication();
            isQuit = true;
        }
        if ("prev".equals(userInput)){
            CLS.clearScreen();
            new InitialWindow().init();
            isQuit = true;
        }
        return isQuit;
    }

}
