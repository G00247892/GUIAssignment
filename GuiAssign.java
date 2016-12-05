import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.io.File;

public class GuiAssign extends JFrame {
    
    private JButton clearField;
  
    private JButton calculateFields;

    //setup buttons for calculator
    private JButton nineButton  = new JButton("9");
    private JButton eightButton = new JButton("8");
    private JButton sevenButton = new JButton("7");
    private JButton sixButton   = new JButton("6");
    private JButton fiveButton  = new JButton("5");
    private JButton fourButton  = new JButton("4");
    private JButton threeButton = new JButton("3");
    private JButton twoButton   = new JButton("2");
    private JButton oneButton   = new JButton("1");
    private JButton zeroButton  = new JButton("0");
    
    private JButton clearButton    = new JButton("C");
    private JButton posnegButton   = new JButton("-/+");
    private JButton divideButton   = new JButton("/");
    private JButton timesButton    = new JButton("*");
    private JButton subtractButton = new JButton("-");
    private JButton addButton      = new JButton("+");
    private JButton decimalButton  = new JButton(".");
    private JButton equalsButton   = new JButton("=");
    
    private JPanel mainPane;
    private JScrollPane scrollBar;

    int count = 0;
   
    public static void main(String[] args) {
        new GuiAssign().setVisible(true);
    }

    public GuiAssign() {

        JFrame frame = new JFrame("Gui Assignment");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set the position of the text, relative to the icon:
    	JLabel label1 = new JLabel("Enter Principal, Rate (as decimal e.g 0.1 for 10%) and Time. Numbers greater than 1 will be converted to decimal");
        JLabel label2 = new JLabel("Enter Principal");
        JLabel label3 = new JLabel("Enter Rate");
        JLabel label4 = new JLabel("Enter Time");
        JLabel label5 = new JLabel("Simple Interest");
        
        JTextField principal = new JTextField("");
        JTextField rate = new JTextField("");
        JTextField time= new JTextField("");
        JTextField interest = new JTextField("");
        
        setSize(640, 480);

        mainPane = new JPanel();
        mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPane);
        mainPane.setLayout(null);
    
        //Create buttons
        //clear fields button
        clearField = new JButton("Clear");
        clearField.setBounds(150, 300, 124, 30);
        
        //set up labels
        label1.setBounds(150, 20, 500, 30);
        label2.setBounds(150, 70, 500, 30);
        label3.setBounds(150, 130, 500, 30);
        label4.setBounds(150, 180, 500, 30);
        label5.setBounds(150, 230, 500, 30);
        
        principal.setBounds(350, 70, 250, 30);
        rate.setBounds(350, 130, 250, 30);
        time.setBounds(350, 180, 250, 30);
        
        interest.setForeground (Color.red);
        interest.setBounds(350, 230, 250, 30);
        
        //Calculate button
        calculateFields = new JButton("Calculate");
        calculateFields.setBounds(350, 300, 124, 30);
       
        clearField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                principal.setText("");
                rate.setText("");
                time.setText("");
                interest.setText("");
                calculateFields.setEnabled(true);
            }
        });   

        calculateFields.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String princTemp = principal.getText();
                String rateTemp = rate.getText();
                String timeTemp = time.getText();
                int length = rateTemp.length();
                int tempNum = (length*10)/length;
                if(Float.valueOf(rateTemp) - Math.floor(Float.valueOf(rateTemp)) == 0 && rateTemp!="1")
                    interest.setText ( interest.getText() + (Float.valueOf(princTemp)* (Float.valueOf(rateTemp)/tempNum) * Float.valueOf(timeTemp)));
                else 
                    interest.setText ( interest.getText() + (Float.valueOf(princTemp)* (Float.valueOf(rateTemp)) * Float.valueOf(timeTemp)));
                	                
                calculateFields.setEnabled(false);
                System.out.println(tempNum+"  "+ length);
            }
        });
        //Make interest un editatable
        interest.setEditable(false);
        
        //Add things to pane
        mainPane.add(clearField);
      
        mainPane.add(label1);
        mainPane.add(label2);
        mainPane.add(label3);
        mainPane.add(label4);
        mainPane.add(label5);
        
        mainPane.add(principal);
        mainPane.add(rate);
        mainPane.add(time);
        mainPane.add(interest);

        mainPane.add(calculateFields);	
    }
}
