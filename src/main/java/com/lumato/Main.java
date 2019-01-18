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

    }

    public static void runApplication() throws Exception {
        /** erase session data if it somehow exists... */
        SessionData.eraseSessionData();
        /** initialize first window */
        Shortcuts.runInitialWindow();
    }
}
