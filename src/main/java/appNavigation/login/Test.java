package main.java.appNavigation.login;

//TEST, do usunięcia potem

public class Test {

    private UserData userData;

    public Test(UserData userData){
        this.userData = userData;
    }

    public void test(){
        System.out.println("W TYM MIEJSCU NORMALNIE POWINNO BYC MAIN MENU");
        System.out.println("TEST CZY ZMIENNE SESYJNE Z LOGOWANIA DOCIERAJA DO KOLEJNYCH KLAS");
        System.out.println("Login: " + userData.getUserName());
        System.out.println("Password: " + userData.getUserPassword());
    }
}
