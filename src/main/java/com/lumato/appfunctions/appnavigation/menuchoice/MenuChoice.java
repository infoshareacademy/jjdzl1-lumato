package com.lumato.appfunctions.appnavigation.menuchoice;

import com.lumato.appfunctions.carsmanagement.UserCarsPanel;
import com.lumato.inout.FilePaths;
import com.lumato.inout.UserInput;
import com.lumato.inout.WriteReadFile;
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
<<<<<<< HEAD
            case '2':
                System.out.println("Opcja druga. Zapis do pliku");
                WriteReadFile.writeText(UserInput.getUserStringInput(),true,"Test.csv");
                break;
            case '3':
                System.out.println("Opcja trzecia. Odczyty z pliku");
                WriteReadFile.readCSV(1,"Test.csv");
=======
            case "2":
                System.out.println("Opcja druga.");
                break;
            case "3":
                System.out.println("Opcja trzecia.");
>>>>>>> e31abb0ee8cc5af799932b1222a28be8d6310c15
                break;
            case "q":
                System.out.println("Zakończenie programu lub coś innego.");
                break;
        }

    }
}
