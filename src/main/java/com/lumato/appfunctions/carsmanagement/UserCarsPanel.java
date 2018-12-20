package com.lumato.appfunctions.carsmanagement;

import com.lumato.inout.UserInput;
import com.lumato.tools.AppExit;
import com.lumato.tools.CLS;
import com.lumato.appfunctions.appnavigation.Shortcuts;

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
                ChooseCar.init();
                break;
            }
            case "2": {
                CLS.clearScreen();
                AddCar.init();
                break;
            }
            case "3": {
                CLS.clearScreen();
                DeleteCarMenu.init();
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
