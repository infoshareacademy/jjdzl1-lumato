package main.java.tools;

import main.java.tools.CLS;

public class AppExit {

    public static void exitApplication(){
        CLS.clearScreen();
        System.out.println("Dziękujemy za skorzystanie z aplikacji. Do zobaczenia!");
        System.exit(0);
    }

}
