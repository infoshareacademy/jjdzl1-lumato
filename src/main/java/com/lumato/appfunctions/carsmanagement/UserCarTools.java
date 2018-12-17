package com.lumato.appfunctions.carsmanagement;

import static com.lumato.inout.WriteReadFile.writeText;

import com.lumato.inout.FilePaths;
import com.lumato.inout.SessionData;
import com.lumato.inout.WriteReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserCarTools {

    private static String user;
    private static String carListPath;

    public static int countCars(){
        String carsAmount = "0";
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new FilePaths().getCurrentUserCarListPath()));
            while ((line = reader.readLine()) != null) {
                carsAmount = line.split(";")[0];
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(carsAmount);
    }

    public static void addNewCar(AbstractCar newCar){
        String textToAppend = newCar.getId() + ";" + newCar.getBrand() + ";" + newCar.getModel();
        WriteReadFile.writeText(textToAppend,
                true,
                new FilePaths().getCurrentUserCarListPath());
    }

    //show user cars and return how many of them he has
    public static int showProfileCars() {
        String carsAmount = "0";
        String[] lineAsArray = null;
        String line = "";
        System.out.println("\nTwoje auta:");
        System.out.printf("%-4s. %-12s %-12s\n","ID","Marka","Model");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new FilePaths().getCurrentUserCarListPath()));
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

    //we save car choice as integer (id)
    public static void saveCarChoice(int userChoice) throws IOException {
        SessionData.setCurrentCar(userChoice);
    }

}
