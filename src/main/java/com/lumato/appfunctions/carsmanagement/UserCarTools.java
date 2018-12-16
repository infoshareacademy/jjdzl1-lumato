package com.lumato.appfunctions.carsmanagement;

import com.lumato.inout.FilePaths;
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
}
