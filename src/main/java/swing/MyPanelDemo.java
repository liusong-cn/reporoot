package swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelDemo {
	
	public static void main(String[] args) {
		JFrame j = new JFrame();
		JPanel panel = new JPanel();
		JLabel lable = new JLabel("显示在panel中的文字");
		panel.add(lable);
		panel.setBackground(Color.yellow);
		j.add(panel);
		j.setVisible(true);
			
	}
}
