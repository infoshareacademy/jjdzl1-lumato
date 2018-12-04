package appNavigation.menuChoice;

import java.io.IOException;
import java.util.Scanner;

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
