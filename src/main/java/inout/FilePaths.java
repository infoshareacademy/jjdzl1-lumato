package main.java.inout;

public class FilePaths {

    private static String user;
    private static String currentUserPath = "resources/currentUser.txt";
    private static String userListPath = "resources/userList.txt";
    private static String txtDataLocation = "src/main/test.txt";
    private static String csvDataLocation = "src/main/test.csv";

    //żeby uzyskać tą ścieżkę, należy utworzyć obiekt klasy FilePaths
    private static String currentUserCarListPath;

    public FilePaths(){
        user = main.java.inout.SessionData.getCurrentUserName();
        currentUserCarListPath = "resources/profiles/" + user + "/" + user + "_cars.txt";
    }

    public FilePaths(String userName){
        user = userName;
        currentUserCarListPath = "resources/profiles/" + user + "/" + user + "_cars.txt";
    }

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

    public static String getCurrentUserCarListPath(){
        return currentUserCarListPath;
    }
}
