package com.lumato.interfaces;

import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;

public class DataInputImpl implements UserSelect {
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
    public char ValidateUserInput() {
        char choice = MenuSelect.validateInput(("[1-2]"), "q", "quit");

        return choice;
    }

    @Override
    public void SelectedOptions(char choice) {
        switch (choice) {
            case '1':
                System.out.println("Data wprowadzona automatycznie kurewaa");
                break;
            case '2':
                System.out.println("No to pisz te date.");
                break;
        }
    }
}
