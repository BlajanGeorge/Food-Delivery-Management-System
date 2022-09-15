package PresentationLayer.UserGraphicalInterface;


import BusinessLayer.Role;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;

public class CreateAccountInterface extends JFrame {

    private final JTextField field1;
    private final JPasswordField field2;
    private final JComboBox comboBox;
    private final JLabel backLabel;
    private final JLabel loginLabel;

    public CreateAccountInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 353, 381);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon userImage = new ImageIcon(this.getClass().getResource("/USER_ADD_80.png"));
        JLabel userLabel = new JLabel();
        userLabel.setIcon(userImage);
        userLabel.setBounds(130, 10, 80, 80);
        contentPane.add(userLabel);


        field1 = new JTextField();
        field1.setBounds(114, 153, 150, 20);
        contentPane.add(field1);
        field1.setColumns(10);

        field2 = new JPasswordField();
        field2.setBounds(114, 196, 150, 20);
        contentPane.add(field2);
        field2.setColumns(10);

        JLabel label3 = new JLabel("Sign Up");
        label3.setForeground(Color.BLUE);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        label3.setBounds(125, 90, 85, 30);
        contentPane.add(label3);

        ImageIcon usernameImage = new ImageIcon(this.getClass().getResource("/USERNAME.png"));
        JLabel usernameLabel = new JLabel();
        usernameLabel.setIcon(usernameImage);
        usernameLabel.setBounds(80, 150, 24, 24);
        contentPane.add(usernameLabel);


        ImageIcon passwordImage = new ImageIcon(this.getClass().getResource("/PASSWORD.png"));
        JLabel passwordLabel = new JLabel();
        passwordLabel.setIcon(passwordImage);
        passwordLabel.setBounds(80, 192, 24, 24);
        contentPane.add(passwordLabel);

        ImageIcon roleChangeImage = new ImageIcon(this.getClass().getResource("/ROLE.png"));
        JLabel roleChangeLabel = new JLabel();
        roleChangeLabel.setIcon(roleChangeImage);
        roleChangeLabel.setBounds(80, 232, 24, 24);
        contentPane.add(roleChangeLabel);

        Role[] roles = {Role.CLIENT, Role.EMPLOYEE};
        comboBox = new JComboBox(roles);
        comboBox.setBounds(114, 236, 150, 20);
        contentPane.add(comboBox);

        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/BACK_36.png"));
        backLabel = new JLabel();
        backLabel .setIcon(backImage);
        backLabel .setBounds(295, 300, 36, 36);
        contentPane.add(backLabel);

        ImageIcon loginImage = new ImageIcon(this.getClass().getResource("/LOGIN.png"));
        loginLabel = new JLabel();
        loginLabel.setIcon(loginImage);
        loginLabel.setBounds(155, 270, 48, 48);
        contentPane.add(loginLabel);
    }
    public JLabel getLoginLabel(){return this.loginLabel;}
    public JLabel getBackLabel(){return this.backLabel;}
    public Role getRole()
    {
        return (Role) this.comboBox.getSelectedItem();
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
