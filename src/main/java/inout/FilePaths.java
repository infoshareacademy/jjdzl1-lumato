package main.java.inout;

public class FilePaths {

    private static String currentUserPath = "resources/currentUser.txt";
    private static String userListPath = "resources/userList.txt";

    public static String getCurrentUserPath() {
        return currentUserPath;
    }

    public static String getUserListPath() {
        return userListPath;
    }
}
