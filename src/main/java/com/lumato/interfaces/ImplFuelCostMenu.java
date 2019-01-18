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
                + "\n1: Wprowadz date: "
                + "\n2: Wprowadz dane: "
                + "\np: Powrót do ekranu startowego");

    }

    @Override
    public String validateUserInput() {
        String specialChar = "p";
        String actionWord = "powrócić do menu głównego.";

        System.out.printf("Wybierz opcję lub wpisz %s aby %s: ", specialChar, actionWord);

        return MenuSelect.validateInput(("[1-2]"), specialChar, actionWord);
    }

    @Override
    public void selectedOptions(String choice) throws IOException {
        switch (choice) {
            case "1":
                System.out.println("Wprowadzenie daty.");
                CLS.clearScreen();
                RunMenuChoices.dateMenuOptions();
                break;
            case "2":
                System.out.println("\n\n---------------- Pusta Metoda Macka ------------------\n\n");
                CLS.clearScreen();
                Shortcuts.runMainMenu();
                break;
            case "p":
                System.out.println("Powrót do menu głównego:");
                CLS.clearScreen();
                Shortcuts.runMainMenu();
                break;
        }
    }
}
