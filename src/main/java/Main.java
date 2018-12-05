
import main.java.appNavigation.login.InitialWindow;
import main.java.inout.SessionData;

public class Main {

    /**
     * main method to run the application
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        runApplication();
    }

    public static void runApplication() throws Exception {
        //wyczyszczenie danych sesyjnych w razie jakby jeszcze istniały po poprzednim użytkowaniu
        //np. po siłowym wyłączeniu programu plik z daną o zalogowanym użytkowniku może być zachowany
        SessionData.eraseSessionData();
        //program inicjaluzjemy poprzez startowy ekran z wyborem login/create new account/exit application
        InitialWindow.init();
    }

}
