package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;

public class ImplDateMenu implements InterfaceUserSelect {
    @Override
    public void PrintHeader() {
        System.out.println("\nWprowadz kurde date dzbanie!" );
    }

    @Override
    public void PrintOptions() {
        System.out.println("1. Chce uzyc dzisiejszej daty."
                + "\n2. Chcę wprowadzic ja recznie");
    }

    @Override
    public String ValidateUserInput() {
        String specialChar = "p";
        String actionWord = "powrócić do menu głównego.";
        String choice = MenuSelect.validateInput(("[1-2]"), specialChar, actionWord);
        if(specialChar.length() != 0) System.out.printf("Wybierz opcję lub wpisz %s aby %s: ", specialChar, actionWord);
        else System.out.println("Wybierz jedną z dostępnych opcji.");

        return choice;
    }

    @Override
    public void SelectedOptions(String choice) {
        switch (choice) {
            case "1":
                System.out.println("Data wprowadzona automatycznie");
                break;
            case "2":
                System.out.println("\n\nNo to pisz te date.");
                RunMenuChoices.DataManualInput();
                break;
        }
    }
}
