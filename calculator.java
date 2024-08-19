import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class simple_calculator extends JFrame {
	private JTextField inputfield;
	private JButton[] numberbuttons;
	private JButton add_button,sub_button,mul_button,div_button,clr_button,eq_button;
	private JPanel p;
	private double num1=0,num2=0;
	private char op=' ';
	public simple_calculator()
	{
		JFrame f=new JFrame("Simple Calculator");
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        inputfield=new JTextField();
        f.add(inputfield,BorderLayout.NORTH);
        p=new JPanel();
        p.setLayout(new GridLayout(4,4,10,10));
        numberbuttons=new JButton[10];
        for(int i=0;i<10;i++)
        {
        	numberbuttons[i]=new JButton(String.valueOf(i));
        	numberbuttons[i].addActionListener(new numberbuttonlistener());
            p.add(numberbuttons[i]);
        }
        add_button=new JButton("+");
        sub_button=new JButton("-");
        mul_button=new JButton("*");
        div_button=new JButton("/");
        eq_button=new JButton("=");
        clr_button=new JButton("clr");
        add_button.addActionListener(new operationbuttonlistener());
        sub_button.addActionListener(new operationbuttonlistener());
        mul_button.addActionListener(new operationbuttonlistener());
        div_button.addActionListener(new operationbuttonlistener());
        eq_button.addActionListener(new equalbuttonlistener());
        clr_button.addActionListener(new clrbuttonlistener());
        p.add(add_button);
        p.add(sub_button);
        p.add(mul_button);
        p.add(div_button);
        p.add(eq_button);
        p.add(clr_button);
        f.add(p,BorderLayout.CENTER);
        f.setVisible(true);
        
	}
	private  class numberbuttonlistener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JButton source = (JButton) e.getSource();
            inputfield.setText(inputfield.getText() + source.getText());
		}

		
	}
	private  class operationbuttonlistener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            try {
                num1 = Double.parseDouble(inputfield.getText());
                op = source.getText().charAt(0);
                inputfield.setText("");
            } catch (NumberFormatException ex) {
                inputfield.setText("Error");
            }
        }
	}
	private  class equalbuttonlistener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 try {
	                num2 = Double.parseDouble(inputfield.getText());
	                double result = 0;
	                switch (op) {
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
	                        if (num2 != 0) {
	                            result = num1 / num2;
	                        } else {
	                            inputfield.setText("Error");
	                            return;
	                        }
	                        break;
	                    default:
	                        inputfield.setText("Error");
	                        return;
	                }
	                inputfield.setText(String.valueOf(result));
	            } catch (NumberFormatException ex) {
	                inputfield.setText("Error");
	            }
		}
		}
	private class clrbuttonlistener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			inputfield.setText("");
			num1=num2=0;
			op=' ';
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simple_calculator sc=new simple_calculator();
	}

}
