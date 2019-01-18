package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;
import com.lumato.tools.CLS;
import com.lumato.tools.DataReader;

import java.io.IOException;

public class ImplFuelCostMenu implements InterfaceUserSelect {
    @Override
    public void printHeader() {
        System.out.println("-- Fuel cost section. Select one of available options:");
    }

    @Override
    public void printOptions() {
        System.out.println("\n1: Enter the date: " + "\n2: Enter costs: " + "\nR: Return to previous menu: ");

    }

    @Override
    public String validateUserInput() {
        String specialChar = "r";
        String actionWord = "to return to previous menu.";

        System.out.printf("Select available option or enter %s to %s: ", specialChar, actionWord);
        String infoWhenWrong = "\nIncorrect input. Try again or press " + specialChar + " to " + actionWord;
        return MenuSelect.validateInput(("[1-2]"), specialChar.toLowerCase(), infoWhenWrong);
    }


    @Override
    public void selectedOptions(String choice) throws IOException {
        switch (choice) {
            case "1":
                CLS.clearScreen();
                RunMenuChoices.dateMenuOptions();
                break;
            case "2":
                System.out.println("\n\n---------------- Pusta Metoda Macka ------------------\n\n");
                CLS.clearScreen();
                RunMenuChoices.fuelMenuOptions();
                break;
            case "r":
                CLS.clearScreen();
                Shortcuts.runMainMenu();
                break;
        }
    }
}
