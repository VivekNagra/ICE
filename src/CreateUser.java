import java.sql.*;
import java.util.Scanner;

public class CreateUser
{

    public static String createUser()
    {

        Connection conn;
        String url = "jdbc:mysql://mysql11.unoeuro.com:3306/matechsolutions_dk_db_ice";
        String userName = "matechsolutions_dk";
        String password = "cenyktwx";

        try
        {
            conn = DriverManager.getConnection(url, userName, password);
            Statement statement = conn.createStatement();
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter a username for your user: ");
            String user_username = scan.nextLine();

            System.out.println("Enter a password for your user: ");
            String user_password = scan.nextLine();

            statement.execute("INSERT INTO users(username,password) VALUES(" + "'" + user_username + "'" + "," + "'" + user_password + "'" + ")");
            System.out.println("User Created");

            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next())
            {
                System.out.println("successful login as " + resultSet.getString("userName"));
                return resultSet.getString("userName");
            } else
            {
                System.out.println("User does not exist - Please try again");
                createUser();
            }

        } catch (SQLException e) {

        }
        return null;
    }
}

