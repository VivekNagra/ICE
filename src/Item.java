public class Item extends Products
{
    private int pID;
    private String name;
    private String  description;
    private double price;


    public Item(int pID, String name, String description, double price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Item{" +
                "pID=" + pID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
    public String getDescription()
    {
        return description;
    }

    public int getpID()
    {
        return pID;
    }
}
