  // <Copyright liaoqb>  [Copyright 2014.07.28]
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculate extends JFrame {
  private JTextField number1 = new JTextField();
  private JTextField symbol = new JTextField();
  private JTextField number2 = new JTextField();
  private JTextField equal = new JTextField();
  private JTextField result = new JTextField();

  private JButton plus = new JButton("+");
  private JButton minus = new JButton("-");
  private JButton multiple  = new JButton("*");
  private JButton divide = new JButton("/");
  private JButton ok = new JButton("OK");

  public Calculate() {
    this.setLayout(new GridLayout(2, 5, 2, 2));

    number1.setHorizontalAlignment(JTextField.CENTER);
    symbol.setHorizontalAlignment(JTextField.CENTER);
    number2.setHorizontalAlignment(JTextField.CENTER);
    equal.setHorizontalAlignment(JTextField.CENTER);
    result.setHorizontalAlignment(JTextField.CENTER);

    result.setEditable(false);
    symbol.setEditable(false);
    equal.setText("=");
    equal.setEditable(false);

    plus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        symbol.setText("+");
      }
    });

    minus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        symbol.setText("-");
      }
    });

    multiple.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        symbol.setText("*");
      }
    });

    divide.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        symbol.setText("/");
      }
    });

    ok.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String s = symbol.getText();
        double num1 = Double.parseDouble(number1.getText());
        double num2 = Double.parseDouble(number2.getText());

        if (s.equals("+")) {
          result.setText("" + (num1 + num2));
        } else if (s.equals("-")) {
          result.setText("" + (num1 - num2));
        } else if (s.equals("*")) {
          result.setText("" + (num1 * num2));
        } else {
          result.setText("" + (num1 / num2));
        }
      }
    });

    this.add(number1);
    this.add(symbol);
    this.add(number2);
    this.add(equal);
    this.add(result);
    this.add(plus);
    this.add(minus);
    this.add(multiple);
    this.add(divide);
    this.add(ok);
  }

  public static void main(String[] args) {
    Calculate frame = new Calculate();

    frame.setTitle("Easy Calculator");
    frame.setSize(300, 150);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}
