package com.lumato;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.inout.SessionData;
import com.lumato.inout.UserInput;
import com.lumato.inout.WriteReadFile;
import com.lumato.interfaces.RunMenuChoices;


public class Main {

    /**
     * main method to run the application
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        runApplication();
        RunMenuChoices.mainOptions();
        //WriteReadFile.writeText(UserInput.getUserStringInput(),true,"Paliwko");



    }

    public static void runApplication() throws Exception {

        //wyczyszczenie danych sesyjnych w razie jakby jeszcze istniały po poprzednim użytkowaniu
        SessionData.eraseSessionData();
        //inicjalizacja okna startowego
        Shortcuts.runInitialWindow();
    }
}
