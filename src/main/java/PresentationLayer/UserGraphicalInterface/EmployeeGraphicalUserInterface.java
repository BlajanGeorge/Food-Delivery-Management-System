package PresentationLayer.UserGraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class EmployeeGraphicalUserInterface extends JFrame implements Observer {

    private final JLabel backLabel;
    private final JComboBox comboBox;
    private final JLabel ordersLabel;
    private final JButton storeButton;
    private int orders=0;

    public EmployeeGraphicalUserInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon employeeImage = new ImageIcon(this.getClass().getResource("/EMPLOYEE.png"));
        JLabel employeeLabel = new JLabel();
        employeeLabel.setIcon(employeeImage);
        employeeLabel.setBounds(10, 10, 80, 80);
        contentPane.add(employeeLabel);

        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/BACK_36.png"));
        backLabel = new JLabel();
        backLabel .setIcon(backImage);
        backLabel .setBounds(640, 320, 36, 36);
        contentPane.add(backLabel);

        ordersLabel = new JLabel("0");
        ordersLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        ordersLabel.setBounds(168, 29, 10, 15);
        contentPane.add(ordersLabel);

        JLabel ordersLabel2 = new JLabel("orders were placed");
        ordersLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        ordersLabel2.setBounds(180, 28, 120, 15);
        contentPane.add(ordersLabel2);

        storeButton = new JButton("Store info");
        storeButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        storeButton.setBounds(70, 180, 150, 21);
        contentPane.add(storeButton);


        comboBox = new JComboBox<String>();
        comboBox.setBounds(300, 25, 270, 21);
        contentPane.add(comboBox);

    }
    public JLabel getBackLabel(){return this.backLabel;}

    @Override
    public void update(Observable o, Object arg) {
        this.orders++;
        this.ordersLabel.setText(String.valueOf(this.orders));
        comboBox.addItem(arg);
    }

    public JButton getStoreButton()
    {
        return this.storeButton;
    }

}