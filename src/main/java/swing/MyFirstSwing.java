package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MyFirstSwing {
 	
	public static void createWindow(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("hello World");
		frame.setSize(500, 500);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lable = new JLabel("hello");
		frame.getContentPane().add(lable);
		//frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				createWindow();
			}
		});
	}
}
