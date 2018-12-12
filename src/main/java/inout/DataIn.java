package inout;

import java.util.Scanner;
//brakuje odbrego zapisu i odczytu z csv/xlsx
/*po uruchomieniu
Witaj w kalkulatorze paliwowym!
Podaj przebieg swojego auta:
12334,55
Podaj w litrach ile paliwa zatankowałeś/aś:
86,55
Podaj cene 1 litra paliwa:
5,30
Witaj dzisiaj zatankowałeś 86.55 litrów paliwa za łączną kwotę: 458.7150,70
Twoje średnie spalanie na 100 km to: java.io.PrintStream@2f0e140b0,04
Średni koszt przejechania 1 km to: java.io.PrintStream@2f0e140b zł
Process finished with exit code 0
 */
public class DataIn {
    public void DataIn() {
        System.out.println("Witaj w kalkulatorze paliwowym!");

        System.out.println("Podaj przebieg swojego auta: ");

        double course; //w nim zapisujemy przebieg


        Scanner courseCar = new Scanner(System.in); //obiekt do odebrania danych od użytkownika

        course = courseCar.nextDouble();

        System.out.println("Podaj w litrach ile paliwa zatankowałeś/aś:");
        double fuel; //ilość paliwa

        Scanner refuel = new Scanner(System.in);

        fuel = refuel.nextDouble();

        System.out.println("Podaj cene 1 litra paliwa:");

        double price; //cena za litr

        Scanner priceByOne = new Scanner(System.in);

        price = priceByOne.nextDouble();
        // File FuelData = new PrintWriter("FuelData.xlsx");
        // Scanner in = new Scanner(Double.valueOf(course));
        Double avrPriceByKm = price * (fuel / (course / 100) / 100);
        Double avrCombustion = fuel / (course / 100);


        System.out.printf("Witaj dzisiaj zatankowałeś " + fuel + " litrów paliwa za łączną kwotę: " + fuel * price);//koncowe podsymowanie może być wyświetlane pod koniec programu
        System.out.printf("Twoje średnie spalanie na 100 km to: " + System.out.format("%.2f%n", avrCombustion));
        System.out.printf("Średni koszt przejechania 1 km to: " + System.out.format("%.2f%n", avrPriceByKm) + " zł");


    }
}
