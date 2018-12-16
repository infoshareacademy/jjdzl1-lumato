package main.java.appnavigation;

//import com.lumato.appfunctions.appnavigation.login.InitialWindow;
//import com.lumato.appfunctions.appnavigation.login.SignIn;
//import com.lumato.appfunctions.appnavigation.login.SignUp;
//import com.lumato.appfunctions.appnavigation.menuchoice.ShowMenu;
//import com.lumato.appfunctions.appnavigation.menuchoice.MenuSelect;
//import com.lumato.appfunctions.appnavigation.menuchoice.MenuChoice;
import com.lumato.appfunctions.carsmanagement.UserCarsPanel;
import com.lumato.appfunctions.appnavigation.login.*;
import com.lumato.appfunctions.appnavigation.menuchoice.*;

import java.io.IOException;

//window initializations gathered in one class
public class Shortcuts {

    //runs starting window with login/create-new-profile/quit choice
    public static void runInitialWindow() throws Exception {
        InitialWindow.init();
    }

    //runs login window
    public static void runLoginWindow() throws Exception {
        SignIn.init();
    }

    //runs create-new-profile window
    public static void runSignInWindow() throws Exception {
        SignUp.init();
    }

    //runs com.lumato.Main Menu
    public static void runMainMenu() throws IOException {
        ShowMenu.showMenu();
        char c = MenuSelect.validateInput(("[1-3]"),"q", "quit");
        MenuChoice.menuChoice(c);
    }

    public static void runCarManagementPanel() throws IOException {
        UserCarsPanel.init();
    }

}
