package BusinessLayer;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    
    public abstract int computePrice();
    public abstract String toString();
    public abstract String getTitle();
    public abstract float getRating();
    public abstract int getCalories();
    public abstract int getProtein();
    public abstract int getFat();
    public abstract int getSodium();
    public abstract void setTitle(String a);
    public abstract void setRating(float a);
    public abstract void setCalories(int a);
    public abstract void setProtein(int a);
    public abstract void setFat(int a);
    public abstract void setSodium(int a);
    public abstract void setPrice(int a);
    @Override
    public abstract boolean equals(Object o);
    @Override
    public abstract int hashCode();
    public abstract int getOrderedTimes();
    public abstract void increaseOrderedTimes();
    public abstract int getReport4();
    public abstract void increaseReport4();

}
