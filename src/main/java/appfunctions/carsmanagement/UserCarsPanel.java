package appfunctions.carsmanagement;

import main.java.inout.UserInput;
import tools.AppExit;
import tools.CLS;
import main.java.appnavigation.Shortcuts;

import java.io.IOException;

public class UserCarsPanel {

    public static void init() throws IOException {
        showInformation();
        showOptions();
        String choice = getUserChoice();
        executeUserChoice(choice);
    }

    private static void showInformation(){
        System.out.println("Znajdujesz się w panelu do zarządzania samochodami.");
    }

    private static void showOptions(){
        System.out.println("1 - wybierz istniejący samochód");
        System.out.println("2 - dodaj nowe auto");
        System.out.println("3 - usuń auto oraz wszystkie dane z nim powiązane");
        System.out.println("p - wróć do menu głównego");
        System.out.println("q - opuść aplikację");
    }

    private static String getUserChoice() throws IOException {
        System.out.print("Wybierz opcję i wciśnij enter: ");
        return UserInput.getUserStringInput();
    }

    private static void executeUserChoice(String choice) throws IOException {
        switch(choice){
            case "1": {
                CLS.clearScreen();
                System.out.println("Wybór samochodu");
                break;
            }
            case "2": {
                CLS.clearScreen();
                System.out.println("Dodawanie auta");
                break;
            }
            case "3": {
                CLS.clearScreen();
                System.out.println("usuwanie auta");
                break;
            }
            case "p": {
                CLS.clearScreen();
                Shortcuts.runMainMenu();
                break;
            }
            case "q": {
                CLS.clearScreen();
                AppExit.exitApplication();
                break;
            }
            default: {
                System.out.println("Nie ma takiej opcji w menu! Podaj inną: ");
                break;
            }
        }
    }

}
