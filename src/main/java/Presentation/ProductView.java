package Presentation;

import javax.swing.*;
import java.awt.*;

import BLL.ProductBLL;
import Model.Client;
import Model.Product;
import DataAccess.ProductDAO;
public class ProductView {
    private JFrame frame = new JFrame("Products Management");

    private JPanel panel = new JPanel();
    private JTextField textField1 = new JTextField();
    private JTextField textField2 = new JTextField();
    private JTextField textField3 = new JTextField();
    private JTextField textField4 = new JTextField();
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    private JLabel label3 = new JLabel();
    private JLabel label4 = new JLabel();
    private JButton buton1 = new JButton();
    private JButton buton2 = new JButton();
    private JButton buton3 = new JButton();
    private JButton buton4 = new JButton();
    private JTextArea textArea = new JTextArea();
    private JScrollPane scroll = new JScrollPane(textArea);
    private ProductDAO PR;
    private ProductBLL PL = new ProductBLL();
    public ProductView(){
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(940,0);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBackground(new Color(233,116,81));
        panel.setLayout(null);

        textFields();
        labels();
        buttons();
        textAreas(PL.afisareProduse());
        frame.setVisible(true);
        frame.setResizable(false);

        PR = new ProductDAO();
    }

    public void textAreas(String s){
        scroll.setBounds(25,200,530,335);
        textArea.setText(s);
        panel.add(scroll);
    }

    public void textFields(){
        textField1.setBounds(120,40,70,30);
        textField1.setFont(new Font("times new roman", Font.ITALIC,20));
        textField1.setBackground(new Color(211,211,211));
        panel.add(textField1);

        textField2.setBounds(120,80,120,30);
        textField2.setFont(new Font("times new roman", Font.ITALIC,20));
        textField2.setBackground(new Color(211,211,211));
        panel.add(textField2);

        textField3.setBounds(120,120,150,30);
        textField3.setFont(new Font("times new roman", Font.ITALIC,20));
        textField3.setBackground(new Color(211,211,211));
        panel.add(textField3);

        textField4.setBounds(120,160,70,30);
        textField4.setFont(new Font("times new roman", Font.ITALIC,20));
        textField4.setBackground(new Color(211,211,211));
        panel.add(textField4);
    }

    public void labels(){
        label1.setText("ID:");
        label1.setFont(new Font("times new roman", Font.ITALIC,25));
        label1.setBackground(new Color(233,116,81));
        label1.setBounds(25,40,60,30);
        panel.add(label1);

        label2.setText("NAME:");
        label2.setFont(new Font("times new roman", Font.ITALIC,25));
        label2.setBackground(new Color(233,116,81));
        label2.setBounds(25,80,90,30);
        panel.add(label2);

        label3.setText("STOCK:");
        label3.setFont(new Font("times new roman", Font.ITALIC,25));
        label3.setBackground(new Color(233,116,81));
        label3.setBounds(25,120,90,30);
        panel.add(label3);

        label4.setText("PRICE:");
        label4.setFont(new Font("times new roman", Font.ITALIC,25));
        label4.setBackground(new Color(233,116,81));
        label4.setBounds(25,160,90,30);
        panel.add(label4);
    }

    public void buttons(){

        buton2.setText("ADD product");
        buton2.setBounds(320,80,150,25);
        buton2.setFont(new Font("times new roman",Font.ITALIC,20));
        buton2.addActionListener(e -> {
            int id;
            String name;
            int stock;
            int price;
            String aux = textField1.getText();
            id = Integer.parseInt(aux);
            name = textField2.getText();
            aux = textField3.getText();
            stock = Integer.parseInt(aux);
            aux = textField4.getText();
            price = Integer.parseInt(aux);
            Product product = new Product(id,name,stock,price);
            PR.insert(product);
            scriere();
        });
        panel.add(buton2);

        buton3.setText("EDIT product");
        buton3.setBounds(320,120,150,25);
        buton3.setFont(new Font("times new roman",Font.ITALIC,20));
        buton2.addActionListener(e -> {
            int id;
            String name;
            int stock;
            int price;
            String aux = textField1.getText();
            id = Integer.parseInt(aux);
            name = textField2.getText();
            aux = textField3.getText();
            stock = Integer.parseInt(aux);
            aux = textField4.getText();
            price = Integer.parseInt(aux);
            Product product = new Product(id,name,stock,price);
            PR.update(product);
            scriere();
        });
        panel.add(buton3);

        buton4.setText("DELETE product");
        buton4.setBounds(320,160,180,25);
        buton4.setFont(new Font("times new roman",Font.ITALIC,20));
        buton4.addActionListener(e -> {
            int id;
            String name;
            int stock;
            int price;
            String aux = textField1.getText();
            id = Integer.parseInt(aux);
            name = textField2.getText();
            aux = textField3.getText();
            stock = Integer.parseInt(aux);
            aux = textField4.getText();
            price = Integer.parseInt(aux);
            Product product = new Product(id,name,stock,price);
            PR.delete(product);
            scriere();
        });
        panel.add(buton4);
    }

    public void scriere(){
        textArea.setText(PL.afisareProduse());
    }
}
