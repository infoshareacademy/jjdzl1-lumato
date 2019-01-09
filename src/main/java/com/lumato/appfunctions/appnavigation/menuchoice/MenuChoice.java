package com.lumato.appfunctions.appnavigation.menuchoice;

import com.lumato.appfunctions.carsmanagement.UserCarsPanel;
import com.lumato.inout.FilePaths;
import com.lumato.inout.UserInput;
import com.lumato.inout.WriteReadFile;
import com.lumato.interfaces.RunMenuChoices;
import com.lumato.tools.CLS;

import java.io.IOException;

public class MenuChoice {
    public static void menuChoice(String selector) throws IOException {
        switch (selector) {
            case "1":
                System.out.println("Moje pojazdy");
                CLS.clearScreen();
                UserCarsPanel.init();
                break;
            case "2":
                System.out.println("Koszty paliwa itd.");
                CLS.clearScreen();
                RunMenuChoices.fuelMenuOptions();
                break;
            case "3":
                System.out.println("Koszty napraw itd.");
                break;
            case "q":
                System.out.println("Zakończenie programu lub coś innego.");
                break;
        }
    }
}