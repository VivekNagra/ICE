public class Item extends Products
{
    private String Name;
    private String description;
    private double price;
    private int pID;

    public Item(String Name, String description, double price, int pID)
    {
        this.Name = Name;
        this.description = description;
        this.price = price;
        this.pID = pID;
    }


    
}
