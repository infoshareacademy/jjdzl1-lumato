import appfunctions.carsmanagement.UserCarsPanel;
import main.java.inout.SessionData;
import main.java.appnavigation.Shortcuts;


public class Main {

    /**
     * main method to run the application
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        //runApplication();
        UserCarsPanel.init();
    }

    public static void runApplication() throws Exception {
        //wyczyszczenie danych sesyjnych w razie jakby jeszcze istniały po poprzednim użytkowaniu
        SessionData.eraseSessionData();
        //inicjalizacja okna startowego
        Shortcuts.runInitialWindow();
    }

}
