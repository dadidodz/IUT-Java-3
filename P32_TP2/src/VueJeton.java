import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VueJeton extends JPanel{

	public VueJeton() {
		ControleurJeton controleur = new ControleurJeton();
		this.setLayout(new GridLayout(2, 2));
		JButton b1 = new JButton();
		ImageIcon image = new ImageIcon("image.jpg");
		b1.setIcon(image);
		b1.addActionListener(controleur);
		this.add(b1);
		JButton b2 = new JButton("");
		b2.addActionListener(controleur);
		this.add(b2);
		JButton b3 = new JButton("");
		b3.addActionListener(controleur);
		this.add(b3);
		JButton b4 = new JButton("");
		b4.addActionListener(controleur);
		this.add(b4);
	}
	
	public static boolean estCaseVide (JButton case1) {
		boolean res;
		if (case1.getIcon() == null) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}
	
	public static void deplacerJeton (JButton case1, JButton case2) {
		boolean bcase1 = estCaseVide(case1);
		boolean bcase2 = estCaseVide(case2);
		ImageIcon image = new ImageIcon("image.jpg");
		if (bcase1==false && bcase2==true) {
			case1.setIcon(null);
			case2.setIcon(image);
		}
	}
}
