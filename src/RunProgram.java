public class RunProgram
{
    static String currentCustomer;
    public static void runShop()
    {
        TextUI.welcomeMenu(); // welcome the user to the program

        currentCustomer = TextUI.displayLogin();

        TextUI.displayMainMenu(currentCustomer);

        //TextUI.mainMenu(); // show user with different options to how to proceed.
    }

    /*public void runMainMenu()
    {
        String usrName = TextUI.displayLogin();
        // wait with this part
    }*/

}
