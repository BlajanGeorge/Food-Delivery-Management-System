package PresentationLayer.UserGraphicalInterface;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ReportFourInterface extends JFrame {

    private final JButton generateButton;
    private final JButton backButton;
    private final JComboBox comboBox;

    public ReportFourInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 233, 186);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        comboBox = new JComboBox(days);
        comboBox.setBounds(10, 10, 200, 25);
        contentPane.add(comboBox);

        generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        generateButton.setBounds(10, 123, 100, 21);
        contentPane.add(generateButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backButton.setBounds(125, 123, 85, 21);
        contentPane.add(backButton);
    }
    public JButton getBackButton()
    {
        return this.backButton;
    }
    public JButton getGenerateButton()
    {
        return this.generateButton;
    }
    public int getIndexOfComboBox()
    {
        return this.comboBox.getSelectedIndex();
    }

}
