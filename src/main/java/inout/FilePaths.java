package main.java.inout;

public class FilePaths {

    private static String currentUserPath = "resources/currentUser.txt";
    private static String userListPath = "resources/userList.txt";

    public static String getInputDataLocation() {
        return inputDataLocation;
    }

    private static String inputDataLocation = "E:\\\\Robocze\\\\09. JAVA\\\\09.02 Java Projects\\\\09.02.01 Szkolenie\\\\Projekt-kalkulatorpaliw\\\\src\\\\main\\\\test.txt";


    public static String getCurrentUserPath() {
        return currentUserPath;
    }

    public static String getUserListPath() {
        return userListPath;
    }
}
