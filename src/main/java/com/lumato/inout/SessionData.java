package com.lumato.inout;

import com.lumato.appfunctions.carsmanagement.Car;

import java.io.IOException;

public class SessionData {

    private static final String currentUserPath = FilePaths.getCurrentUserPath();

    //put userName into current user file
    public static void saveSessionUserName(String userLogin) throws IOException {
        String sessionText = userLogin + ";1";
        WriteReadFile.saveSimpleText(sessionText, currentUserPath);
    }

    //czyszczenie danych sesyjnych
    public static void eraseSessionData() throws IOException {
        WriteReadFile.saveSimpleText("", currentUserPath);
    }

    //metoda pobiera nazwę zalogowanego użytkownika
    public static String getCurrentUserName(){
        return WriteReadFile.readNthLine(FilePaths.getCurrentUserPath(), 1).split(";")[0];
    }

    public static Car getCurrentUserCar(){
        Car car = new Car();
        String carId = WriteReadFile.readNthLine(FilePaths.getCurrentUserPath(), 1).split(";")[1];
        int carIdInt = Integer.valueOf(carId);
        String line = WriteReadFile.readNthLine(new FilePaths().getCurrentUserCarListPath(), carIdInt);
        String[] lineAsArray = line.split(";");
        car.setId(lineAsArray[0]);
        car.setBrand(lineAsArray[1]);
        car.setModel(lineAsArray[2]);
        return car;
    }

    public static void saveSessionCarId(int n) throws IOException {
        String line = WriteReadFile.readNthLine(FilePaths.getCurrentUserCarListPath(), n);
        String newSessionData = getCurrentUserName() + ";" + line.split(";")[0];
        WriteReadFile.saveSimpleText(newSessionData, FilePaths.getCurrentUserPath());
    }
}
