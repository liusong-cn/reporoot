package swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyBorderLayout {
	
	public static void main(String[] args) {
		JFrame j = new JFrame();
		BorderLayout bl = new BorderLayout();
		JButton j1 = new JButton("上");
		JButton j2 = new JButton("下");
		JButton j3 = new JButton("左");
		JButton j4 = new JButton("中");
		JButton j5 = new JButton("右");
		j.setSize(500,500);
		j.setLocation(300, 300);
		j.add(j1, BorderLayout.NORTH);
		j.add(j2, BorderLayout.SOUTH);
		j.add(j3, BorderLayout.WEST);
		j.add(j4, BorderLayout.CENTER);
		j.add(j5, BorderLayout.EAST);
		j.setVisible(true);
	}
}
