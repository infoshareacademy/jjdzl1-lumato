package com.lumato.tools;

import com.lumato.inout.SessionData;

import java.io.IOException;

public class AppExit {



    public static void exitApplication() throws IOException {
        CLS.clearScreen();
        System.out.println(AppMessages.AFTER_EXIT_INFO.getMessage());
        SessionData.eraseSessionData();
        System.exit(0);
    }

    public void deleteSessionData(){

    }

}
