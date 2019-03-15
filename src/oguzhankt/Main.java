package oguzhankt;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    JPanel mainPanel;
    JFrame theFrame;
    ArrayList<JButton> buttonList;
    ArrayList<ActionListener> listenerList;
    JLabel text;
    JPanel background;

    String textFieldString = "";
    Double firstNumber = 0.0;
    Double secondNumber = 0.0;
    String operation = null;

    String[] buttonName = {"1", "2", "3", "/", "4", "5", "6", "X" , "7", "8", "9", "-", ".", "0", "=", "+"};

    public static void main(String[] args) {
	    Main program = new Main();
	    program.buildGui();
    }

    public void buildGui(){
        theFrame = new JFrame("Calculator");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setBounds(50,50,600,800);

        background = new JPanel(new BorderLayout());
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        addButtons();

        text = new JLabel(" ");
        background.add(BorderLayout.NORTH, text);

        theFrame.getContentPane().add(background);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void addButtons(){

        buttonList = new ArrayList<JButton>();
        GridLayout grid = new GridLayout(4,4);
        grid.setHgap(1);
        grid.setVgap(1);
        mainPanel = new JPanel(grid);

        for(int i=0; i<16; i++){
            JButton b = new JButton(buttonName[i]);
            buttonList.add(b);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if((b.getText().equals("/")) || (b.getText().equals("X")) || (b.getText().equals("-")) || (b.getText().equals("+"))){
                        firstNumber = Double.parseDouble(textFieldString);
                        textFieldString = " ";
                        text.setText(textFieldString);
                        operation = b.getText();
                    }else if(b.getText().equals("=")){
                        secondNumber = Double.parseDouble(textFieldString);
                        textFieldString = Calculator.operate(firstNumber, secondNumber, operation);
                        text.setText(textFieldString);
                    }else{
                        textFieldString = textFieldString + b.getText();
                        text.setText(textFieldString);
                    }

                }
            });
            mainPanel.add(b);
        }

        background.add(BorderLayout.SOUTH, mainPanel);

        JPanel buttonPanel = new JPanel();
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldString = " ";
                text.setText(textFieldString);
                firstNumber = 0.0;
            }
        });

        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldString = textFieldString.substring(0,textFieldString.length()-1);
                text.setText(textFieldString);
            }
        });
        background.add(BorderLayout.CENTER, buttonPanel);


    }

}
