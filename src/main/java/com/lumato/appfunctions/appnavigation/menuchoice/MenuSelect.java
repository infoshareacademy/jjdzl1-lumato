package com.lumato.appfunctions.appnavigation.menuchoice;

import com.lumato.inout.UserInput;

import java.io.IOException;
import java.util.Scanner;


public class MenuSelect {

    public static String validateInput(String regex, String specialChar, String specialCharAction) {

        Scanner in = new Scanner(System.in);
        String getUserStringInput = "";

        do {
            try {
                getUserStringInput = UserInput.getUserStringInput();
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