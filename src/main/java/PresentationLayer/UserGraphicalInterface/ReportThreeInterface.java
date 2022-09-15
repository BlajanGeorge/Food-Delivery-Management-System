package PresentationLayer.UserGraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ReportThreeInterface extends JFrame {

    private final JTextField textField;
    private final JTextField textField_1;
    private final JButton btnNewButton;
    private final JButton btnBack;


    public ReportThreeInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 313, 150);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Orders:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(70, 29, 65, 15);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(123, 27, 45, 20);
        contentPane.add(textField);
        textField.setColumns(10);


        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(123, 70, 45, 20);
        contentPane.add(textField_1);

        JLabel lblEndHour = new JLabel("Value per Order:");
        lblEndHour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblEndHour.setBounds(16, 72, 100, 15);
        contentPane.add(lblEndHour);


        btnNewButton = new JButton("Generate");
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnNewButton.setBounds(180, 27, 105, 21);
        contentPane.add(btnNewButton);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnBack.setBounds(180, 70, 105, 21);
        contentPane.add(btnBack);
    }
    public JButton getBackBtn()
    {
        return this.btnBack;
    }
    public JButton getGenerateBtn()
    {
        return this.btnNewButton;
    }
    public String getNumberOfOrders()
    {
        return this.textField.getText();
    }
    public String getValuerPerOrder()
    {
        return this.textField_1.getText();
    }
    public void clear()
    {
        this.textField.setText("");
        this.textField_1.setText("");
    }

}


