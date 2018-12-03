package main.java.appNavigation.login;

/**
 * session data
 */
public class UserData {

    private String userName;
    private String userPassword; // w tej wersji programu hasło nie będzie istniało

    public UserData(String userName, String userPassword){
        this.userName=userName;
        this.userPassword=userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
