package PresentationLayer.UserGraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ClientGraphicalUserInterface extends JFrame {

    private final JLabel backLabel;
    private final JButton showButton;
    private final JButton searchButton;
    private final JButton orderButton;

    public ClientGraphicalUserInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        showButton = new JButton("Show Products");
        showButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        showButton.setBounds(70, 130, 150, 21);
        contentPane.add(showButton);

        searchButton = new JButton("Search Products");
        searchButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        searchButton.setBounds(270, 130, 150, 21);
        contentPane.add(searchButton);

        orderButton = new JButton("Place Order");
        orderButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        orderButton.setBounds(470, 130, 150, 21);
        contentPane.add(orderButton);

        ImageIcon clientImage = new ImageIcon(this.getClass().getResource("/CLIENT.png"));
        JLabel clientLabel = new JLabel();
        clientLabel.setIcon(clientImage);
        clientLabel.setBounds(5, 5, 80, 80);
        contentPane.add(clientLabel);

        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/BACK_36.png"));
        backLabel = new JLabel();
        backLabel .setIcon(backImage);
        backLabel .setBounds(640, 320, 36, 36);
        contentPane.add(backLabel);
    }
    public JLabel getBackLabel(){return this.backLabel;}

    public JButton getShowButton()
    {
        return this.showButton;
    }
    public JButton getSearchButton()
    {
        return this.searchButton;
    }
    public JButton getOrderButton()
    {
        return this.orderButton;
    }

}

