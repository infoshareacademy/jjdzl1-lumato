package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;
import com.lumato.tools.CLS;
import com.lumato.tools.DataReader;

import java.io.IOException;

public class ImplDateMenu implements InterfaceUserSelect {
    @Override
    public void printHeader() {
        System.out.println("\nWprowadz kurde date dzbanie!" );
    }

    @Override
    public void printOptions() {
        System.out.println("1. Chce uzyc dzisiejszej daty."
                + "\n2. Chcę wprowadzic ja recznie"
                + "\np - aby powrócić.");
    }

    @Override
    public String validateUserInput() {
        String specialChar = "p";
        String actionWord = "powrócić do menu głównego";
        String choice = MenuSelect.validateInput(("[1-2]"), specialChar, actionWord);


        return choice;
    }

    @Override
    public void selectedOptions(String choice) throws IOException {
        switch (choice) {
            case "1":
                System.out.println("Data wprowadzona automatycznie");
                System.out.println(DataReader.dateReader());
                CLS.clearScreen();
                RunMenuChoices.fuelMenuOptions();
                break;
            case "2":
                System.out.println("\n\nNo to pisz te date.");
                RunMenuChoices.dataManualInput();
                CLS.clearScreen();
                RunMenuChoices.fuelMenuOptions();
                break;
            case "p":
                System.out.println("Powrót do menu głównego:");
                CLS.clearScreen();
                Shortcuts.runMainMenu();
                break;

        }
    }
}