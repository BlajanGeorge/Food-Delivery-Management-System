package BusinessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
    private static int contor=0;
    private final int orderID;
    private final int clientID;
    private final ArrayList<MenuItem> orderedProducts = new ArrayList<>();
    private final Date orderDate;
    private int orderPrice;

    public Order(int clientID,ArrayList<MenuItem> orderedProducts)
    {
        contor++;
        this.orderID=contor;
        this.orderedProducts.addAll(orderedProducts);
        this.clientID=clientID;
        this.orderDate = new Date();
        for(MenuItem i : orderedProducts)
        {
            orderPrice+=i.computePrice();
        }
    }
    public int getOrderID()
    {
        return this.orderID;
    }
    public int getClientID()
    {
        return this.clientID;
    }
    public int getOrderPrice()
    {
        return this.orderPrice;
    }
    public ArrayList<MenuItem> getOrderedProducts()
    {
        return this.orderedProducts;
    }
    public Date getOrderDate()
    {
        return orderDate;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order))
            return false;
        return ((Order) o).getOrderID() == this.orderID;
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.orderID);
    }
    public static int getContor()
    {
        return contor;
    }
    public static void setContor(int c)
    {
        contor=c;
    }

}
