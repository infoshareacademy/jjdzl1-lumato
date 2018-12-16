package com.lumato.appfunctions.carsmanagement;

import com.lumato.inout.UserInput;

import java.io.IOException;

import com.lumato.tools.AppExit;
import com.lumato.tools.CLS;

public class AddCar {

    public static void init() throws IOException {
        showInformation();
        AbstractCar newCar = new Car();
        if (getNewCarData(newCar).isNull()){
            //nothing happens
        } else {
            boolean isUserSure = askIfUserReallyWantsToAddNewCar(newCar);
            if (isUserSure) {
                UserCarTools.addNewCar(newCar);
                CLS.clearScreen();
                UserCarsPanel.init();
            } else {
                CLS.clearScreen();
                AddCar.init();
            }
        }
    }

    public static void showInformation(){
        System.out.println("Znajdujesz się w panelu dodawania samochodu. Podaj dane, by dodać nowy samochód");
        System.out.println("(lub 'p' - poprzednie menu/'q' - wyjście z aplikacji)");
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
        int cars = UserCarTools.countCars();
        newCar.setId(String.valueOf(cars+1));
        return newCar;
    }

    public static boolean askIfUserReallyWantsToAddNewCar(AbstractCar newCar) throws IOException {
        String yesOrNo = "";
        while (!"tak".equals(yesOrNo)&&!"nie".equals(yesOrNo)) {
            System.out.print("Czy na pewno chcesz dodać pojazd: " + newCar.getBrand() + " " + newCar.getModel() + "? ");
            System.out.print("Wpisz \"tak\" lub \"nie\": ");
            yesOrNo = UserInput.getUserStringInput();
            if ("tak".equals(yesOrNo)) return true;
            if ("nie".equals(yesOrNo)) return false;
            System.out.println("Niepoprawne dane!");
        }
        return false;
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
