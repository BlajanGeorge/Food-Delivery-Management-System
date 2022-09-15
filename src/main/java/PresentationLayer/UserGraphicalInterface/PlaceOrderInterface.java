package PresentationLayer.UserGraphicalInterface;

import BusinessLayer.DeliveryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlaceOrderInterface extends JFrame {

    private final JComboBox comboBox;
    private final JButton orderBtn;
    private final JButton putBtn;
    private final JButton backBtn;

  public  PlaceOrderInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 359, 300);
      JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        orderBtn = new JButton("Order");
        orderBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        orderBtn.setBounds(10, 240, 85, 21);
        contentPane.add(orderBtn);

        comboBox = new JComboBox(DeliveryService.getItems());
        comboBox.setBounds(10, 26, 330, 21);
        contentPane.add(comboBox);

        putBtn = new JButton("Put");
        putBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        putBtn.setBounds(133, 240, 85, 21);
        contentPane.add(putBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(255, 240, 85, 21);
        contentPane.add(backBtn);
    }
    public JButton getBackBtn()
    {
        return this.backBtn;
    }
    public JButton getPutBtn()
    {
        return this.putBtn;
    }
    public JButton getOrderBtn()
    {
        return this.orderBtn;
    }
    public String getComboElement()
    {
        return (String) this.comboBox.getSelectedItem();
    }

}
