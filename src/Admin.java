public class Admin implements User
{
    private boolean admin;

    private String userName;
    private String password;

    private int aID;

    public Admin(boolean admin, String userName, String password, int aID)
    {
        this.admin = admin;
        this.userName = userName;
        this.password = password;
        this.aID = aID;
    }
}
