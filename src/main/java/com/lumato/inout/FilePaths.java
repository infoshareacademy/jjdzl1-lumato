package com.lumato.inout;

public class FilePaths {

    private static String user;
    private static String currentUserPath = "src/main/resources/currentUser.txt";
    private static String userListPath = "src/main/resources/userList.txt";
    private static String txtDataLocation = "src/main/test.txt";
    private static String csvDataLocation = "src/main/test.csv";
    private static String profilesPath = "src/main/resources/profiles/";

    //to obtain this path, we need to create instance of FilePaths
    private static String currentUserCarListPath;

    public FilePaths(){
        user = SessionData.getCurrentUserName();
        currentUserCarListPath = "src/main/resources/profiles/" + user + "/" + user + "_cars.txt";
    }

    public FilePaths(String userName){
        user = userName;
        currentUserCarListPath = "src/main/resources/profiles/" + user + "/" + user + "_cars.txt";
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

    public static String getProfilesPath() {
        return profilesPath;
    }
}
