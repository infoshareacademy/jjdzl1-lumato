package main.java.inout;

import java.io.IOException;

//klasa pomocnicza, wspierająca klasę SignIn
//w klasie tej obsługuje plik z danymi sesyjnymi (w tej chwili jest to tylko nazwa uzytkownika)
//w tej klasie również przeprowadzam walidację danych logowania

public class SessionData {

    private static final String currentUserPath = "resources/currentUser.txt";
    private static final String userListPath = "resources/userList.txt";

    public static void saveSessionData(String userLogin) throws IOException {
        TextSaveSimple.saveSimpleText(userLogin, currentUserPath);
    }

    public static void eraseSessionData() throws IOException {
        TextSaveSimple.saveSimpleText("", currentUserPath);
    }

    //tutaj mam stworzyć funkcję sprawdzającą, czy podany użytkownik istnieje (czy pojawia się w pliku userList.txt)

    //tutaj mam stworzyć drugą funkcję która sprawdzi, czy hasło dla danego użytkownika jest poprawne (na podstawie userList.txt)
}
