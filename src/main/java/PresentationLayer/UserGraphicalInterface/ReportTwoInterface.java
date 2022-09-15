package PresentationLayer.UserGraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ReportTwoInterface extends JFrame {

    private final JTextField textField;
    private final JButton btnNewButton;
    private final JButton btnBack;


    public ReportTwoInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 313, 150);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 50, 80, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Generate");
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnNewButton.setBounds(180, 27, 105, 21);
        contentPane.add(btnNewButton);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnBack.setBounds(180, 70, 105, 21);
        contentPane.add(btnBack);
    }
    public JButton getBackButton()
    {
        return this.btnBack;
    }
    public JButton getGenerateButton()
    {
        return this.btnNewButton;
    }
    public String getNumber()
    {
        return this.textField.getText();
    }
    public void clear()
    {
        this.textField.setText("");
    }

}
