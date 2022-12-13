import java.sql.*;
import java.util.Scanner;

public class UserLogin
{
    public static String run() {
        Connection connection;
        String url = "jdbc:mysql://mysql11.unoeuro.com:3306/matechsolutions_dk_db_ice";
        String userName = "matechsolutions_dk";
        String password = "cenyktwx";


        try {

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your user name: ");
            String user_userName = scan.nextLine();

            System.out.println("Enter your password");
            String user_password = scan.nextLine();

            connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM users WHERE username ='" + user_userName + "'" + "AND password ='" + user_password + "'");

            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                System.out.println("successful login as " + resultSet.getString("userName"));
                return resultSet.getString("userName");
            } else {
                System.out.println("User does not exist - Please try again");
                run();
            }

        } catch (SQLException e) {
            System.out.println("User not found");
        }

        return null;


    }
}