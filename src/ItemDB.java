import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemDB
{
    public static String url = "jdbc:mysql://mysql11.unoeuro.com:3306/matechsolutions_dk_db_ice";
    public static String userName = "matechsolutions_dk";

    public static String password = "cenyktwx";
    public static Connection connection;

    public static ArrayList<Item> itemsDB = new ArrayList();
    public static ArrayList<Item> searchedItems = new ArrayList();


    public static ArrayList setupItemDB()
    {
        //set up of arraylist containing items
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

        return itemsDB;
    }

    //search for products
    public static ArrayList<Item> searchItems() {
        setupConnection();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your search: ");

        String input = scan.nextLine();

        String search = "SELECT * FROM items WHERE name LIKE " + "'" + "%" + input + "%" + "'" + " OR " + "description LIKE " + "'" + "%" + input + "%" + "'";

        try {

            Statement statement = connection.createStatement();
            statement.execute(search);

            ResultSet res = statement.getResultSet();

            while (res.next()) {


                int iID = res.getInt("id");

                String iName = res.getString("name");

                String iDescription = res.getString("description");

                float iPrice = res.getFloat("price");

                Item i = new Item(iID, iName, iDescription, iPrice);

                searchedItems.add(i);
            }
            return searchedItems;

        } catch (SQLException e)
        {

        }

        return null;
    }


    public static Item getItem()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the name of the desired item: ");

        String name = scan.nextLine();

        for (Item i : itemsDB)
        {
            if (i.getName().contains(name))
                return i;
        }

        return null;
    }


    public static void showItems()
    {
        //to display items in arraylist with for each loop
        for (Item i : itemsDB)
        {
            System.out.println("[" + itemsDB.indexOf(i) + "] = " + i.toString());
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
