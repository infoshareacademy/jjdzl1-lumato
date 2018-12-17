package com.lumato.interfaces;

public class RunMenuChoices {
    public static void MainOptions(){
        ImplMainOptions mainMenuOptions = new ImplMainOptions();
        mainMenuOptions.PrintHeader();
        mainMenuOptions.PrintOptions();
        mainMenuOptions.SelectedOptions(mainMenuOptions.ValidateUserInput());
    }

    public static void DateMenuOptions(){
        ImplDateMenu dateMenuOptions = new ImplDateMenu();
        dateMenuOptions.PrintHeader();
        dateMenuOptions.PrintOptions();
        dateMenuOptions.SelectedOptions(dateMenuOptions.ValidateUserInput());
    }

    public static void DataManualInput(){
        ImplManualDataInput dateInput = new ImplManualDataInput();
        dateInput.PrintHeader();
        dateInput.SelectedOptions(dateInput.ValidateUserInput());

    }
}
