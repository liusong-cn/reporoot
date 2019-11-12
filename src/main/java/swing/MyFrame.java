package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("我的窗口");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		JLabel lable = new JLabel();
		lable.setText("hello world");
		frame.getContentPane().add(lable);
		frame.setVisible(true);
		frame.setSize(250,300);
		frame.setLocation(500,500);
	}
}
