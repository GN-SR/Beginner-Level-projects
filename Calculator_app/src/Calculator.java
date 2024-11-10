import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decimalButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Sans",Font.BOLD,32);

    double num1=0, num2=0, result=0;
    char operator;


    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,650);
        frame.setLayout(null);



        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
