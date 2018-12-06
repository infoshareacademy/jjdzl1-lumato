package appnavigation.login;

import tools.CLS;
import inout.UserInput;
import tools.AppExit;


import java.io.IOException;

public class SignUp {

    public void init() throws Exception {
        boolean passwordIsOk = false;
        boolean userExists = true;
        boolean loginIsOk = false;
        while (userExists || !passwordIsOk || !loginIsOk) {
            showSignInInfo();
            String attemptedLogin = askForLogin();
            checkQuit(attemptedLogin);
            String attemptedPassword = askForPassword();
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
        createNewProfileAndReturn();
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
            InitialWindow.init();
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

    private static void createNewProfileAndReturn() throws Exception {
        //TU DODANIE UŻYTKOWNIKA DO LISTY UŻYTKOWNIKÓW
        CLS.clearScreen();
        System.out.println("Rejestracja przebiegła pomyślnie! Możesz teraz się zalogować na nowo utworzony profil.");
        SignIn signIn = new SignIn();
        signIn.init();
    }

}
