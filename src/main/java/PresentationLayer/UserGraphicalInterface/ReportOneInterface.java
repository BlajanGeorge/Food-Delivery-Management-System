package PresentationLayer.UserGraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ReportOneInterface extends JFrame {

    private final JTextField textField;
    private final JTextField textField_1;
    private final JTextField textField_2;
    private final JTextField textField_3;
    private final JButton btnNewButton;
    private final JButton btnBack;


    public ReportOneInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 313, 150);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Start hour:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(7, 29, 65, 15);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(73, 27, 45, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel(":");
        lblNewLabel_1.setBounds(118, 30, 5, 15);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(123, 27, 45, 20);
        contentPane.add(textField_1);

        JLabel lblEndHour = new JLabel("End hour:");
        lblEndHour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblEndHour.setBounds(12, 72, 65, 15);
        contentPane.add(lblEndHour);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(73, 70, 45, 20);
        contentPane.add(textField_2);

        JLabel lblNewLabel_1_1 = new JLabel(":");
        lblNewLabel_1_1.setBounds(118, 73, 5, 15);
        contentPane.add(lblNewLabel_1_1);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(123, 70, 45, 20);
        contentPane.add(textField_3);

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
    public String getStartHour()
    {
        return this.textField.getText();
    }
    public String getStartMinutes()
    {
        return this.textField_1.getText();
    }
    public String getEndHour()
    {
        return this.textField_2.getText();
    }
    public String getEndMinutes()
    {
        return this.textField_3.getText();
    }
    public void clear()
    {
        this.textField.setText("");
        this.textField_1.setText("");
        this.textField_2.setText("");
        this.textField_3.setText("");
    }

}

