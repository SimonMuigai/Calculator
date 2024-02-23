import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numbeButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,eqButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myFont = new Font("ARIAL",Font.BOLD,30);

    double num1= 0, num2= 0, result= 0;
    char operator;
    
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 450);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = eqButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;


        for(int i = 0; i < 9; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(true);
        }

        for(int i = 0; i < 10; i++){
            numbeButtons[i] = new JButton(String.valueOf(i));
            numbeButtons[i].setFont(myFont);
            numbeButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.gray);

        panel.add(numbeButtons[1]);
        panel.add(numbeButtons[2]);
        panel.add(numbeButtons[3]);
        panel.add(addButton);
        panel.add(numbeButtons[4]);
        panel.add(numbeButtons[5]);
        panel.add(numbeButtons[6]);
        panel.add(subButton);
        panel.add(numbeButtons[7]);
        panel.add(numbeButtons[8]);
        panel.add(numbeButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbeButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e){

        for(int i=0; i<10; i++){
            if(e.getSource() == numbeButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        

            if(e.getSource() == decButton){
                textField.setText(textField.getText().concat("."));
            }
            if(e.getSource() == addButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText(" ");
            }
            if(e.getSource() == subButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText(" ");
            }
            
       
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText(" ");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText(" ");
        }
        if(e.getSource() == eqButton){
            num2 = Double.parseDouble(textField.getText());
        
            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
        
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        

        if(e.getSource() == clrButton){
            textField.setText("");
            
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i<string.length()-1;i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
            
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp = -1 * temp;
            textField.setText(String.valueOf(temp));   
          }
    }
}
