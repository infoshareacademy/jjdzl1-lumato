import com.lumato.database.User;
import com.lumato.database.UserDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Properties;

public class DBTests {

    public static void main(String[] args) {

        /** create User class instance and read it: */
        test1UserObject();
        System.out.println("\n=================\n");

        /** get data from file: db.properties: */
        test2dbProps();

        System.out.println("\n=================\n");

        /** add new user */
        User newUser = new User();
        newUser.setUserLogin("lubieplacki");
        newUser.setUserPassword("jacek");
        newUser.setUserEmail(null);
        newUser.setUserLastLogin(null);
        test4addNewUser(newUser);

        System.out.println("\n=================\n");

        /** get all users list from db */
        test3getAllUsersList();
    }

    private static void test4addNewUser(User newUser){
        UserDAO userDAO = new UserDAO();
        userDAO.addNewUser(newUser);
    }

    private static void test3getAllUsersList() {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.getMetaData());
        LinkedList<User> allUsers = userDAO.getAllUsers();
        System.out.println(allUsers);
        userDAO.closeConnection();
    }

    private static void test2dbProps() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("User: '" + props.getProperty("user") + "'");
        System.out.println("Password: '" + props.getProperty("password") + "'");
        System.out.println("DB URL: '" + props.getProperty("dburl") + "'");
    }

    private static void test1UserObject() {
        User user = new User(1,
                "Anna",
                "lubieplacki",
                "anna@wanna.pl",
                new GregorianCalendar(2018, 03, 12),
                false);

        System.out.println(user.toString());
    }
}
