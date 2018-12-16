package com.lumato.appfunctions.appnavigation.menuchoice;

import main.java.inout.UserInput;

import java.io.IOException;
import java.util.Scanner;

//Klasa pobiera dane poprzez klasę UserInput i przyjmuję trzy argumrnty:
//regex, specialChar i specialCharAction.
//Regex odpowiada za wybór opcji (np 1-9) i musi zawierać warunek, że wpisany ma byc TYLKO JEDEN znak ---> czytaj niżej
//specialChar odpowiada za enentualne akcje specjalne (np 'q' jak quit)
//specialCharAction odpowiada za akcję powiązaną ze specialChar (np 'q' jak quit)
//Pętla wykonuję przynajmniej jeden "obrót" i działa, dopoki warunek isValid jest false
//Warunek jest definiownany w metodzie isValid, która pobiera getUserinput, regex, specialChar, porównuje je i zwraca true lub false
//Klasa zwraca char pobierając pierwszy (i ostatni) charakter ze stringu getUserStringInput. Aby to było możliwe,


public class MenuSelect {

    public static char validateInput(String regex, String specialChar, String specialCharAction) {

        Scanner in = new Scanner(System.in);
        String getUserStringInput = "";

        do {
            System.out.printf("Wybierz opcję lub wpisz %s aby %s: ", specialChar, specialCharAction);
            try {
                getUserStringInput = UserInput.getUserStringInput();
            } catch (IOException e) {
                System.out.println("Wystąpił niespodziewany wyjątek!" + e.getMessage());
            }
        } while (!isValid(getUserStringInput, regex, specialChar));
        return getUserStringInput.charAt(0);
    }

    static boolean isValid(String getUserStringInput, String regex, String specialChar){
       if(getUserStringInput.matches(regex) || getUserStringInput.matches(specialChar)) return true;
       else return false;
    }
}