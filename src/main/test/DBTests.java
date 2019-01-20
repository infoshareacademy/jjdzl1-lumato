import com.lumato.database.User;
import com.lumato.database.UserDAO;

import java.util.LinkedList;

public class DBTests {

    public static void main(String[] args) {

        /** add new user */
        User newUser = new User();
        newUser.setUserLogin("Kozak");
        newUser.setUserPassword("grzybobranie");
        newUser.setUserEmail("muchomorek@grzyby.pl");
        newUser.setUserLastLogin(User.USER_LAST_LOGIN_NONE);
        test1addNewUser(newUser);
        System.out.println("New user created: " + newUser.getUserLogin());

        /** count users */
        UserDAO dao = new UserDAO();
        System.out.println("RECORDS: " + dao.countUsers());

        /** get all users list from db */
        test2getAllUsersList();

    }

    private static void test1addNewUser(User newUser){
        UserDAO userDAO = new UserDAO();
        userDAO.addNewUserToDB(newUser);
    }

    private static void test2getAllUsersList() {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.getMetaData());
        LinkedList<User> allUsers = userDAO.getAllUsers();
        System.out.println(allUsers);
        userDAO.closeConnection();
    }
}
