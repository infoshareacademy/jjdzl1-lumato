package main.java.inout;

import appfunctions.carsmanagement.Car;
import main.java.inout.WriteReadFile;
import main.java.inout.FilePaths;

import java.io.IOException;

//klasa pomocnicza, wspierająca klasę SignIn
//w klasie tej obsługuje plik z danymi sesyjnymi (w tej chwili jest to tylko nazwa uzytkownika)

public class SessionData {

    private static final String currentUserPath = FilePaths.getCurrentUserPath();

    //wpisanie nazwy użytkownika do pliku z danymi sesyjnymi
    public static void saveSessionData(String userLogin) throws IOException {
        String sessionText = userLogin + ";1";
        WriteReadFile.saveSimpleText(sessionText, currentUserPath);
    }

    //czyszczenie danych sesyjnych
    public static void eraseSessionData() throws IOException {
        WriteReadFile.saveSimpleText("", currentUserPath);
    }

    //metoda pobiera nazwę zalogowanego użytkownika
    public static String getCurrentUserName(){
        String line = WriteReadFile.readNthLine(FilePaths.getCurrentUserPath(), 1);
        String userName = line.split(";")[0];
        return userName;
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

    public static void setCurrentCar(int n) throws IOException {
        String line = WriteReadFile.readNthLine(FilePaths.getCurrentUserCarListPath(), n);
        String newSessionData = getCurrentUserName() + ";" + line.split(";")[0];
        WriteReadFile.saveSimpleText(newSessionData, FilePaths.getCurrentUserPath());
    }
}
