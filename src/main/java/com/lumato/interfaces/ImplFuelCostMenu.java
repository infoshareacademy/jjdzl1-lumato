package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;
import com.lumato.tools.CLS;
import com.lumato.tools.DataReader;

import java.io.IOException;

public class ImplFuelCostMenu implements InterfaceUserSelect {
    @Override
    public void printHeader() {
        System.out.println("Wybierz jedną z dostępnych opcji:");
    }

    @Override
    public void printOptions() {
        System.out.println("Dostepne opcje:"
                + "\n1: Wprowadz dane:."
                + "\np: Powrót do ekranu startowego");

    }

    @Override
    public String validateUserInput() {
        String specialChar = "p";
        String actionWord = "powrócić do menu głównego.";
        if(specialChar.length() != 0) System.out.printf("Wybierz opcję lub wpisz %s aby %s: ", specialChar, actionWord);
        else System.out.println("Wybierz jedną z dostępnych opcji.");

        return MenuSelect.validateInput(("[1-3]"), specialChar, actionWord);
    }

    @Override
    public void selectedOptions(String choice) throws IOException {
        switch (choice) {
            case "1":
                System.out.println("Data wprowadzona automatycznie");
                System.out.println(DataReader.dateReader());
                break;
            case "p":
                System.out.println("Powrót do menu głównego:");
                CLS.clearScreen();
                Shortcuts.runMainMenu();
                break;
        }
    }
}
