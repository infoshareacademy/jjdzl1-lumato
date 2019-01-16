package com.lumato.inout;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * this class gets user input
 */

public class UserInput {

    private static BufferedReader userInput;

    //pobieranie Stringa od użytkownika
    public static String getUserStringInput() throws IOException {
        String input = "";
        try {
            userInput = new BufferedReader(new InputStreamReader(System.in));
            input = userInput.readLine();

        } catch (IOException e){
            System.out.println("LIPA");
        }
        return input;
    }

    public static String obtainUserLogin() throws IOException {
        System.out.print("PODAJ LOGIN: ");
        String input = "";
        try {
            userInput = new BufferedReader(new InputStreamReader(System.in));
            input = userInput.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return input;
    }

    public static String obtainUserPassword() throws IOException {
        System.out.print("PODAJ HASLO: ");
        String input = "";
        try {
            userInput = new BufferedReader(new InputStreamReader(System.in));
            input = userInput.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return input;
    }

}
