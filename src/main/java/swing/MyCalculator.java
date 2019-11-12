package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyCalculator extends JFrame{
	
	public MyCalculator(){
		setTitle("我的计算器");
		setVisible(true);
		setBounds(200, 100, 350, 300);
	}
	
	public static void main(String[] args) {
		MyCalculator cal = new MyCalculator();
		BorderLayout border = new BorderLayout();
		cal.setLayout(border);
		JPanel panel1 = new JPanel();
		TextField text = new TextField(2);
		panel1.add(text);
		cal.add(panel1, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		GridLayout gridlayout = new GridLayout(4, 4);
		panel2.setLayout(gridlayout);
		JButton button1 = new JButton("7");
		panel2.add(button1);
		JButton button2 = new JButton("8");
		panel2.add(button2);
		JButton button3 = new JButton("9");
		panel2.add(button3);
		JButton button4 = new JButton("4");
		panel2.add(button4);
		JButton button5 = new JButton("5");
		panel2.add(button5);
		JButton button6 = new JButton("6");
		panel2.add(button6);
		JButton button7 = new JButton("1");
		panel2.add(button7);
		JButton button8 = new JButton("2");
		panel2.add(button8);
		JButton button9 = new JButton("3");
		panel2.add(button9);
		cal.add(panel2,BorderLayout.CENTER);
	}
}
