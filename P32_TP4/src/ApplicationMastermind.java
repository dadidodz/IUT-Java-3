import java.awt.GridLayout;

import javax.swing.JFrame;

public class ApplicationMastermind {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(1, 1));
		f.add(new VueMastermind());
		f.setTitle("Mastermind");
		f.pack();
		f.setVisible(true);
		f.setSize(150, 650);

	}

}
