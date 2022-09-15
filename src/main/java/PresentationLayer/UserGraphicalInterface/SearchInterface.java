package PresentationLayer.UserGraphicalInterface;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchInterface extends JFrame {

    private final JTextField textField;
    private final JTextField textField2;
    private final JTextField textField3;
    private final JTextField textField4;
    private final JTextField textField5;
    private final JTextField textField6;
    private final JTextField textField7;
    private final JButton searchBtn;
    private final JButton backBtn;

    public SearchInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 470, 150);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Search:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(10, 30, 45, 13);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(60, 28, 150, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField2 = new JTextField();
        textField2.setBounds(220, 28, 30, 20);
        contentPane.add(textField2);
        textField2.setColumns(10);

        textField3 = new JTextField();
        textField3.setBounds(260, 28, 30, 20);
        contentPane.add(textField3);
        textField3.setColumns(10);

        textField4 = new JTextField();
        textField4.setBounds(300, 28, 30, 20);
        contentPane.add(textField4);
        textField4.setColumns(10);

        textField5 = new JTextField();
        textField5.setBounds(340, 28, 30, 20);
        contentPane.add(textField5);
        textField5.setColumns(10);

        textField6 = new JTextField();
        textField6.setBounds(380, 28, 30, 20);
        contentPane.add(textField6);
        textField6.setColumns(10);

        textField7 = new JTextField();
        textField7.setBounds(420, 28, 30, 20);
        contentPane.add(textField7);
        textField7.setColumns(10);

        searchBtn = new JButton("Search");
        searchBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        searchBtn.setBounds(200, 65, 85, 21);
        contentPane.add(searchBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(365, 85, 85, 21);
        contentPane.add(backBtn);
    }
    public JButton getBackBtn()
    {
        return this.backBtn;
    }
    public JButton getSearchBtn()
    {
        return this.searchBtn;
    }
    public String getTitle()
    {
        return this.textField.getText();
    }
    public String getRating()
    {
        return this.textField2.getText();
    }
    public String getCalories()
    {
        return this.textField3.getText();
    }
    public String getProtein()
    {
        return this.textField4.getText();
    }
    public String getFat()
    {
        return this.textField5.getText();
    }
    public String getSodium()
    {
        return this.textField6.getText();
    }
    public String getPrice()
    {
        return this.textField7.getText();
    }
    public void clear()
    {
        this.textField.setText("");
        this.textField2.setText("");
        this.textField3.setText("");
        this.textField4.setText("");
        this.textField5.setText("");
        this.textField6.setText("");
        this.textField7.setText("");
    }

}
