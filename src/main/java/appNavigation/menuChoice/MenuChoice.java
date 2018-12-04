package appNavigation.menuChoice;

import java.io.IOException;
import java.util.Scanner;

//Klasa pobiera dane poprzez klasę UserInput i przyjmuję trzy argumrnty:
//regex, specialChar i specialCharAction. Regex odpowiada za wybór opcji (np 1-9)
//specialChar za akcje specjalne (np 'q' jak quit)
//specialCharAction za akcję powiązaną ze specialChar
//Pętla wykonuję przynajmniej jeden "obrót" i działa, dopuki warunek isValid jest false
//Warunek jest definiownany w metodzie isValid, która pobiera getUserinput, regex, specialChar, porównuje je i zwraca true lub false


public class MenuChoice {

    public static String validateInput(String regex, String specialChar, String specialCharAction) {

        Scanner in = new Scanner(System.in);
        String getUserStringInput = "";

        do {
            System.out.printf("Wybierz opcję lub wpisz %s aby %s: ", specialChar, specialCharAction);
            try {
                getUserStringInput = main.java.inout.UserInput.getUserStringInput();
            } catch (IOException e) {
                System.out.println("Wystąpił niespodziewany wyjątek!" + e.getMessage());
            }
        } while (!isValid(getUserStringInput, regex, specialChar));
        return getUserStringInput;
    }

    static boolean isValid(String getUserStringInput, String regex, String specialChar){
       if(getUserStringInput.matches(regex) || getUserStringInput.matches(specialChar)) return true;
       else return false;
    }
}
