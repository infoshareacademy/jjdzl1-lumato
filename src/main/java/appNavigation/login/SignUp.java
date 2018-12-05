package main.java.appNavigation.login;

import main.java.tools.CLS;
import main.java.inout.UserInput;

public class SignUp {

    public void init() throws Exception {
        System.out.println("Rejestracja nie jest jeszcze dostępna");
        System.out.println("naciśnij enter by wrócić do ekranu startowego");
        String userInput = UserInput.getUserStringInput();
        CLS.clearScreen();
        new main.java.appNavigation.login.InitialWindow().init();
    }

}
