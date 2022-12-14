import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main
{

    public static void main(String[] args) throws SQLException, FileNotFoundException
    {

        //DB.setupConnection();

        ItemDB.setupItemDB(); // create objects

        RunProgram.runShop(); //


    }
}
