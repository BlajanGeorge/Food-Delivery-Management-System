package DataLayer;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class FileWriterBill {

    public void makeBill(Order order)
    {
        String filename = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\"+"Bill"+"_"+order.getOrderID()+".txt";
        new File(filename);
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.write("Bill"+"\n");
            myWriter.write("Order ID:"+" "+order.getOrderID()+"\n");
            myWriter.write("Client ID: "+" "+order.getClientID()+"\n");
            myWriter.write("Products: "+"\n");
            ArrayList<MenuItem> menuItems = order.getOrderedProducts();
            for(MenuItem i: menuItems)
            {
                myWriter.write(i.getTitle()+"\n");
            }
            myWriter.write("Price: "+order.getOrderPrice()+"\n");
            myWriter.write("Date: "+order.getOrderDate());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeReportOne(ArrayList<Order> orders)
    {
        String filename = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\Report1.txt";
        new File(filename);
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.write("Report \n");
            myWriter.write("This report contains orders made between the given hours.\n");
            for(Order i: orders)
            {
                myWriter.write("Order ID: "+i.getOrderID() + " Client ID "+i.getClientID()+" Products: ");
                for(MenuItem j: i.getOrderedProducts())
                {
                    myWriter.write(j.getTitle()+" ");
                }
                myWriter.write("Price: "+i.getOrderPrice()+" Date: "+i.getOrderDate()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void makeReportTwo(ArrayList<MenuItem> match)
    {
        String filename = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\Report2.txt";
        new File(filename);
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            myWriter.write("Report \n");
            myWriter.write("This report contains the products ordered by a higher number times then given number.\n");
            myWriter.write("Products: \n");
            for(MenuItem i : match)
            {
                myWriter.write(i.getTitle()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void makeReportThree(ArrayList<User> users)
    {
        String filename = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\Report3.txt";
        new File(filename);
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.write("Report \n");
            myWriter.write("This report contains customers who have ordered more than the specified value.\n");
            myWriter.write("Clients: \n");
            for(User i: users)
            {
                myWriter.write(i.toString()+" "+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void makeReportFour(ArrayList<MenuItem> menuItems)
    {
        String filename = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\Report4.txt";
        new File(filename);
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedHashSet<MenuItem> hashSet = new LinkedHashSet<>(menuItems);

        ArrayList<MenuItem> listWithoutDuplicates = new ArrayList<>(hashSet);

        try {
            myWriter.write("Report \n");
            myWriter.write("This report contains the products ordered on the given day and the number of dates on which they were ordered.\n");
            myWriter.write("Products: \n");
            for(MenuItem i: listWithoutDuplicates)
            {
                myWriter.write(i.getTitle()+" "+"Ordered: "+i.getReport4()+" times "+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
