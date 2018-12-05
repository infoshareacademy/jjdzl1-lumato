package inout;

import java.math.BigDecimal;
import java.util.Scanner;

public class DataIn {
    public static void userData() {


        System.out.println("Podaj przebieg swojego auta:");

        double course; //w nim zapisujemy przebieg

        Scanner courseCar = new Scanner(System.in); //obiekt do odebrania danych od użytkownika

        System.out.println("Podaj w litrach ile paliwa zatankowałeś/aś:");
        double fuel; //ilość paliwa

        Scanner refuel = new Scanner(System.in);

        System.out.println("Podaj cene 1 litra paliwa:");

        double price; //cena za litr

        Scanner priceByOne = new Scanner(System.in);


        course = courseCar.nextDouble();
        fuel = refuel.nextDouble();
        price = priceByOne.nextDouble();


        System.out.println("Witaj dzisiaj zatankowałeś " + fuel + " litrów paliwa za łączną kwotę: " + fuel * price); //koncowe podsymowanie może być wyświetlane pod koniec programu
    }
}