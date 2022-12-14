import java.util.ArrayList;
import java.util.ListIterator;

public class Customer implements User
{
   private String userName;
   private String password;
   private int iD;
   private static ArrayList<Item> addedItems = new ArrayList<>();

    public Customer(String userName, String password, int iD)
    {
        this.password = password;
        this.iD = iD;
        this.userName = userName;
    }

    public static void displayAddedItems()
    {
        for (Item i: Customer.addedItems)
        {
            System.out.println(i.toString());
        }
    }

    public static void addItem(Customer currentCustomer, Item i)
    {
       Customer.addedItems.add(i) ;
    }

    public static double cartTotal()
    {
        double total = 0;
        for (Item i: Customer.addedItems)
        {
            total += i.getPrice();
        }
        System.out.println(total);


        return total;
    }


}
