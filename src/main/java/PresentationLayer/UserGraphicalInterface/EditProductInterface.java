package PresentationLayer.UserGraphicalInterface;

import BusinessLayer.DeliveryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditProductInterface extends JFrame {

    private final JTextField textField;
    private final JTextField textField_1;
    private final JTextField textField_2;
    private final JTextField textField_3;
    private final JTextField textField_4;
    private final JTextField textField_5;
    private final JTextField textField_6;
    private final JButton btnNewButton;
    private final JButton btnBack;
    private JComboBox comboBox;

    public EditProductInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboBox = new JComboBox(DeliveryService.getItems());
        comboBox.setBounds(300, 25, 270, 21);
        contentPane.add(comboBox);

        textField = new JTextField();
        textField.setBounds(65, 22, 100, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(65, 48, 100, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(65, 78, 100, 20);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(65, 108, 100, 20);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(65, 138, 100, 20);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(65, 168, 100, 20);
        contentPane.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(65, 198, 100, 20);
        contentPane.add(textField_6);

        JLabel lblNewLabel_1_1 = new JLabel("Calories:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(10, 81, 60, 15);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Protein:");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(15, 111, 50, 15);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Fat:");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(40, 141, 30, 15);
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Sodium:");
        lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_4.setBounds(15, 171, 50, 15);
        contentPane.add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("Price:");
        lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_5.setBounds(25, 201, 50, 15);
        contentPane.add(lblNewLabel_1_5);

        JLabel lblNewLabel_1 = new JLabel("Rating:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(20, 51, 45, 15);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_6 = new JLabel("Title:");
        lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_6.setBounds(30, 25, 30, 15);
        contentPane.add(lblNewLabel_1_6);

        btnNewButton = new JButton("Edit");
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnNewButton.setBounds(191, 93, 85, 21);
        contentPane.add(btnNewButton);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnBack.setBounds(191, 137, 85, 21);
        contentPane.add(btnBack);
    }
    public JButton getBtnNewButton()
    {
        return this.btnNewButton;
    }
    public JButton getBtnBack()
    {
        return this.btnBack;
    }
    public String getField1()
    {
        return this.textField.getText();
    }
    public String getField2()
    {
        return this.textField_1.getText();
    }
    public String getField3()
    {
        return this.textField_2.getText();
    }
    public String getField4()
    {
        return this.textField_3.getText();
    }
    public String getField5()
    {
        return this.textField_4.getText();
    }
    public String getField6()
    {
        return this.textField_5.getText();

    } public String getField7()
    {
        return this.textField_6.getText();
    }
    public void clear(String a)
    {
        this.textField.setText(a);
        this.textField_1.setText(a);
        this.textField_2.setText(a);
        this.textField_3.setText(a);
        this.textField_4.setText(a);
        this.textField_5.setText(a);
        this.textField_6.setText(a);
    }
    public String getCombo()
    {
        return (String) this.comboBox.getSelectedItem();
    }


}
