package com.lumato.appfunctions.carsmanagement;

import main.java.inout.SessionData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import main.java.inout.UserInput;
import com.lumato.tools.AppExit;
import com.lumato.tools.CLS;
import main.java.inout.FilePaths;

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
            int amountOfCars = showProfileCars();
            String choice = askForChoice();
            if (carExists = goodChoice(choice, amountOfCars)) {
                executeChoice(choice);
            } else {
                CLS.clearScreen();
                System.out.println("Nie istnieje samochód o takim ID! Wybierz inny!\n");
            }
        }
    }

    private static void showInformation() {
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
                saveCarChoice(Integer.parseInt(choice));
                UserCarsPanel.init();
                break;
            }
        }
    }

    public static void saveCarChoice(int userChoice) throws IOException {
        SessionData.setCurrentCar(userChoice);

    }

    //show user cars and return how many of them he has
    private static int showProfileCars() {
        String carsAmount = "0";
        String[] lineAsArray = null;
        String line = "";
        System.out.println("\nTwoje auta:");
        System.out.printf("%-4s. %-12s %-12s\n","ID","Marka","Model");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(carListPath));
            while ((line = reader.readLine()) != null) {
                lineAsArray = line.split(";");
                System.out.printf("%-4s. %-12s %-12s\n",lineAsArray[0],lineAsArray[1],lineAsArray[2]);
                carsAmount = lineAsArray[0];
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(carsAmount);
    }

    private static String askForChoice() throws IOException {
        System.out.println("\nWpisz ID pojazdu i naciśnij enter by wybrać auto.");
        System.out.println("(lub 'p' - poprzednie menu/'q' - wyjście z aplikacji)");
        return UserInput.getUserStringInput();
    }

}
