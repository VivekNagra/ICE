import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

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

    public static void displayAddedItems(Customer currentCustomer) throws SQLException, FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);



        for (Item i: Customer.addedItems)
        {
            System.out.println("item nr: " + addedItems.indexOf(i)+ " " + i.toString());
        }
        TextUI.promptEnterKey();

        System.out.println("1. remove a item from cart (ENTER ITEM NR: ");
        System.out.println("2. return to main menu");

        int input = scan.nextInt();
        switch(input)
        {
            case 1:
                Scanner scan2 = new Scanner(System.in);
                System.out.println("please enter item nr that you want to remove");
                int removeItem = scan2.nextInt();

                System.out.println(addedItems.get(removeItem)+ " has been removed");
                addedItems.remove(input);
                break;

            case 2:
                TextUI.displayMainMenu(currentCustomer);
                break;
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
        return total;
    }


}
