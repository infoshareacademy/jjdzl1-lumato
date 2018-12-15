package appnavigation.menuchoice;

import appfunctions.carsmanagement.UserCarsPanel;
import tools.CLS;

import java.io.IOException;

public class MenuChoice {
    public static void menuChoice(char selector) throws IOException {
        switch (selector) {
            case '1':
                System.out.println("Moje pojazdy");
                CLS.clearScreen();
                UserCarsPanel.init();
                break;
            case '2':
                System.out.println("Opcja druga.");
                break;
            case '3':
                System.out.println("Opcja trzecia.");
                break;
            case 'q':
                System.out.println("Zakończenie programu lub coś innego.");
                break;
        }

    }
}
