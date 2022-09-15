package PresentationLayer.UserGraphicalInterface;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdministratorGraphicalUserInterface extends JFrame {

    private final JLabel backLabel;
    private final JButton importButton;
    private final JButton addButton;
    private final JButton deleteButton;
    private final JButton editButton;
    private final JButton showButton;
    private final JButton reportOne;
    private final JButton reportTwo;
    private final JButton reportThree;
    private final JButton reportFour;


    public AdministratorGraphicalUserInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon adminImage = new ImageIcon(this.getClass().getResource("/ADMINISTRATOR.png"));
        JLabel adminLabel = new JLabel();
        adminLabel.setIcon(adminImage);
        adminLabel.setBounds(10, 10, 80, 80);
        contentPane.add(adminLabel);

        importButton = new JButton("Import Products");
        importButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        importButton.setBounds(70, 130, 150, 21);
        contentPane.add(importButton);

        addButton = new JButton("Add Products");
        addButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addButton.setBounds(270, 130, 150, 21);
        contentPane.add(addButton);

        deleteButton = new JButton("Delete Products");
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        deleteButton.setBounds(470, 130, 150, 21);
        contentPane.add(deleteButton);

       editButton = new JButton("Edit Products");
        editButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        editButton.setBounds(70, 180, 150, 21);
        contentPane.add(editButton);

        showButton = new JButton("Show Products");
        showButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        showButton.setBounds(270, 180, 150, 21);
        contentPane.add(showButton);

        reportOne = new JButton("Report 1");
        reportOne.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        reportOne.setBounds(470, 180, 150, 21);
        contentPane.add(reportOne);

        reportTwo = new JButton("Report 2");
        reportTwo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        reportTwo.setBounds(70, 230, 150, 21);
        contentPane.add(reportTwo);

        reportThree = new JButton("Report 3");
        reportThree.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        reportThree.setBounds(270, 230, 150, 21);
        contentPane.add(reportThree);

        reportFour = new JButton("Report 4");
        reportFour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        reportFour.setBounds(470, 230, 150, 21);
        contentPane.add(reportFour);


        ImageIcon backImage = new ImageIcon(this.getClass().getResource("/BACK_36.png"));
        backLabel = new JLabel();
        backLabel .setIcon(backImage);
        backLabel .setBounds(640, 320, 36, 36);
        contentPane.add(backLabel);

    }
    public JLabel getBackLabel(){return this.backLabel;}

    public JButton getImportButton()
    {
        return this.importButton;
    }
    public JButton getAddButton()
    {
        return this.addButton;
    }
    public JButton getDeleteButton()
    {
        return this.deleteButton;
    }
    public JButton getEditButton()
    {
        return this.editButton;
    }
    public JButton getShowButton()
    {
        return this.showButton;
    }
    public JButton getReportOne()
    {
        return reportOne;
    }
    public JButton getReportTwo()
    {
        return reportTwo;
    }
    public JButton getReportThree()
    {
        return reportThree;
    }
    public JButton getReportFour()
    {
        return reportFour;
    }



}