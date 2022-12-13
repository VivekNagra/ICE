import java.sql.*;
import java.util.ArrayList;

public class ItemDB
{
    public static String url = "jdbc:mysql://mysql11.unoeuro.com:3306/matechsolutions_dk_db_ice";
    public static String userName = "matechsolutions_dk";

    public static String password = "cenyktwx";
    public static Connection connection;

    public static ArrayList<Item> itemsDB = new ArrayList();

    public static void setupItemDB()
    {

        setupConnection();

        String req = "SELECT * FROM items";

        try
        {
            Statement statement = connection.createStatement();
            statement.execute(req);

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next())
            {
                int iID = resultSet.getInt("id");

                String name = resultSet.getString("name");

                String description = resultSet.getString("description");

                int price = resultSet.getInt("price");

                Item i = new Item(iID, name, description, price);

                itemsDB.add(i);
                //return itemsDB;
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        showItems();
        //return null;
    }

    private static void showItems()
    {
        for (Item i : itemsDB)
        {
            System.out.println("[" + itemsDB.indexOf(i) + "] = " + i.getName());
        }
    }

    public static void setupConnection()
    {
        try
        {
            connection = DriverManager.getConnection(url, userName, password);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
