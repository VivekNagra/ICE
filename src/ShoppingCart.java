import java.util.ArrayList;
import java.util.ListIterator;

public class ShoppingCart
{

ArrayList<Item> item;

double cartTotal;


ShoppingCart()
{
    this.item = new ArrayList<Item>();
    this.cartTotal = 0;
}

public double getCartTotal()
{
    ListIterator<Item> i1 = item.listIterator();
    this.cartTotal = 0;
    while(i1.hasNext())
    {
        Item item1 = i1.next();
        this.cartTotal = this.cartTotal + (item1.getPrice());
    }

return this.cartTotal;
}


}
