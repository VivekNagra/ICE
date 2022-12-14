import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RunProgram
{
    static Customer currentCustomer;

    public static void runShop() throws SQLException, FileNotFoundException
    {
        TextUI.welcomeMenu(); // welcome the user to the program

        currentCustomer = TextUI.displayLogin();

        TextUI.displayMainMenu(currentCustomer);

        //TextUI.mainMenu(); // show user with different options to how to proceed.
    }
}