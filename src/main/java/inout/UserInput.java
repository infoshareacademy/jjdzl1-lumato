package inout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * this class gets user input
 */

public class UserInput {

    private static BufferedReader userInput2 = new BufferedReader(new InputStreamReader(System.in));

    /**
     * This methods gets String input from console (user-string-input)
     * @return String value
     * @throws IOException
     */
    public static String getUserStringInput() throws IOException {
        String input = "";
        try {
            userInput2 = new BufferedReader(new InputStreamReader(System.in));
            input = userInput2.readLine();

        } catch (IOException e){
            System.out.println("LIPA");
        }
        return input;
    }

}
