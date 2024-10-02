import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CashRegister implements ActionListener {

    
    JFrame frame;
    JTextArea receipt;
    JButton kaffeButton;
    JButton nalleButton;
    JButton muggButton;
    JButton chipsButton;
    JButton vaniljYoghurtButton;
    JButton daimButton;
    JTextArea inputProductName;
    JTextArea inputCount;
    JButton addToReceiptButton;
    JButton payButton;

    //String selectedProductName; // Håller reda på vald produkt
    //double selectedProductPrice; //Håller reda på priset på den valda produkten
    //double totalSum = 0; //Håller koll på den totala summan


    public CashRegister(){
        frame = new JFrame("IOT24 POS");


        createReceiptArea();
        createQuickButtonsArea();
        createAddArea();

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(1000,800); 

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
    
        frame.setVisible(true);        
            

    }

    private void createAddArea(){
        inputProductName = new JTextArea();
        inputProductName.setBounds(20,650,300,30);
        inputProductName.setFont(new Font("Arial Black", Font.BOLD, 18));
        frame.add(inputProductName);

        JLabel label = new JLabel("Antal");
        label.setBounds(340,625,300,30);
        label.setForeground(Color.WHITE);
        frame.add(label);

        inputCount = new JTextArea();
        inputCount.setBounds(330,650,50,30);
        inputCount.setFont(new Font("Arial Black", Font.BOLD, 18));
        frame.add(inputCount);


        addToReceiptButton = new JButton("Add");
        addToReceiptButton.setBounds(400,640,70,50);
        addToReceiptButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
        frame.add(addToReceiptButton);


        payButton = new JButton("Pay");
        payButton.setBounds(480,640,70,50);
        payButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
        frame.add(payButton);


    }

    private void createQuickButtonsArea() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setBackground(Color.green);
        panel.setPreferredSize(new Dimension(600, 600));

        kaffeButton = new JButton("Kaffe");
        kaffeButton.addActionListener(this);  //Lade till ....?
        panel.add(kaffeButton);

        nalleButton = new JButton("Nalle");
        panel.add(nalleButton);

        muggButton = new JButton("Mugg");
        panel.add(muggButton);

        chipsButton = new JButton("Chips");
        panel.add(chipsButton);

        vaniljYoghurtButton = new JButton("Yoghurt");
        panel.add(vaniljYoghurtButton);
        

        daimButton = new JButton("Daim");
        panel.add(daimButton);




        panel.setBounds(0, 0, 600, 600);

        frame.add(panel);
    }

    private void createReceiptArea() {
        receipt = new JTextArea();
        receipt.setSize(400,400); 
        receipt.setLineWrap(true);
        receipt.setEditable(false);
        receipt.setVisible(true);
        receipt.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane (receipt);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(600, 0, 400, 1000);

        frame.add(scroll);    
    }

    public void run(){
        receipt.append("                     STEFANS SUPERSHOP\n");
        receipt.append("----------------------------------------------------\n");
        receipt.append("\n");
        receipt.append("Kvittonummer:        Datum: 2024-09-01 13:00:21\n");
        receipt.append("----------------------------------------------------\n");
        receipt.append("  \n");
        receipt.append("   \n");  
        receipt.append("Total:             \n");  //Lagt till totalsumma som räknar ihop allt
        receipt.append("                               \n");
        receipt.append("TACK FÖR DITT KÖP\n");

    }            

    @Override
    public void actionPerformed(ActionEvent e) { //Lade till allt detta.Så att knapparna har en funktion
        if (e.getSource() == kaffeButton) {
            receipt.append("Kaffe\n");       //Vet inte om jag behöver det här????????
        } 
        else if (e.getSource() == nalleButton) {
            receipt.append("Nalle\n");
        } 
        else if (e.getSource() == muggButton) {
            receipt.append("Mugg\n");
        }
        else if (e.getSource() == chipsButton) {
            receipt.append("Chips");
        }
        else if (e.getSource() == vaniljYoghurtButton) {
            receipt.append("Yoghurt");
        }
        else if (e.getSource() == daimButton) {
            receipt.append("Daim");
        }
    }

    
} 
