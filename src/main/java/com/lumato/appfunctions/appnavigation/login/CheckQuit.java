package com.lumato.appfunctions.appnavigation.login;

import com.lumato.appfunctions.appnavigation.Shortcuts;
import com.lumato.tools.AppExit;
import com.lumato.tools.CLS;

public class CheckQuit {

    public static boolean userWantsToQuit(String text) throws Exception {
        if ("q".equals(text) || "p".equals(text)) {
            return true;
        } else {
            return false;
        }
    }

    public static void executeQuit(String text) throws Exception {
        if ("q".equals(text)) {
            CLS.clearScreen();
            AppExit.exitApplication();

        } else if ("p".equals(text)){
            CLS.clearScreen();
            Shortcuts.runInitialWindow();
        }
    }

}
