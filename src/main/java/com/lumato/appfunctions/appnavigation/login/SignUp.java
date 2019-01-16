package com.lumato.appfunctions.appnavigation.login;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.inout.*;
import com.lumato.tools.AppMessages;
import com.lumato.tools.CLS;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SignUp {

    private static boolean passwordIsOk;
    private static boolean userExists;
    private static boolean loginIsOk;
    private static String attemptedLogin;
    private static String attemptedPassword;

    public SignUp() {
        this.passwordIsOk = false;
        this.userExists = true;
        this.loginIsOk = false;
        this.attemptedLogin = null;
        this.attemptedLogin = null;
    }

    public static void init() throws IOException, NoSuchAlgorithmException {
        while (userExists || !passwordIsOk || !loginIsOk) {
            showInfo(); //show Panel information
            if (!obtainUserData()) break;
            validateData();
            if (!userExists && passwordIsOk && loginIsOk) {
                executeSuccessfullSignUp(attemptedLogin, attemptedPassword); //utworzenie nowego profilu i przejście do logowania
            } else {
                executeNonSuccessfulSignUp();
            }
        }
    }

    private static void showInfo() {
        System.out.println("TWORZENIE NOWEGO PROFILU UŻYTKOWNIKA");
        System.out.println(AppMessages.EXIT_INFO.getMessage());
    }

    private static void printWrongDataMessage(boolean userExists, boolean loginIsOk, boolean passwordIsOk) {
        if (userExists) {
            PrintMessage.userExistsMessage();
        }
        if (!loginIsOk) {
            PrintMessage.wrongLoginMessage();
        }
        if (!passwordIsOk) {
            PrintMessage.wrongPasswordMessage();
        }
    }

    private static void executeSuccessfullSignUp(String login, String password) throws IOException, NoSuchAlgorithmException {
        //subscribe new user on user list
        String userDataToAppend = login + ";" + Encoding.encodeMD5(password);

        //create user's directory in resources/profiles
        String userProfilesPath = FilePaths.getProfilesPath() + attemptedLogin;
        new File(userProfilesPath).mkdirs();

        WriteReadFile.writeText(userDataToAppend, true, FilePaths.getUserListPath());
        //go to login panel
        CLS.clearScreen();
        System.out.println("Rejestracja przebiegła pomyślnie! Możesz teraz się zalogować na nowo utworzony profil.");
        Shortcuts.runLoginWindow();
    }

    private static boolean obtainUserData() throws IOException, NoSuchAlgorithmException {
        attemptedLogin = UserInput.obtainUserLogin();
        if (CheckQuit.userWantsToQuit(attemptedLogin)) {
            CheckQuit.executeQuit(attemptedLogin);
            attemptedLogin = null;
            return false; //user decided to quit
        }
        attemptedPassword = UserInput.obtainUserPassword();
        if (CheckQuit.userWantsToQuit(attemptedPassword)) {
            CheckQuit.executeQuit(attemptedPassword);
            attemptedLogin = null;
            attemptedPassword = null;
            return false; //user decided to quit
        }
        return true; //user didn't decide to quit
    }

    public static void validateData () {
        userExists = UserDataValidation.checkIfUserExists(attemptedLogin);
        passwordIsOk = UserDataValidation.checkIfPasswordIsOk(attemptedPassword);
        loginIsOk = UserDataValidation.checkIfLoginIsOk(attemptedLogin);
    }

    public static void executeNonSuccessfulSignUp(){
        CLS.clearScreen();
        printWrongDataMessage(userExists, loginIsOk, passwordIsOk); //wyrzucenie informacji dlaczego nie udało się utworzyć nowego profilu
        System.out.println("");
        passwordIsOk = false;
        userExists = true;
        loginIsOk = false;
    }
}


