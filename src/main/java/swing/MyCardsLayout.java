package swing;

import java.awt.CardLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyCardsLayout {
	
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setTitle("使用卡片式布局管理器");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel cards = new JPanel(new CardLayout());
		p1.add(new JButton("button1"));
		p1.add(new JButton("button2"));
		p2.add(new TextField("第二个布局面板"));
		p2.add(new TextField("的内容是文字"));
		cards.add("card1", p1);
		cards.add("card2",p2);
		CardLayout c1 = (CardLayout)(cards.getLayout());
		c1.show(cards, "card2");
		j.add(cards);
		j.setVisible(true);
		/*byte c = (byte)130;
		System.out.println(c);*/
	}
}
