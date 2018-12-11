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

    public static String obtainUserLogin() throws IOException {
        System.out.print("PODAJ LOGIN: ");
        String input = "";
        try {
            userInput = new BufferedReader(new InputStreamReader(System.in));
            input = userInput.readLine();
        } catch (IOException e){
            System.out.println("LIPA");
        }
        return input;
    }

    //w tej chwili dwie metody są takie same,
    // jednak w przyszłości możemy chcieć zamaskować hasło stąd oddzielna metoda
    public static String obtainUserPassword() throws IOException {
        System.out.print("PODAJ HASLO: ");
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
