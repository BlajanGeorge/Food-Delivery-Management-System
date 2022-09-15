package PresentationLayer.UserGraphicalInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class TypeInterface extends JFrame {

    private final JButton baseProductBtn;
    private final JButton compositeProductBtn;
    private final JButton backBtn;

    public TypeInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 180, 250);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        baseProductBtn = new JButton("Base Product");
        baseProductBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        baseProductBtn.setBounds(10, 49, 150, 25);
        contentPane.add(baseProductBtn);

        compositeProductBtn = new JButton("Composite Product");
        compositeProductBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        compositeProductBtn.setBounds(10, 95, 150, 25);
        contentPane.add(compositeProductBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(10, 143, 150, 25);
        contentPane.add(backBtn);
    }
    public JButton getBackBtn()
    {
        return this.backBtn;
    }
    public JButton getBaseProductBtn()
    {
        return this.baseProductBtn;
    }
    public JButton getCompositeProductBtn()
    {
        return this.compositeProductBtn;
    }
}