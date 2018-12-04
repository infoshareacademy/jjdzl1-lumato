package appNavigationlogin;

import main.java.tools.AppExit;
import main.java.tools.CLS;
import main.java.inout.UserInput;
import java.io.IOException;

/**
 * First (initial) application window
 */
public class InitialWindow {

    /**
     * This method initializes whole Application
     * @throws Exception
     */
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
        System.out.println("1. Zaloguj się na istniejące konto");
        System.out.println("2. Utwórz nowe konto");
        System.out.println("3. Wyjdź z aplikacji");
    }

    private static String chooseOption() throws IOException {
        System.out.print("Wpisz opcję menu i naciśnij \'enter\': ");
        return UserInput.getUserStringInput();
    }

    private void executeUserChoice(String userChoice) throws Exception{
        switch(userChoice){
            case "1": {
                CLS.clearScreen();
                SignIn signIn = new SignIn();
                signIn.init();
                break;
            }
            case "2": {
                CLS.clearScreen();
                new SignUp().init();
                break;
            }
            case "3": {
                AppExit.exitApplication();
                break;
            }
            default:
                CLS.clearScreen();
                System.out.println("Niepoprawne dane!");
                try {
                    InitialWindow.init();
                }catch(IOException e){
                }
                break;
        }
    }

}
