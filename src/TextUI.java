import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI
{
    static Customer currentCustomer;

    public static void welcomeMenu()
    {
        System.out.println("Welcome to the webshop");
        promptEnterKey();

    }

    public static Customer displayLogin() throws Exception
    {
        System.out.println("Welcome to the Web Shop");
        System.out.println("1. Login (type login)");
        System.out.println("2. Create Login (type create user)");

        Scanner scan = new Scanner(System.in);

        String userInp = scan.nextLine();
        String customer = null;

        try // trying to use a try catch to catch wrong input and recall displayLogin
        {
            if (userInp.equalsIgnoreCase("login")) {
                currentCustomer = UserLogin.login();
            }

            else if (userInp.equalsIgnoreCase("create user")) {
                CreateUser.createUser();
            }
            return currentCustomer;
        }catch (InputMismatchException e)
        {
            System.out.println("please enter a login method");
            displayLogin();
        }
        return currentCustomer;
    }

    public static void displayMainMenu(Customer currentCustomer) throws SQLException, FileNotFoundException
    {
        Scanner scan2 = new Scanner(System.in);

        System.out.println("Main menu, what would you like to do");
        System.out.println("1. Show catalogue");
        System.out.println("2. Show cart");
        System.out.println("3. Search for a item");
        System.out.println("4. Select item");
        System.out.println("5. Show cart total");
        System.out.println("6. Exit shop");


        int userInput = scan2.nextInt();

        switch(userInput)
        {
            case 1:
                ItemDB.showItems();
                promptEnterKey();
                displayMainMenu(currentCustomer);
                break;

            case 2:
                //insert shopping cart data
                Customer.displayAddedItems(currentCustomer);
                promptEnterKey();
                displayMainMenu(currentCustomer);
                break;
            case 3:
                System.out.println("please enter name or description of item you seek");
                ItemDB.searchItems();
                promptEnterKey();
                displayMainMenu(currentCustomer);
                break;
            case 4:
            itemSelection(currentCustomer);

            case 5:
                System.out.println(Customer.cartTotal());
                promptEnterKey();
                displayMainMenu(currentCustomer);
                break;

            case 6:
                exitMenu();
                break;

        }

    }


    public static void itemSelection (Customer currentCustomer) throws FileNotFoundException, SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("****************");
        System.out.println("What would you like to do: ");
        System.out.println("1. Search for item again");
        System.out.println("2. Select a item (please enter name of product)");
        System.out.println("3. return to Main Menu");

        int userInput = scan.nextInt();

        switch (userInput) {
            case 1:
                ItemDB.searchItems();
                promptEnterKey();
                itemSelection(currentCustomer);
                break;
            case 2:
                Item item = ItemDB.getItem();
                System.out.println("You have selected" + '\n' + item.getName());

                ItemDB.cartFunctions(item, currentCustomer);
                break;
            case 3:
                displayMainMenu(currentCustomer);
                break;

        }
    }


    public static void exitMenu()
    {
        System.out.println("Succesfully logged out");
        System.out.println("Goodbye");

    }

    public static void promptEnterKey()
    {
        System.out.println("Press enter to continue");
        try
        {
            System.in.read();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
