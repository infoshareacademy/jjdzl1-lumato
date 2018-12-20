package com.lumato.appfunctions.carsmanagement;

import com.lumato.inout.UserInput;
import com.lumato.tools.AppExit;
import com.lumato.tools.AppMessages;
import com.lumato.tools.CLS;

import java.io.IOException;

public class DeleteCarMenu {

    private static boolean isIdOk;
    private static String id;

    public static void init() throws IOException {
        isIdOk = false;
        while (!isIdOk) {
            showInfo();
            UserCarTools.showProfileCars();
            id = askForCarId();
            if (!validateId(id)) {
                CLS.clearScreen();
                System.out.println("PODAŁES NIEPOPRAWNE ID!");
                continue;
            } else {
                if (executeGoodId()) break;
                else isIdOk = false;
            }
        }
    }

    private static String askForCarId() throws IOException {
        System.out.print("\nPodaj id auta, które chcesz usunąć: ");
        return UserInput.getUserStringInput();
    }

    private static void showInfo(){
        System.out.println("USUWANIE AUTA");
        System.out.println(AppMessages.EXIT_INFO.getMessage());
    }

    //checking if user input (id) can be proceeded -> is input a number? does car(id) exist?
    private static boolean validateId(String id){
        if (id.matches("\\d*")) {
            int idAsInteger = Integer.parseInt(id);
            if (idAsInteger > 0 && idAsInteger <= UserCarTools.countCars()){
                return true;
            }
        }
        return false;
    }

    public static boolean executeGoodId() throws IOException {
        if ("p".equals(id)) {
            CLS.clearScreen();
            UserCarsPanel.init();
            return true;
        } else if ("q".equals(id)) {
            CLS.clearScreen();
            AppExit.exitApplication();
            return true;
        } else {
            CLS.clearScreen();
            if (askIfSure()) {
                CLS.clearScreen();
                UserCarTools.deleteCar(Integer.valueOf(id)); //deletes car and goes to the right place in app
                return true;
            } else {
                CLS.clearScreen();
                DeleteCarMenu.init();
                return false;
            }
        }
    }

    public static boolean askIfSure() throws IOException {
        String answer = "";
        while (true) {
            System.out.println("Are you sure that you want to delete: <CAR DATA>");
            System.out.print(AppMessages.YES_NO_MSG.getMessage());
            answer = UserInput.getUserStringInput();
            if (answer.equals("tak")) return true;
            else if (answer.equals("nie")) return false;
            else System.out.println("Miałeś wpisać 'tak' lub 'nie'!");
        }
    }
}
