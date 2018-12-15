package appfunctions.carsmanagement;

import main.java.inout.SessionData;
import main.java.inout.FilePaths;

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
}
