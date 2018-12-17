package com.lumato.interfaces;

public class RunMenuChoices {
    public static void MainOptions(){
        MainOptionsImpl mainMenuOptions = new MainOptionsImpl();
        mainMenuOptions.PrintHeader();
        mainMenuOptions.PrintOptions();
        mainMenuOptions.SelectedOptions(mainMenuOptions.ValidateUserInput());
    }

    public static void DataInputOptions(){
        DataInputImpl dataInput = new DataInputImpl();
        dataInput.PrintHeader();
        dataInput.PrintOptions();
        dataInput.SelectedOptions(dataInput.ValidateUserInput());
    }


}
