package main.java.appnavigation;

//import appnavigation.login.InitialWindow;
//import appnavigation.login.SignIn;
//import appnavigation.login.SignUp;
//import appnavigation.menuchoice.ShowMenu;
//import appnavigation.menuchoice.MenuSelect;
//import appnavigation.menuchoice.MenuChoice;
import appnavigation.login.*;
import appnavigation.menuchoice.*;

//window initializations gathered in one class
public class Shortcuts {

    //runs starting window with login/create-new-profile/quit choice
    public static void runStartWindow() throws Exception {
        InitialWindow.init();
    }

    //runs login window
    public static void runLoginWindow() throws Exception {
        SignIn.init();
    }

    //runs create-new-profile window
    public static void runCreateNewProfileWindow() throws Exception {
        SignUp.init();
    }

    //runs Main Menu
    public static void runMainMenu(){
        ShowMenu.showMenu();
        char c = MenuSelect.validateInput(("[1-3]"),"q", "quit");
        MenuChoice.menuChoice(c);
    }

}
