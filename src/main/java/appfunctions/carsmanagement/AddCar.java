package appfunctions.carsmanagement;

import main.java.inout.UserInput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import main.java.inout.FilePaths;
import tools.AppExit;
import tools.CLS;

public class AddCar {

    //TUTAJ ZROBIE DODAWANIE SAMOCHODU

    public static void init() throws IOException {
        showInformation();
        AbstractCar newCar = new Car();
        if (getNewCarData(newCar).isNull()){
        } else {
            boolean isUserSure = askIfUserReallyWantsToAddNewCar(newCar);
            if (isUserSure) {
                addNewCar(newCar);
                CLS.clearScreen();
                UserCarsPanel.init();
            } else {
                CLS.clearScreen();
                AddCar.init();
            }
        }
    }

    public static void showInformation(){
        System.out.println("Znajdujesz się w panelu dodawania samochodu.");
        System.out.println("Podaj dane, by dodać nowy samochód");
        System.out.println("Wpisz 'p' i naciśnij enter by wrócić do poprzedniego menu.");
        System.out.println("Wpisz 'q' i naciśnij enter by wrócić do menu głównego");
    }

    public static AbstractCar getNewCarData(AbstractCar newCar) throws IOException {
        System.out.print("Podaj markę: ");
        newCar.setBrand(UserInput.getUserStringInput());
        if (checkQuit(newCar.getBrand())){
            return new NullCar();
        }
        System.out.print("Podaj model: ");
        newCar.setModel(UserInput.getUserStringInput());
        if(checkQuit(newCar.getModel())){
            return new NullCar();
        }
        int cars = countCars();
        newCar.setId(String.valueOf(cars+1));
        return newCar;
    }

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

    public static boolean askIfUserReallyWantsToAddNewCar(AbstractCar newCar) throws IOException {
        String yesOrNo = "";
        while (!"tak".equals(yesOrNo)&&!"nie".equals(yesOrNo)) {
            System.out.println("Czy na pewno chcesz dodać pojazd? ");
            System.out.println("Marka: " + newCar.getBrand());
            System.out.println("Model: " + newCar.getModel());
            System.out.print("Wpisz \"tak\" lub \"nie\":");
            yesOrNo = UserInput.getUserStringInput();
            if ("tak".equals(yesOrNo)) return true;
            if ("nie".equals(yesOrNo)) return false;
            System.out.println("Niepoprawne dane!");
        }
        return false;
    }

    public static void addNewCar(AbstractCar newCar){
        String textToAppend = newCar.getId() + ";" + newCar.getBrand() + ";" + newCar.getModel();
        main.java.inout.WriteReadFile.writeText(textToAppend,
                true,
                new FilePaths().getCurrentUserCarListPath());
    }

    public static boolean checkQuit(String text) throws IOException {
        if ("p".equals(text)){
            CLS.clearScreen();
            UserCarsPanel.init();
            return true;
        }
        if ("q".equals(text)){
            CLS.clearScreen();
            AppExit.exitApplication();
            return true;
        }
        return false;
    }
}
