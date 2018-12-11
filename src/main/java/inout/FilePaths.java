package main.java.inout;

public class FilePaths {

    private static String currentUserPath = "resources/currentUser.txt";
    private static String userListPath = "resources/userList.txt";
    private static String txtDataLocation = "src/main/test.txt";
    private static String csvDataLocation = "src/main/test.csv";

    public static String getCsvDataLocation() {
        return csvDataLocation;
    }
    
    public static String getTxtDataLocation() {
        return txtDataLocation;
    }

    public static String getCurrentUserPath() {
        return currentUserPath;
    }

    public static String getUserListPath() {
        return userListPath;
    }
}
