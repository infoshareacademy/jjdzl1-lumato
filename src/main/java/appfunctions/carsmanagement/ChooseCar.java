package appfunctions.carsmanagement;

import main.java.inout.SessionData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import main.java.inout.UserInput;
import tools.AppExit;
import tools.CLS;
import main.java.inout.FilePaths;
import main.java.inout.WriteReadFile;

public class ChooseCar {

    private static String userName;
    private static String carListPath;
    private static boolean carExists = false;

    public ChooseCar() {

    }

    public static void init() throws IOException {
        showInformation();
        setData();
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
        System.out.println("Oto lista Twoich samochodów: ");
    }

    private static void setData(){
        userName = SessionData.getCurrentUserName();
        carListPath = "resources/profiles/"
                + userName
                + "/"
                + userName
                + "_cars.txt";
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
            }
            case "q": {
                CLS.clearScreen();
                AppExit.exitApplication();
            }
            default: {
                CLS.clearScreen();
                saveCarChoice(Integer.parseInt(choice));
                UserCarsPanel.init();
            }
        }
    }

    public static void saveCarChoice(int n) throws IOException {
        String line = WriteReadFile.readNthLine(carListPath, n);
        String newSessionData = userName + ";" + line.split(";")[0];
        WriteReadFile.saveSimpleText(newSessionData, FilePaths.getCurrentUserPath());
    }

    //show user cars and return how many of them he has
    private static int showProfileCars() {
        String carsAmount = "0";
        String[] lineAsArray = null;
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(carListPath));
            while ((line = reader.readLine()) != null) {
                lineAsArray = line.split(";");
                System.out.println(lineAsArray[0]+". "+lineAsArray[1]+" " + lineAsArray[2]);
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
        System.out.println("Wpisz ID pojazdu i naciśnij enter by wybrać auto.");
        System.out.println("Wpisz 'p' i naciśnij enter by cofnąć się do poprzedniego menu");
        System.out.println("Wpis 'q' i naciśnij enter by wyjść z aplikacji");
        return UserInput.getUserStringInput();
    }

}
