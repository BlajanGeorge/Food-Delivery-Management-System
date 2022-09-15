package BusinessLayer;

import java.util.ArrayList;
import java.util.Objects;

public class CompositeProduct extends MenuItem{

    private String title;
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int orderedTimes=0;
    private final ArrayList<MenuItem> products;
    private int report4=0;

    public CompositeProduct(String title, ArrayList<MenuItem> products) {
        super();
        this.title=title;
        this.products=products;
        for(MenuItem i : products)
        {
            this.rating+=i.getRating();
            this.calories+=i.getCalories();
            this.protein+=i.getProtein();
            this.fat+=i.getFat();
            this.sodium+=i.getSodium();
            this.price+=i.computePrice();
        }
        this.rating/=products.size();
    }
    public String getTitle()
    {
        return this.title;
    }
    public float getRating()
    {
        return this.rating;
    }
    public int getCalories()
    {
        return this.calories;
    }
    public int getProtein()
    {
        return this.protein;
    }
    public int getFat()
    {
        return this.fat;
    }
    public int getSodium()
    {
        return this.sodium;
    }
    public void setTitle(String a)
    {
        this.title=a;
    }
    public void setRating(float a)
    {
        this.rating=a;
    }
    public void setCalories(int a)
    {
        this.calories=a;
    }
    public void setProtein(int a)
    {
        this.protein=a;
    }
    public void setFat(int a)
    {
        this.fat=a;
    }
    public void setSodium(int a)
    {
        this.sodium=a;
    }
    public void setPrice(int a)
    {
        this.price=a;
    }
    public String toString() {
        return this.title + " " + this.rating + " " + this.calories + " " + this.protein + " " + this.fat + " " + this.sodium + " " + this.price;
    }
    public String getElements(){
        String a="";
        a+=this.title+": ";
        for(MenuItem i : products)
        {
            a+=i.getTitle()+" ";
        }
        return a;
    }
    @Override
    public int computePrice() {
        return this.price;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CompositeProduct))
            return false;
        return ((CompositeProduct) o).getTitle().equals(this.getTitle());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.title);
    }
    public int getOrderedTimes()
    {
        return this.orderedTimes;
    }
    public void increaseOrderedTimes()
    {
        this.orderedTimes++;
    }
    public int getReport4()
    {
        return this.report4;
    }
    public void increaseReport4()
    {
        this.report4++;
    }
}
