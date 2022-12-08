import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB
{


        public static String url = "jdbc:mysql://mysql11.unoeuro.com:3306/matechsolutions_dk_db_ice";
        public static String userName = "matechsolutions_dk";
        public static String password = "cenyktwx";
        public static Connection connection;





        public static void setupConnection()
        {
            try
            {
                connection = DriverManager.getConnection(url, userName, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


}
