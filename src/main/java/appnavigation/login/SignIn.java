package appnavigation.login;

import main.java.inout.SessionData;
import main.java.appnavigation.Shortcuts;
import tools.CLS;
import main.java.inout.UserInput;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

//panel logowania
public class SignIn {

    private static boolean loginExists;
    private static boolean passwordMatches;
    private static String userLogin;
    private static String userPassword;

    public SignIn() {
        this.loginExists = false;
        this.passwordMatches = false;
        this.userLogin = null;
        this.userPassword = null;
    }

    public static void init() throws Exception {
        while (loginExists == false || passwordMatches == false) {
            showInformation();
            if (!obtainUserData()) break;
            validateLogin(userLogin);
            validatePassword(userLogin, userPassword);
            if (loginExists && passwordMatches) {
                executeSuccessfulLogin(userLogin);
            } else {
                executeNonSuccessfulLogin();
            }
        }
    }

    private static void showInformation(){
        System.out.println("LOGOWANIE");
        System.out.println("Wpisz 'q' i naciśnij 'enter' aby opuścić program");
        System.out.println("Wpisz 'p' i naciśnij 'enter' aby wrócić do ekranu startowego");
    }

    private static boolean obtainUserData() throws Exception {
        userLogin = UserInput.obtainUserLogin();
        if (CheckQuit.userWantsToQuit(userLogin)){
            CheckQuit.executeQuit(userLogin);
            userLogin = null;
            return false; //uzytkownik postanowil wyjsc
        }
        userPassword = UserInput.obtainUserPassword();
        if (CheckQuit.userWantsToQuit(userPassword)){
            CheckQuit.executeQuit(userPassword);
            userLogin = null;
            userPassword = null;
            return false; //uzytkownik postanowil wyjsc
        }
        return true; //udalo sie zalogowac
    }

    private static void validateLogin(String userLogin){
        if (UserDataValidation.checkIfUserExists(userLogin)) {
            loginExists = true;
        } else {
            loginExists = false;
        }
    }

    private static void validatePassword(String userLogin, String userPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (UserDataValidation.checkIfPasswordMatches(userLogin, userPassword)) {
            passwordMatches = true;
        } else {
            passwordMatches = false;
        }
    }

    public static void executeNonSuccessfulLogin(){
        CLS.clearScreen();
        System.out.println("Niepoprawny login lub hasło!");
        System.out.println();
        loginExists = false;
        passwordMatches = false;
    }

    public static void executeSuccessfulLogin(String userLogin) throws IOException {
        SessionData.saveSessionData(userLogin);
        CLS.clearScreen();
        Shortcuts.runMainMenu();
    }
}
