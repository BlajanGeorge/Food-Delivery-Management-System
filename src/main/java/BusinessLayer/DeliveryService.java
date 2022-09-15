package BusinessLayer;

import DataLayer.FileWriterBill;
import DataLayer.Serializator;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Blajan George-Paul
 * @Date: 14.05.2021
 * @inv:  COMMA == "," //to be sure the COMMA represent the correct char
 *
 */
public class DeliveryService extends Observable implements IDeliveryServiceProcessing {

    private static final String COMMA = ",";
    private static HashSet<MenuItem> menuItems;
    private static HashSet<Order> orders;
    private final FileWriterBill fileWriterBill;

    public DeliveryService() {
        menuItems = new HashSet<>();
        orders = new HashSet<>();
        fileWriterBill = new FileWriterBill();
    }

    public void isWellFormed() {
        int nrAdmin=0;
        for(User i : Model.getUsers())
        {
            if(i.getRole() == Role.ADMINISTRATOR)
                nrAdmin++;
        }
       assert nrAdmin == 1;
    }

    @Override
    public void importBaseProducts(){
        Function<String, BaseProduct> mapToItem = (line) -> {

            String[] p = line.split(COMMA);

            BaseProduct item = new BaseProduct();
            assert p[0]!=null : "Null object";
            item.setTitle(p[0]);
            assert p[1]!=null : "Null object";
            item.setRating(Float.parseFloat(p[1]));
            assert p[2]!=null : "Null object";
            item.setCalories(Integer.parseInt(p[2]));
            assert p[3]!=null : "Null object";
            item.setProtein(Integer.parseInt(p[3]));
            assert p[4]!=null : "Null object";
            item.setFat(Integer.parseInt(p[4]));
            assert p[5]!=null : "Null object";
            item.setSodium(Integer.parseInt(p[5]));
            assert p[6]!=null : "Null object";
            item.setPrice(Integer.parseInt(p[6]));

            return item;
        };

        ArrayList<BaseProduct> input ;
        String inputFilePath = "C:\\Users\\georg\\OneDrive\\Desktop\\sem2\\Tehnici de programare fundamentale\\PT2021_302210_Blajan_George-Paul_Assignment_4\\src\\main\\resources\\products.csv";
        assert inputFilePath!=null : "Null object";
        File inputF = new File(inputFilePath);
        InputStream inputFS = null;
        try {
            inputFS = new FileInputStream(inputF);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        input = (ArrayList<BaseProduct>) br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menuItems.addAll(input);
    }

    @Override
    public void addProduct(MenuItem menuItem) {
        assert menuItem!=null : "Null object";
        menuItems.add(menuItem);
    }

    @Override
    public void deleteProduct(MenuItem menuItem) {
        assert menuItem!=null : "Null object";
        menuItems.remove(menuItem);
    }

    @Override
    public void editProduct(MenuItem oldItem,MenuItem newItem) {
        assert oldItem!=null : "Null object";
        assert newItem!=null : "Null object";
        for(MenuItem i: menuItems)
        {
            if(i.getTitle().equals(oldItem.getTitle()))
            {
                i.setTitle(newItem.getTitle());
                i.setRating(newItem.getRating());
                i.setCalories(newItem.getCalories());
                i.setProtein(newItem.getProtein());
                i.setFat(newItem.getFat());
                i.setSodium(newItem.getSodium());
                i.setPrice(newItem.computePrice());
            }
        }
    }

    @Override
    public JTable showProducts() {
        JTable jTable;
        String[] header = {"Title","Rating","Calories","Protein",
        "Fat","Sodium","Price"};
        Object[][] data = new Object[menuItems.size()][header.length];

        int j=0;
       for(MenuItem i: menuItems)
       {
           data[j][0] = i.getTitle();
           data[j][1] = i.getRating();
           data[j][2] = i.getCalories();
           data[j][3] = i.getProtein();
           data[j][4] = i.getFat();
           data[j][5] = i.getSodium();
           data[j][6] = i.computePrice();

           j++;
       }
       jTable = new JTable(data,header);
       return jTable;
    }

    @Override
    public void reportOne(int startHour,int startMinutes,int endHour,int endMinutes) {
        ArrayList<Order> match = new ArrayList<>();
        Stream<Order> orderStream = orders.stream();

        assert startHour>=0 : "Invalid start Hour";
        assert startMinutes>=0 : "Invalid start minutes";
        assert endHour>=0 : "Invalid end Hour";
        assert  endMinutes>=0 : "Invalid end minutes";


        orderStream.forEach(e->{
            if(e.getOrderDate().getHours()>startHour && e.getOrderDate().getHours()<endHour)
                match.add(e);
            else
            {
                if(e.getOrderDate().getHours() == startHour && e.getOrderDate().getHours()==endHour)
                {
                    if(e.getOrderDate().getMinutes()>=startMinutes && e.getOrderDate().getMinutes()<=endMinutes)
                        match.add(e);
                }
                else
                {
                    if(e.getOrderDate().getHours() == startHour)
                    {
                        if(e.getOrderDate().getMinutes()>=startMinutes)
                            match.add(e);
                    }
                    else
                    if(e.getOrderDate().getHours() == endHour)
                    {
                        if(e.getOrderDate().getMinutes()<=endMinutes)
                            match.add(e);
                    }
                }
            }
        });

        fileWriterBill.makeReportOne(match);
    }

    @Override
    public void reportTwo(int orderedTime) {
        assert orderedTime>=0 : "Invalid orderedTime";
        List<MenuItem> match = menuItems.stream()
                .filter(menuItem -> menuItem.getOrderedTimes()>orderedTime)
                .collect(Collectors.toList());

        fileWriterBill.makeReportTwo((ArrayList<MenuItem>) match);
    }

    @Override
    public void reportThree(int orderedTime, int valueOfOrder) {
        ArrayList<User> match = new ArrayList<>();
        assert orderedTime>=0 : "Invalid orderedTime";
        assert valueOfOrder>=0 : "Invalid valueOfOrder";
        Stream<User> userStream = Model.getUsers().stream();
        userStream.forEach(e->{
            int nr=0;
            for(Order j: orders)
            {
                if(j.getOrderPrice()>valueOfOrder)
                {
                    if(j.getClientID()==e.getID())
                        nr++;
                }
            }
            if(nr>orderedTime)
                match.add(e);
        });
        fileWriterBill.makeReportThree(match);
    }

    @Override
    public void reportFour(int day) {
        ArrayList<MenuItem> match = new ArrayList<>();
        assert  day>=0 : "Invalid day";
        Stream<Order> orderStream = orders.stream();
        orderStream.forEach(e->{
            if(e.getOrderDate().getDay() == day+1)
            {
                match.addAll(e.getOrderedProducts());
            }
        });
        for(MenuItem i: match)
        {
            i.increaseReport4();
        }
        fileWriterBill.makeReportFour(match);
    }

    @Override
    public JTable search(String title,String rating,String calories,String protein,String fat,String sodium,String price) {
        JTable jTable;
        String[] header = {"Title","Rating","Calories","Protein",
                "Fat","Sodium","Price"};
        ArrayList<MenuItem> itemsMatch = new ArrayList<>();

        for(MenuItem i: menuItems)
        {
            if(!title.equals(""))
            {
                if(!i.getTitle().contains(title))
                {
                    continue;
                }
            }
            if(!rating.equals(""))
            {
                if(i.getRating() != Float.parseFloat(rating))
                {
                    continue;
                }
            }
            if(!calories.equals(""))
            {
                if(i.getCalories() != Integer.parseInt(calories))
                {
                    continue;
                }
            }
            if(!protein.equals(""))
            {
                if(i.getProtein() != Integer.parseInt(rating))
                {
                    continue;
                }
            }
            if(!fat.equals(""))
            {
                if(i.getFat() != Integer.parseInt(fat))
                {
                    continue;
                }
            }
            if(!sodium.equals(""))
            {
                if(i.getSodium() != Integer.parseInt(sodium))
                {
                    continue;
                }
            }
            if(!price.equals(""))
            {
                if(i.computePrice() != Integer.parseInt(price))
                {
                    continue;
                }
            }
            itemsMatch.add(i);
        }
        Object[][] data = new Object[itemsMatch.size()][header.length];
        int j=0;
        for(MenuItem i: itemsMatch)
        {
            data[j][0] = i.getTitle();
            data[j][1] = i.getRating();
            data[j][2] = i.getCalories();
            data[j][3] = i.getProtein();
            data[j][4] = i.getFat();
            data[j][5] = i.getSodium();
            data[j][6] = i.computePrice();

            j++;
        }
        jTable = new JTable(data,header);
        return jTable;

    }

    @Override
    public void addOrder(int clientID, ArrayList<MenuItem> orderedProducts) {
        Order order = new Order(clientID,orderedProducts);
        assert  clientID>=0 : "Invalid clientID";
        assert orderedProducts!=null : "Null orderedProducts";
        setClient(order);
        orders.add(order);
        fileWriterBill.makeBill(order);
    }

    public static String[] getItems(){String[] a = new String[menuItems.size()]; int j=0; for(MenuItem i: menuItems){a[j]=i.getTitle(); j++;} return a;}
    public MenuItem findItem(String title){
        for(MenuItem i: menuItems)
        {
            if(i.getTitle().equals(title))
            {
                return i;
            }
        }
        return null;
    }
    public void setClient(Order order)
    {
        String a="";
        a+=order.getOrderID()+", "+order.getClientID()+", ";
        for(MenuItem i: order.getOrderedProducts())
        {
            a+=i.getTitle()+", ";
        }
        a+=order.getOrderPrice();
        setChanged();
        notifyObservers(a);
    }
    public void storeInfo()
    {
        assert orders!=null;
        assert menuItems!=null;;
        Serializator.serialization(orders,menuItems,Model.getUsers());
    }
    public static void loadInfo(HashSet<Order> orderss,HashSet<MenuItem> Items,ArrayList<User> users){
        orders.addAll(orderss);
        menuItems.addAll(Items);
        Model.loadUsers(users);
    }
}
