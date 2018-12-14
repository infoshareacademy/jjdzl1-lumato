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
        WriteReadFile.saveSimpleText(userLogin, currentUserPath);
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
        String line = WriteReadFile.readNthLine(new FilePaths().getCurrentUserCarListPath(), 1);
        String[] lineAsArray = line.split(";");
        car.setId(lineAsArray[0]);
        car.setBrand(lineAsArray[1]);
        car.setModel(lineAsArray[2]);
        return car;
    }
}
