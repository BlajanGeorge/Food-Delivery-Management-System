package PresentationLayer.UserGraphicalInterface;

import BusinessLayer.DeliveryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteProductInterface extends JFrame {

    private final JButton backBtn;
    private final JButton deleteBtn;
    private final JComboBox comboBox;

    public DeleteProductInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        comboBox = new JComboBox(DeliveryService.getItems());
        comboBox.setBounds(10, 74, 270, 21);
        contentPane.add(comboBox);


        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        deleteBtn.setBounds(103, 233, 85, 21);
        contentPane.add(deleteBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(195, 233, 85, 21);
        contentPane.add(backBtn);
    }
    public JButton getBackBtn()
    {
        return this.backBtn;
    }
    public JButton getDeleteBtn()
    {
        return this.deleteBtn;
    }
    public String getCombo()
    {
        return (String) this.comboBox.getSelectedItem();
    }
}
