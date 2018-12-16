package com.lumato.appfunctions.carsmanagement;

import java.io.IOException;
import main.java.inout.UserInput;
import com.lumato.tools.CLS;
import main.java.appnavigation.Shortcuts;

//dodawanie pierwszego auta (przy pierwszym logowaniu na konto nie mamy auta,
//ta metoda zmusza nas do utworzenia pierwszego auta zanim wyświetli sięnam menu główne
public class AddFirstCar {

    private static boolean isSure;

    public static void init() throws IOException {
        isSure = false;
        showInfo();
        while (isSure==false) {
            AbstractCar firstCar = askUserForCarData();
            isSure = (askIfSure(firstCar));
            if (isSure) break;
        }
    }

    private static void showInfo(){
        System.out.println("Zanim zaczniesz, muszę poprosić Cię o wprowadzenie pierwszego auta.\n");
    }

    private static AbstractCar askUserForCarData() throws IOException {
        AbstractCar firstCar = new Car();
        System.out.print("Podaj markę auta: ");
        firstCar.setBrand(UserInput.getUserStringInput());
        System.out.print("Podaj odel auta: ");
        firstCar.setModel(UserInput.getUserStringInput());
        firstCar.setId("1");
        return firstCar;
    }

    private static boolean askIfSure(AbstractCar car) throws IOException {
        String decision = "";
        while (!"tak".equals(decision) && !"nie".equals(decision)) {
            System.out.print("Czy na pewno chcesz dodać samochód: ");
            System.out.println(car.getBrand() + " " + car.getModel() + "?");
            System.out.print("Wpisz tak/nie: ");
            decision = UserInput.getUserStringInput();
            if ("tak".equals(decision)) {
                UserCarTools.addNewCar(car);
                CLS.clearScreen();
                Shortcuts.runMainMenu();
                return true;
            }
            if ("nie".equals(decision)) {
                CLS.clearScreen();
                AddFirstCar.init();
                return false;
            }
            CLS.clearScreen();
            System.out.println("Wprowadzone dane nie są poprawne! Wpisz 'tak' lub 'nie'!");
        }
        return false;
    }
}
