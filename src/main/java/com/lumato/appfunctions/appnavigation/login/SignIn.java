package com.lumato.appfunctions.appnavigation.login;

import com.lumato.appfunctions.carsmanagement.AddFirstCar;
import com.lumato.appfunctions.carsmanagement.ChooseCarAtLogin;
import com.lumato.inout.*;
import com.lumato.tools.AppMessages;
import com.lumato.tools.CLS;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


/** Sign In panel */
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

    public static void init() throws IOException, NoSuchAlgorithmException {
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
        System.out.println(AppMessages.EXIT_INFO.getMessage());
    }

    private static boolean obtainUserData() throws IOException, NoSuchAlgorithmException {
        userLogin = UserInput.obtainUserLogin();
        if (CheckQuit.userWantsToQuit(userLogin)){
            CheckQuit.executeQuit(userLogin);
            userLogin = null;
            return false; // user decided to quit
        }
        userPassword = UserInput.obtainUserPassword();
        if (CheckQuit.userWantsToQuit(userPassword)){
            CheckQuit.executeQuit(userPassword);
            userLogin = null;
            userPassword = null;
            return false; // user decided to quit
        }
        return true; // user didn't decide to quit
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
        SessionData.saveSessionUserName(userLogin);
        String path = new FilePaths(userLogin).getCurrentUserCarListPath();
        if (WriteReadFile.isFileEmptyOrNonExisting(path)) {
            CLS.clearScreen();
            AddFirstCar.init(); //user needs to add a car at his first login
        } else {
            CLS.clearScreen();
            ChooseCarAtLogin.init();
        }
    }
}
