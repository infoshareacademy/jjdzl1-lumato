//import appNavigation.login.InitialWindow;

import appNavigation.menuChoice.MenuChoice;
import appNavigation.menuChoice.MenuSelect;
import appNavigation.menuChoice.ShowMenu;

public class Main {

    /**
     * main method to run the application
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
//        new InitialWindow().init();
        ShowMenu.showMenu();
        char c = MenuSelect.validateInput(("[1-3]"),"q", "quit");
        MenuChoice.menuChoice(c);

    }
}
