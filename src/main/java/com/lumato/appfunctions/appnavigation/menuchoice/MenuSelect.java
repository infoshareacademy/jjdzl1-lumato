package com.lumato.appfunctions.appnavigation.menuchoice;

import com.lumato.inout.UserInput;

import java.io.IOException;
import java.util.Scanner;


public class MenuSelect {

    public static String validateInput(String regex, String specialChar, String monitWhenWrong) {

        String getUserStringInput = "";


        try {
            getUserStringInput = UserInput.getUserStringInput();
            while (!isValid(getUserStringInput, regex, specialChar)) {
                System.out.println(monitWhenWrong);
                getUserStringInput = UserInput.getUserStringInput();
            }
        } catch (IOException e) {
            System.out.println("Wystąpił niespodziewany wyjątek!" + e.getMessage());
        }
        return getUserStringInput;


        /*do {
            try {
                getUserStringInput = UserInput.getUserStringInput();
            } catch (IOException e) {
                System.out.println("Wystąpił niespodziewany wyjątek!" + e.getMessage());
            }
        } while (!isValid(getUserStringInput, regex, specialChar));
        */
    }

    static boolean isValid(String getUserStringInput, String regex, String specialChar) {
        if (getUserStringInput.matches(regex) || getUserStringInput.matches(specialChar)) return true;
        else return false;
    }
}