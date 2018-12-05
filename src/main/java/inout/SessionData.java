package main.java.inout;

import java.io.IOException;

//klasa pomocnicza, wspierająca klasę SignIn
//w klasie tej obsługuje plik z danymi sesyjnymi (w tej chwili jest to tylko nazwa uzytkownika)

public class SessionData {

    private static final String currentUserPath = FilePaths.getCurrentUserPath();

    //wpisanie nazwy użytkownika do pliku z danymi sesyjnymi
    public static void saveSessionData(String userLogin) throws IOException {
        WriteReadFile.saveSimpleText(userLogin, currentUserPath);
    }

    //czyszczenie danych sesyjnych
    public static void eraseSessionData() throws IOException {
        WriteReadFile.saveSimpleText("", currentUserPath);
    }

    //metoda pobiera nazwę zalogowanego użytkownika
    public static String getCurrenUserName(){
        String userName = "";
        userName = WriteReadFile.readNthLine(FilePaths.getCurrentUserPath(), 1);
        return userName;
    }
}
