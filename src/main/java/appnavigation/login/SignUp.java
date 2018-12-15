package appnavigation.login;

import main.java.appnavigation.Shortcuts;
import main.java.inout.FilePaths;
import main.java.inout.WriteReadFile;
import tools.CLS;
import main.java.inout.UserInput;

import java.io.File;

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

    public static void init() throws Exception {
        while (userExists || !passwordIsOk || !loginIsOk) {
            showInfo(); //wyrzucenie informacji o panelu
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
        System.out.println("Wpisz 'p' a następnie 'enter' by wrócić do ekranu startowego");
        System.out.println("Wpisz 'q' a następnie 'enter' by opuścić program");
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

    private static void executeSuccessfullSignUp(String login, String password) throws Exception {
        //dopisanie użytkownika do listy użytkowników
        String userDataToAppend = login + ";" + Encoding.encodeMD5(password);

        //utworzenie folderu użytkownika w folderze profiles
        String userProfilesPath = FilePaths.getProfilesPath() + attemptedLogin;
        new File(userProfilesPath).mkdirs();

        //utworzenie pliku z samochodami w folderze użytkownika
        String carListPath = new FilePaths(attemptedLogin).getCurrentUserCarListPath();
        WriteReadFile.saveSimpleText("ID;MARKA;MODEL\n1;samochod;pokazowy", carListPath);

        WriteReadFile.writeText(userDataToAppend, true, FilePaths.getUserListPath());
        //przejście do panelu logowania
        CLS.clearScreen();
        System.out.println("Rejestracja przebiegła pomyślnie! Możesz teraz się zalogować na nowo utworzony profil.");
        Shortcuts.runLoginWindow();
    }

    private static boolean obtainUserData() throws Exception {
        attemptedLogin = UserInput.obtainUserLogin();
        if (CheckQuit.userWantsToQuit(attemptedLogin)) {
            CheckQuit.executeQuit(attemptedLogin);
            attemptedLogin = null;
            return false; //uzytkownik postanowil wyjsc
        }
        attemptedPassword = UserInput.obtainUserPassword();
        if (CheckQuit.userWantsToQuit(attemptedPassword)) {
            CheckQuit.executeQuit(attemptedPassword);
            attemptedLogin = null;
            attemptedPassword = null;
            return false; //uzytkownik postanowil wyjsc
        }
        return true; //udalo sie zalogowac
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


