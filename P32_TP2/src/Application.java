import java.awt.GridLayout;

import javax.swing.JFrame;

public class Application {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(1, 1));
		f.add(new VueJeton());
		f.setTitle("Jeton");
		f.pack();
		f.setVisible(true);
		f.setSize(300, 300);
	}

}
