package BusinessLayer;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: Blajan George-Paul
 * @Date: 14.05.2021
 */
public interface IDeliveryServiceProcessing {

     void importBaseProducts() throws IOException, ClassNotFoundException;

     /**
      * @pre menuItem!=null
      * @param menuItem added product
      * @return add a product to products hashSet
      */
     void addProduct(MenuItem menuItem);
     /**
      * @pre menuItem!=null
      * @param menuItem deleted product
      * @return delete a product from products hashSet
      */
     void deleteProduct(MenuItem menuItem);
     /**
      * @pre oldItem!=null
      * @pre oldItem!=null
      * @param oldItem edited product
      * @param newItem product for edit
      * @return edit a product from products hashSet
      */
     void editProduct(MenuItem oldItem,MenuItem newItem);
     JTable showProducts();

     /**
      * @pre startHour>=0
      * @pre startMinute>=0
      * @pre endHour>=0
      * @pre endMinutes>=0
      * @param startHour start Hour
      * @param startMinutes start Minutes
      * @param endHour end Hour
      * @param endMinutes end Minutes
      * @return generate a file .txt with report
      */
     void reportOne(int startHour,int startMinutes,int endHour,int endMinutes);

     /**
      * @pre orderedTime>=0
      * @param orderedTime ordered Time
      * @return generate a file .txt with report
      */
     void reportTwo(int orderedTime);

     /**
      * @pre orderedTime>=0
      * @pre valueOfOrder>=0
      * @param orderedTime ordered Time
      * @param valueOfOrder  value bound for each order
      * @return generate a file .txt with report
      */
     void reportThree(int orderedTime,int valueOfOrder);

     /**
      * @pre day>=0
      * @param day day for matching orders
      * @return generate a file .txt with report
      */
     void reportFour(int day);

     /**
      * @post jTable!=null
      * @param title title for match
      * @param rating rating for match
      * @param calories calories for match
      * @param protein protein for match
      * @param fat fat for match
      * @param sodium sodium for match
      * @param price price for match
      * @return JTable object
      */
     JTable search(String title,String rating,String calories,String protein,String fat,String sodium,String price);

     /**
      * @pre clientID>=0
      * @pre orderedProducts!=null
      * @param clientID client ID for adding order
      * @param orderedProducts orders to be added
      * @return add an order to hashSet orders
      */
     void addOrder(int clientID, ArrayList<MenuItem> orderedProducts);

}
