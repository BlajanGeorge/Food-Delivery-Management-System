package PresentationLayer.UserGraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ShowProductsView extends JFrame {

    private final JButton backBtn;


    public ShowProductsView(JTable jTable) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Products");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(200, 10, 90, 20);
        contentPane.add(lblNewLabel);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(390, 432, 85, 21);
        contentPane.add(backBtn);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 470, 350);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(jTable);
    }

    public JButton getBackBtn() {
        return this.backBtn;
    }
}