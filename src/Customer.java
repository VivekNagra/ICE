import java.util.ArrayList;

public class Customer implements User
{
   private String userName;
   private String password;
   private int iD;
   private ArrayList<Item> addedItems = new ArrayList<>();

    public Customer(String userName, String password, int iD)
    {
        this.addedItems = User.addedItems;
        this.password = password;
        this.iD = iD;
        this.userName = userName;
    }


    public static void createUsrItemList()
    {
       // User.addedItems.add();
    }
}
