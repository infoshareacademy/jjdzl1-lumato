package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;
import com.lumato.tools.CLS;
import com.lumato.tools.DataReader;

import java.io.IOException;

public class ImplDateMenu implements InterfaceUserSelect {
    @Override
    public void printHeader() {
        System.out.println("-- Please select available options: " );
    }

    @Override
    public void printOptions() {
        System.out.println(
                    "1. I want to use todays date."
                + "\n2. I want to enter it manually."
                + "\nR - to return to previous menu.");
    }

    @Override
    public String validateUserInput() {
        String specialChar = "r";
        String actionWord = "to return to previous menu";
        String infoWhenWrong = "\nIncorrect input. Try again or press " + specialChar + " to " + actionWord;
        return MenuSelect.validateInput(("[1-2]"), specialChar.toLowerCase(), infoWhenWrong);
    }

    @Override
    public void selectedOptions(String choice) throws IOException {
        switch (choice) {
            case "1":
                System.out.println("\nDate entered automatically.");
                System.out.println(DataReader.dateReader());
                CLS.clearScreen();
                RunMenuChoices.fuelMenuOptions();
                break;
            case "2":
                RunMenuChoices.dataManualInput();
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