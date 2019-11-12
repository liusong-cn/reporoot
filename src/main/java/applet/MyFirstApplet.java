package applet;

import java.applet.Applet;
import java.awt.Graphics;

public class MyFirstApplet extends Applet {
	
	public void paint(Graphics g){
		g.drawString("hello world", 100, 100);
	}
	
}
