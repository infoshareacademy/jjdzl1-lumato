package com.lumato.appfunctions.appnavigation.login;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.tools.AppExit;
import com.lumato.tools.CLS;
import com.lumato.inout.UserInput;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.lumato.inout.FilePaths;
import com.lumato.inout.WriteReadFile;


public class InitialWindow {

    //metoda inicjalizujaca pierwsze okno programu (okno z wyborem rejestracji/logowania)
    public static void init() throws IOException, NoSuchAlgorithmException {
        createFilesIfTheyDoNotExist();
        showHeader();
        showOptions();
        String userChoice = chooseOption();
        new InitialWindow().executeUserChoice(userChoice);
    }

    private static void createFilesIfTheyDoNotExist() throws IOException {
        //if SessionDataFile does not exist - create it
        String path = FilePaths.getCurrentUserPath();
        if (WriteReadFile.isFileEmptyOrNonExisting(path)){
            WriteReadFile.saveSimpleText("",path);
        }
        //if UserList (user-data-base kinda) does not exist - create it
        path = FilePaths.getUserListPath();
        if (WriteReadFile.isFileEmptyOrNonExisting(path)){
            WriteReadFile.saveSimpleText("",path);
        }
    }

    private static void showHeader(){
        System.out.println("Witamy w aplikacji \"Kalkulator Paliw\"!");
    }

    private static void showOptions(){
        System.out.println("1 - Zaloguj się na istniejące konto");
        System.out.println("2 - Utwórz nowy profil");
        System.out.println("q - Wyjdź z aplikacji");
    }

    private static String chooseOption() throws IOException {
        System.out.print("Wpisz opcję menu i naciśnij \'enter\': ");
        return UserInput.getUserStringInput();
    }

    private void executeUserChoice(String userChoice) throws IOException, NoSuchAlgorithmException {
        switch(userChoice){
            case "1": {
                CLS.clearScreen();
                Shortcuts.runLoginWindow();
                break;
            }
            case "2": {
                CLS.clearScreen();
                Shortcuts.runSignInWindow();
                break;
            }
            case "q": {
                AppExit.exitApplication();
                break;
            }
            default:
                CLS.clearScreen();
                System.out.println("Niepoprawne dane!");
                Shortcuts.runInitialWindow();
                break;
        }
    }
}
