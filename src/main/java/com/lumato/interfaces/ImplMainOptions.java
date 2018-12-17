package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;
import com.lumato.tools.CLS;

public class MainOptionsImpl implements UserSelect {
    @Override
    public void PrintHeader() {
        System.out.println("\nNowe !!TESTOWE!! Menu z interfejsa!\nWilkomen in our wanderabu menu!");

    }

    @Override
    public void PrintOptions() {
        System.out.println("Dostepne opcje:"
                + "\n1: Sikaj pod mur."
                + "\n2: Sikaj pod latarnia."
                + "\n3: Sikaj pod brzoza.");

    }

    @Override
    public char ValidateUserInput() {
        String specialChar = "q";
        String actionWord = "zakończyć";
        if(specialChar.length() != 0) System.out.printf("Wybierz opcję lub wpisz %s aby %s: ", specialChar, actionWord);
        else System.out.println("Wybierz jedną z dostępnych opcji.");


        char choice = MenuSelect.validateInput(("[1-3]"), specialChar, actionWord);
        return choice;
    }

    @Override
    public void SelectedOptions(char choice) {

            switch (choice) {
                case '1':
                    System.out.println("Daty wprowadzanie");
                    CLS.clearScreen();
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

