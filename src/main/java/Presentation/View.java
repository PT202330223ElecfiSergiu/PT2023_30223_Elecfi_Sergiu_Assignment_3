package Presentation;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame = new JFrame("Orders Management");
    private JPanel panel = new JPanel();
    private JCheckBox checkBox1 = new JCheckBox("Clients");
    private JCheckBox checkBox2 = new JCheckBox("Products");
    private JCheckBox checkBox3 = new JCheckBox("Make Order");
    private ButtonGroup checkBoxGroup = new ButtonGroup();
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
        checkBoxes();
        buttons();
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

        titlu.setText("Orders Management");
        titlu.setBounds(100,30,300,40);
        titlu.setFont(new Font("times new roman", Font.ITALIC,35));
        panel.add(titlu);
    }

    public void checkBoxes(){
        checkBox1.setFont(new Font("times new roman", Font.ITALIC,20));
        checkBox1.setBounds(30,170,150,20);
        checkBox1.setBackground(new Color(233,116,81));
        checkBoxGroup.add(checkBox1);
        panel.add(checkBox1);

        checkBox2.setFont(new Font("times new roman", Font.ITALIC,20));
        checkBox2.setBounds(30,200,150,20);
        checkBox2.setBackground(new Color(233,116,81));
        checkBoxGroup.add(checkBox2);
        panel.add(checkBox2);

        checkBox3.setFont(new Font("times new roman", Font.ITALIC,20));
        checkBox3.setBounds(30,230,150,20);
        checkBox3.setBackground(new Color(233,116,81));
        checkBoxGroup.add(checkBox3);
        panel.add(checkBox3);
    }

    public void buttons(){
        exit.setText("EXIT");
        exit.setBounds(30,420,80,25);
        exit.setFont(new Font("times new roman", Font.ITALIC,20));
        exit.addActionListener(e ->{
            System.exit(0);
        });
        panel.add(exit);

        next.setText("Continue");
        next.setBounds(30,260,120,25);
        next.setFont(new Font("times new roman", Font.ITALIC,20));
        next.addActionListener(e -> {
            if(checkBox1.isSelected()){
                frame.dispose();
                new ClientView();
            }
            if(checkBox2.isSelected()){
                frame.dispose();
                new ProductView();
            }
        });
        panel.add(next);
    }
}
