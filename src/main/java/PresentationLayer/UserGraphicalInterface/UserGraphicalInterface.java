package PresentationLayer.UserGraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserGraphicalInterface extends JFrame {

    private final JTextField field1;
    private final JPasswordField field2;
    private final JLabel createAccount;
    private final JLabel loginLabel;

    public UserGraphicalInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 353, 381);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon userImage = new ImageIcon(this.getClass().getResource("/USER.png"));
        JLabel userLabel = new JLabel();
        userLabel.setIcon(userImage);
        userLabel.setBounds(130, 10, 80, 80);
        contentPane.add(userLabel);

        ImageIcon loginImage = new ImageIcon(this.getClass().getResource("/LOGIN.png"));
        loginLabel = new JLabel();
        loginLabel.setIcon(loginImage);
        loginLabel.setBounds(235, 260, 48, 48);
        contentPane.add(loginLabel);

        ImageIcon usernameImage = new ImageIcon(this.getClass().getResource("/USERNAME.png"));
        JLabel usernameLabel = new JLabel();
        usernameLabel.setIcon(usernameImage);
        usernameLabel.setBounds(80, 123, 80, 80);
        contentPane.add(usernameLabel);


        ImageIcon passwordImage = new ImageIcon(this.getClass().getResource("/PASSWORD.png"));
        JLabel passwordLabel = new JLabel();
        passwordLabel.setIcon(passwordImage);
        passwordLabel.setBounds(80, 192, 24, 24);
        contentPane.add(passwordLabel);


        ImageIcon createAccountImage = new ImageIcon(this.getClass().getResource("/USER_ADD.png"));
        createAccount = new JLabel();
        createAccount.setIcon(createAccountImage);
        createAccount.setBounds(80, 260, 48, 48);
        contentPane.add(createAccount);


        field1 = new JTextField();
        field1.setBounds(114, 153, 150, 20);
        contentPane.add(field1);
        field1.setColumns(10);

        field2 = new JPasswordField();
        field2.setBounds(114, 196, 150, 20);
        contentPane.add(field2);
        field2.setColumns(10);

        JLabel label3 = new JLabel("Sign In");
        label3.setForeground(Color.BLUE);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        label3.setBounds(132, 90, 80, 30);
        contentPane.add(label3);

    }

    public JLabel getLoginLabel() { return this.loginLabel;}
    public JLabel getCreateAccount()
    {
        return this.createAccount;
    }
    public String getUsername()
    {
        return this.field1.getText();
    }
    public String getPassword()
    {
        return this.field2.getText();
    }
    public void setField(String a){ field1.setText(a); field2.setText(a);}

}


