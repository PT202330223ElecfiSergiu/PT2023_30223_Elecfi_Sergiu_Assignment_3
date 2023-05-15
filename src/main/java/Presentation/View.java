package Presentation;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame = new JFrame("Orders Management");
    private JPanel panel = new JPanel();
    private JCheckBox checkBox1 = new JCheckBox("Clients");
    private JCheckBox checkBox2 = new JCheckBox("Products");
    private JCheckBox checkBox3 = new JCheckBox("Orders");
    private JLabel titlu = new JLabel();
    private JLabel nume = new JLabel();
    private JLabel grupa = new JLabel();
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    private JButton exit = new JButton();
    private JButton next = new JButton();

    public View(){
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBackground(new Color(233,116,81));
        panel.setLayout(null);

        labels();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void labels(){
        nume.setText("Elecfi Sergiu-Andrei");
        nume.setBounds(300,390,180,30);
        nume.setFont(new Font("Times new roman", Font.ITALIC,20));
        panel.add(nume);

        grupa.setText("Grupa:30223");
        grupa.setBounds(330,420,130,30);
        grupa.setFont(new Font("times new roman", Font.ITALIC,20));
        panel.add(grupa);
    }

    public void checkBoxes(){

    }
}
