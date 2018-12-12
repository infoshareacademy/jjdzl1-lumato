package appnavigation.login;

public class PrintMessage {

    public static void wrongPasswordMessage(){
        System.out.print("Niepoprawne hasło! ");
        System.out.print("Hasło musi składać się z minimum 5 znaków. ");
        System.out.println("Hasło nie może zawierać znaku \";\"");
    }

    public static void wrongLoginMessage(){
        System.out.print("Niepoprawny login! ");
        System.out.print("Nazwa użytkownika musi składać się minimum z 4 znaków. ");
        System.out.println("Nazwa użytkownika nie może zawierać znaku \";\".");
    }

    public static void userExistsMessage() {
        System.out.println("Użytkownik o takim nicku już istnieje!");
    }
}
