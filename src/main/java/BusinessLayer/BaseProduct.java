package BusinessLayer;
import java.io.Serial;
import java.util.Objects;

public class BaseProduct extends MenuItem{

    @Serial
    private static final long serialVersionUID = 1234L;

    private String title;
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int orderedTimes=0;
    private int report4=0;

    public BaseProduct()
    {super();
    }
    public BaseProduct(String title,float rating,int calories,int protein,int fat,int sodium,int price)
    {
        super();
        this.title=title;
        this.rating=rating;
        this.calories=calories;
        this.protein=protein;
        this.fat=fat;
        this.sodium=sodium;
        this.price=price;
    }

    @Override
    public int computePrice() {
        return this.price;
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
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BaseProduct))
            return false;
        return ((BaseProduct) o).getTitle().equals(this.getTitle());
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
