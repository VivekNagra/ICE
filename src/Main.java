import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main
{

    public static void main(String[] args) throws Exception
    {

        //DB.setupConnection();

        ItemDB.setupItemDB(); // create objects

        RunProgram.runShop(); //


    }
}
