public class Item extends Products
{
    private String name;
    private String description;
    private double price;
    private int pID;

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
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", pID=" + pID +
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
