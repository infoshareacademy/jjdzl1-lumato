package main.java.inout;

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

    /**
     * This methods gets String input from console (user-string-input)
     * @return String value
     * @throws IOException
     */
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

}
