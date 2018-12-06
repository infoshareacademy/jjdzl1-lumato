import inout.FilePaths;
import inout.UserInput;
import inout.WriteReadFile;
import inout.SessionData;
import main.java.appnavigation.Shortcuts;


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
        Shortcuts.runStartWindow();
//        WriteReadFile.writeToFile(FilePaths.getTxtDataLocation(),UserInput.getUserStringInput(),true);
//        System.out.println(WriteReadFile.readFromFile(FilePaths.getTxtDataLocation()));
//        System.out.println(WriteReadFile.readNthLine(FilePaths.getTxtDataLocation(),1));
//        WriteReadFile.writeCsv(UserInput.getUserStringInput());
//        WriteReadFile.writeText(UserInput.getUserStringInput(),true);
    }

}
