package com.lumato.appfunctions.carsmanagement;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.inout.FilePaths;
import com.lumato.inout.SessionData;
import com.lumato.inout.UserInput;
import com.lumato.tools.AppExit;
import com.lumato.tools.CLS;

import java.io.IOException;

import static com.lumato.appfunctions.carsmanagement.ChooseCar.goodChoice;

public class ChooseCarAtLogin {

    private static String userName;
    private static String carListPath;
    private static boolean carExists = false;


    public static void init() throws IOException {
        setData();
        carExists = false;
        while (!carExists) {
            int amountOfCars = UserCarTools.showProfileCars();
            String choice = askForChoice();
            if (carExists = goodChoice(choice, amountOfCars)) {
                executeChoice(choice);
            } else {
                CLS.clearScreen();
                System.out.println("Nie istnieje samochód o takim ID! Wybierz inny!\n");
            }
        }
    }

    private static void setData(){
        userName = SessionData.getCurrentUserName();
        carListPath = FilePaths.getCurrentUserCarListPath();
    }

    private static String askForChoice() throws IOException {
        System.out.print("\nWpisz ID pojazdu i naciśnij enter by wybrać auto:");
        return UserInput.getUserStringInput();
    }


    private static void executeChoice(String choice) throws IOException {
        CLS.clearScreen();
        UserCarTools.saveCarChoice(Integer.parseInt(choice));
        Shortcuts.runMainMenu();
    }

}
