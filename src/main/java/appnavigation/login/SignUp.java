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
            showSignInInfo(); //wyrzucenie informacji o panelu
            attemptedLogin = askForLogin(); //prośba o podanie loginu
            if(checkQuit(attemptedLogin)) break; //sprawdzenie czy użytkownik postanowił uciec z funkcji
            attemptedPassword = askForPassword(); //prośba o podanie hasła
            if(checkQuit(attemptedPassword)) break; //sprawdzenie czy użytkownik postanowił uciec z funkcji
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

    private static boolean checkQuit(String text) throws Exception {
        if ("q".equals(text)) {
            CLS.clearScreen();
            AppExit.exitApplication();
            return true;
        } else if ("p".equals(text)){
            CLS.clearScreen();
            Shortcuts.runInitialWindow();
            return true;
        }
        return false;
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

    private static void executeSuccessfullSignUp(String login, String password) throws Exception {
        //dopisanie użytkownika do listy użytkowników
        String userDataToAppend = login + ";" + password;
        inout.WriteReadFile.writeText(userDataToAppend, true, inout.FilePaths.getUserListPath());
        //przejście do panelu logowania
        CLS.clearScreen();
        System.out.println("Rejestracja przebiegła pomyślnie! Możesz teraz się zalogować na nowo utworzony profil.");
        Shortcuts.runLoginWindow();
    }

}
