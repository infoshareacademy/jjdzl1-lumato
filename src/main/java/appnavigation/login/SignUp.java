package appnavigation.login;

import main.java.appnavigation.Shortcuts;
import main.java.inout.FilePaths;
import main.java.inout.WriteReadFile;
import tools.CLS;
import main.java.inout.UserInput;
import tools.AppExit;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUp {

    public static void init() throws Exception {
        boolean passwordIsOk = false;
        boolean userExists = true;
        boolean loginIsOk = false;
        String attemptedLogin = "";
        String attemptedPassword = "";
        while (userExists || !passwordIsOk || !loginIsOk) {
            showSignInInfo(); //wyrzucenie informacji o panelu
            attemptedLogin = UserInput.obtainUserLogin();
            if(UserDataValidation.checkQuit(attemptedLogin)) break; //sprawdzenie czy użytkownik postanowił uciec z funkcji
            attemptedPassword = UserInput.obtainUserPassword();
            if(UserDataValidation.checkQuit(attemptedPassword)) break; //sprawdzenie czy użytkownik postanowił uciec z funkcji
            userExists = UserDataValidation.checkIfUserExists(attemptedLogin); //sprawdzenie czy nazwa użytkownika jest już zajęta
            passwordIsOk = UserDataValidation.checkIfPasswordIsOk(attemptedPassword); //sprawdzenie czy hasło spełnia wymagania
            loginIsOk = UserDataValidation.checkIfLoginIsOk(attemptedLogin); //sprawdzenie czy login spełnia wymagania
            if (userExists || !passwordIsOk || !loginIsOk) {
                CLS.clearScreen();
                printWrongDataMessage(userExists, loginIsOk, passwordIsOk); //wyrzucenie informacji dlaczego nie udało się utworzyć nowego profilu
                System.out.println("");
                passwordIsOk = false;
                userExists = true;
                loginIsOk = false;
            }
            if (!userExists && passwordIsOk && loginIsOk){
                executeSuccessfullSignUp(attemptedLogin, attemptedPassword); //utworzenie nowego profilu i przejście do logowania
            }
        }
    }

    private static void showSignInInfo(){
        System.out.println("TWORZENIE NOWEGO PROFILU UŻYTKOWNIKA");
        System.out.println("Wpisz 'p' a następnie 'enter' by wrócić do ekranu startowego");
        System.out.println("Wpisz 'q' a następnie 'enter' by opuścić program");
    }

    private static void printWrongDataMessage(boolean userExists,boolean loginIsOk,boolean passwordIsOk){
        if (userExists) {
            UserDataValidation.userExistsMessage();
        }
        if (!loginIsOk) {
            UserDataValidation.wrongLoginMessage();
        }
        if (!passwordIsOk){
            UserDataValidation.wrongPasswordMessage();
        }
    }

    private static void executeSuccessfullSignUp(String login, String password) throws Exception {
        //dopisanie użytkownika do listy użytkowników
        String userDataToAppend = login + ";" + UserDataValidation.encodeMD5(password);

        WriteReadFile.writeText(userDataToAppend, true, FilePaths.getUserListPath());
        //przejście do panelu logowania
        CLS.clearScreen();
        System.out.println("Rejestracja przebiegła pomyślnie! Możesz teraz się zalogować na nowo utworzony profil.");
        Shortcuts.runLoginWindow();
    }



}
