package sem4.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/studentsDb";

        String user = "postgres";

        String password = "1556";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
