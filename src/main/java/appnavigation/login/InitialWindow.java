package appnavigation.login;

import main.java.appnavigation.Shortcuts;
import tools.AppExit;
import tools.CLS;
import inout.UserInput;
import java.io.IOException;


public class InitialWindow {

    //metoda inicjalizujaca pierwsze okno programu (okno z wyborem rejestracji/logowania)
    public static void init() throws Exception {
        showHeader();
        showOptions();
        String userChoice = chooseOption();
        new InitialWindow().executeUserChoice(userChoice);
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

    private void executeUserChoice(String userChoice) throws Exception{
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
