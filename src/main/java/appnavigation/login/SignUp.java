package appnavigation.login;

import main.java.appnavigation.Shortcuts;
import tools.CLS;
import inout.UserInput;
import tools.AppExit;


import java.io.IOException;

public class SignUp {

    public static void init() throws Exception {
        boolean passwordIsOk = false;
        boolean userExists = true;
        boolean loginIsOk = false;
        String attemptedLogin = "";
        String attemptedPassword = "";
        while (userExists || !passwordIsOk || !loginIsOk) {
            showSignInInfo();
            attemptedLogin = askForLogin();
            checkQuit(attemptedLogin);
            attemptedPassword = askForPassword();
            checkQuit(attemptedPassword);
            userExists = UserDataValidation.checkIfUserExists(attemptedLogin);
            passwordIsOk = UserDataValidation.checkIfPasswordIsOk(attemptedPassword);
            loginIsOk = UserDataValidation.checkIfLoginIsOk(attemptedLogin);
            if (userExists || !passwordIsOk || !loginIsOk) {
                CLS.clearScreen();
                printWrongDataMessage(userExists, loginIsOk, passwordIsOk);
                System.out.println("");
                userExists = true;
                passwordIsOk = false;
            }
        }
        if (!userExists && passwordIsOk && loginIsOk)
        createNewProfileAndReturn(attemptedLogin, attemptedPassword);
    }

    private static void showSignInInfo(){
        System.out.println("TWORZENIE NOWEGO PROFILU UŻYTKOWNIKA");
        System.out.println("Wpisz 'p' a następnie 'enter' by wrócić do ekranu startowego");
        System.out.println("Wpisz 'q' a następnie 'enter' by opuścić program");
    }

    private static void checkQuit(String text) throws Exception {
        if ("q".equals(text)) {
            CLS.clearScreen();
            AppExit.exitApplication();
        } else if ("p".equals(text)){
            CLS.clearScreen();
            Shortcuts.runInitialWindow();
        }
    }

    private static String askForLogin() throws IOException {
        System.out.print("\nPODAJ NAZWĘ UŻYTKOWNIKA: ");
        return UserInput.getUserStringInput();
    }

    private static String askForPassword() throws IOException {
        System.out.print("PODAJ HASLO: ");
        return UserInput.getUserStringInput();
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

    private static void createNewProfileAndReturn(String login, String password) throws Exception {
        //dopisanie użytkownika do listy użytkowników
        String userDataToAppend = login + ";" + password;
        inout.WriteReadFile.writeText(userDataToAppend, true, inout.FilePaths.getUserListPath());
        //przejście do panelu logowania
        CLS.clearScreen();
        System.out.println("Rejestracja przebiegła pomyślnie! Możesz teraz się zalogować na nowo utworzony profil.");
        Shortcuts.runLoginWindow();
    }

}
