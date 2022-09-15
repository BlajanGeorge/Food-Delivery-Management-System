package PresentationLayer.UserGraphicalInterface;


import BusinessLayer.DeliveryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CompositeProductAddInterface extends JFrame {

    private final JTextField textField;
    private final JButton backBtn;
    private final JButton addBtn;
    private final JButton putBtn;
    private final JComboBox comboBox;

    public CompositeProductAddInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Title:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(65, 32, 45, 15);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(100, 29, 130, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        comboBox = new JComboBox(DeliveryService.getItems());
        comboBox.setBounds(10, 74, 270, 21);
        contentPane.add(comboBox);

        putBtn = new JButton("Put");
        putBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        putBtn.setBounds(10, 233, 85, 21);
        contentPane.add(putBtn);

        addBtn = new JButton("Add");
        addBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addBtn.setBounds(103, 233, 85, 21);
        contentPane.add(addBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(195, 233, 85, 21);
        contentPane.add(backBtn);
    }
    public JButton getBackBtn()
    {
        return this.backBtn;
    }
    public  JButton getAddBtn()
    {
        return this.addBtn;
    }
    public JButton getPutBtn()
    {
        return this.putBtn;
    }
    public String getTitle()
    {
        return this.textField.getText();
    }
    public void setField(String a)
    {
        this.textField.setText(a);
    }
    public String getCombo()
    {
        return (String) this.comboBox.getSelectedItem();
    }

}
