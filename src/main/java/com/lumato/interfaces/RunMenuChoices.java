package com.lumato.interfaces;

import java.io.IOException;

public class RunMenuChoices {
    public static void mainOptions() throws IOException {
        ImplMainOptions mainMenuOptions = new ImplMainOptions();
        mainMenuOptions.printHeader();
        mainMenuOptions.printOptions();
        mainMenuOptions.selectedOptions(mainMenuOptions.validateUserInput());
    }

    public static void dateMenuOptions(){
        ImplDateMenu dateMenuOptions = new ImplDateMenu();
        dateMenuOptions.printHeader();
        dateMenuOptions.printOptions();
        dateMenuOptions.selectedOptions(dateMenuOptions.validateUserInput());
    }

    public static void dataManualInput(){
        ImplManualDataInput dateInput = new ImplManualDataInput();
        dateInput.printHeader();
        dateInput.selectedOptions(dateInput.validateUserInput());
    }

    public static void fuelMenuOptions() throws IOException {
        ImplFuelCostMenu fuelCostMenu = new ImplFuelCostMenu();
        fuelCostMenu.printHeader();
        fuelCostMenu.printOptions();
        fuelCostMenu.selectedOptions(fuelCostMenu.validateUserInput());

    }


}
