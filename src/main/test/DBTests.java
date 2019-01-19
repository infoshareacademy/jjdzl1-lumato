import com.lumato.database.User;
import com.lumato.database.UserDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DBTests {

    public static void main(String[] args) {

        /** get data from file: db.properties: */
        test1dbProps();

        System.out.println("\n=================\n");

        /** add new user */
//        User newUser = new User();
//        newUser.setUserLogin("SebaDominator");
//        newUser.setUserPassword("maszwonty");
//        newUser.setUserEmail(User.USER_EMAIL_NONE);
//        newUser.setUserLastLogin(User.USER_LAST_LOGIN_NONE);
//        test2addNewUser(newUser);
//        System.out.println("New user created: " + newUser.getUserLogin());

        System.out.println("\n=================\n");

        /** get all users list from db */
        test3getAllUsersList();
        UserDAO dao = new UserDAO();
        System.out.println("RECORDS: " + dao.countRecords());
    }

    private static void test2addNewUser(User newUser){
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

    private static void test1dbProps() {
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
