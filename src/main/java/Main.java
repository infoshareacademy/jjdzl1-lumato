//import appNavigation.login.InitialWindow;

import tools.MenuChoice;

public class Main {

    /**
     * main method to run the application
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
//        new InitialWindow().init();
        MenuChoice.ValidateInput(("1-9"),"q", "quit");
    }
}
