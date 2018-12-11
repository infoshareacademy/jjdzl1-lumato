package tools;

import main.java.inout.SessionData;

import java.io.IOException;

public class AppExit {



    public static void exitApplication() throws IOException {
        CLS.clearScreen();
        System.out.println("Dziękujemy za skorzystanie z aplikacji. Do zobaczenia!");
        SessionData.eraseSessionData();
        System.exit(0);
    }

    public void deleteSessionData(){

    }

}
