package com.lumato.appfunctions.carsmanagement;

import com.lumato.inout.*;
import java.io.IOException;
import com.lumato.tools.AppExit;
import com.lumato.tools.AppMessages;
import com.lumato.tools.CLS;


public class ChooseCar {

    private static String userName;
    private static String carListPath;
    private static boolean carExists = false;

    public ChooseCar() {

    }

    public static void init() throws IOException {
        showInformation();
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

    public static void showInformation() {
        System.out.print("Twój obecny samochód to: ");
        AbstractCar currentCar = SessionData.getCurrentUserCar();
        System.out.println(currentCar.getId() + ". "
                + currentCar.getBrand() + " " + currentCar.getModel());
    }

    private static void setData(){
        userName = SessionData.getCurrentUserName();
        carListPath = FilePaths.getCurrentUserCarListPath();
    }

    public static boolean goodChoice(String choice, int amountOfCars){
        if ("q".equals(choice)||"p".equals(choice)) return true;
        if (choice.matches("\\d+")){
            int choiceAsInt = Integer.parseInt(choice);
            if (choiceAsInt <= amountOfCars && choiceAsInt > 0) return true;
        }
        return false;
    }

    private static void executeChoice(String choice) throws IOException {
        switch (choice){
            case "p": {
                CLS.clearScreen();
                UserCarsPanel.init();
                break;
            }
            case "q": {
                CLS.clearScreen();
                AppExit.exitApplication();
                break;
            }
            default: {
                CLS.clearScreen();
                UserCarTools.saveCarChoice(Integer.parseInt(choice));
                UserCarsPanel.init();
                break;
            }
        }
    }


    private static String askForChoice() throws IOException {
        System.out.println("\nWpisz ID pojazdu i naciśnij enter by wybrać auto.");
        System.out.println(AppMessages.EXIT_INFO.getMessage());
        return UserInput.getUserStringInput();
    }

}
