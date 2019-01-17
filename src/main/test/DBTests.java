import com.lumato.database.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Properties;

public class DBTests {

    public static void main(String[] args) {

        /** utworzenie obiektu klasy User i odczytanie go: */

        User user = new User(1,
                "Anna",
                "lubieplacki",
                "anna@wanna.pl",
                new GregorianCalendar(2018, 03, 12),
                false);

        System.out.println(user.toString());

        System.out.println("\n=================\n");

        /** pobranie danych z pliku db.properties: */
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

}
