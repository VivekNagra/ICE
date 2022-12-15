import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RunProgram
{
    static Customer currentCustomer;

    public static void runShop() throws Exception
    {
        TextUI.welcomeMenu(); // welcome the user to the program

        currentCustomer = TextUI.displayLogin();

        TextUI.displayMainMenu(currentCustomer);

        
    }
}