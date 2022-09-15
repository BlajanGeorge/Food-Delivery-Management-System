package DataLayer;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Serializator {

    public static void serialization(HashSet<Order> orders, HashSet<MenuItem> menuItems,ArrayList<User> users) {
        String filename1="C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\storage1.txt";
        String filename2="C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\storage2.txt";
        String filename3="C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\storage3.txt";
        String filename4="C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\storage4.txt";

        PrintWriter writer = null;
        //
        try {
            writer = new PrintWriter(filename1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        //
        try {
            writer = new PrintWriter(filename2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();

        try {
            writer = new PrintWriter(filename3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        try {
            writer = new PrintWriter(filename4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        //
        try
        {
            FileOutputStream fos = new FileOutputStream(filename1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(orders);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        try
        {
            FileOutputStream fos = new FileOutputStream(filename2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(menuItems);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        try
        {
            FileOutputStream fos = new FileOutputStream(filename3);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        try
        {
            FileOutputStream fos = new FileOutputStream(filename4);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(User.getContor());
            oos.writeObject(Order.getContor());
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

    }
    public static void deserialization() {
        HashSet<Order> orders;
        HashSet<MenuItem> menuItems;
        ArrayList<User> users;
        int contorUser;
        int contorOrder;

        String filename1 = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\storage1.txt";
        String filename2 = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\storage2.txt";
        String filename3 = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\storage3.txt";
        String filename4="C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\storage4.txt";

        try
        {
            FileInputStream fis = new FileInputStream(filename1);
            ObjectInputStream ois = new ObjectInputStream(fis);

            orders = (HashSet<Order>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        try
        {
            FileInputStream fis = new FileInputStream(filename2);
            ObjectInputStream ois = new ObjectInputStream(fis);

            menuItems = (HashSet<MenuItem>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        try
        {
            FileInputStream fis = new FileInputStream(filename3);
            ObjectInputStream ois = new ObjectInputStream(fis);

            users = (ArrayList<User>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        try
        {
            FileInputStream fis = new FileInputStream(filename4);
            ObjectInputStream ois = new ObjectInputStream(fis);

            contorUser = (int) ois.readObject();
            contorOrder = (int) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        User.setContor(contorUser);
        Order.setContor(contorOrder);
        DeliveryService.loadInfo(orders,menuItems,users);
    }

}
