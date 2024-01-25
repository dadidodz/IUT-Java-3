import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VueMastermind extends JPanel {


	private javax.swing.JTextField[] bPIHM;
	
	private javax.swing.JTextField[] combinaisonOrdiIHM;
	
	private javax.swing.JButton[][] combinaisonsJoueurIHM;
	
	private javax.swing.JTextField[] mPIHM;
	
	private int nbCouleurs;
	
	static int NBMAX_COMBINAISONS;
	
	private javax.swing.JButton[] paletteIHM;
	
	private static final long serialVersionUID = 1L;
	
	private int taille;
	
	private Color[] couleurs;
	
	private void initialiserCouleurs() {
		this.couleurs = new Color[6];
		this.couleurs[0] = Color.blue;
		this.couleurs[1] = Color.red;
		this.couleurs[2] = Color.green;
		this.couleurs[3] = Color.yellow;
		this.couleurs[4] = Color.cyan;
		this.couleurs[5] = Color.magenta;
	}
	
	public VueMastermind() {
		this.initialiserCouleurs();
		this.setLayout(new BorderLayout());
		//Partie gauche
		JPanel pGauche = new JPanel();
		JPanel pGaucheFils = new JPanel();
		pGauche.setLayout(new FlowLayout());
		pGaucheFils.setLayout(new GridLayout(1,6));
		for (int i=0 ; i<6 ; i++) {
			JButton b = new JButton();
			b.setName("Couleur "+this.couleurs[i]);
			b.setBackground(this.couleurs[i]);
			pGaucheFils.add(b);
		}
		pGauche.add(new JLabel("Couleurs : "));
		pGauche.add(pGaucheFils);
		this.add(pGauche, BorderLayout.NORTH);
		
		//Partie milieu
		JPanel pMilieu = new JPanel();
		pMilieu.setLayout(new GridLayout(10,2));
		for(int i=0 ; i<10 ; i++) {
			JPanel pMilieuFils1 = new JPanel();
			pMilieuFils1.setLayout(new GridLayout(1,4));
			for(int j=0; j<4; j++) {
				JButton b1 = new JButton();
				if(i!=0) {
					b1.setEnabled(false);
				}
				pMilieuFils1.add(b1);
			}
			JPanel pMilieuFils2 = new JPanel();
			pMilieuFils2.setLayout(new GridLayout(2,2));
			JTextField bpt = new JTextField();
			JTextField mpt = new JTextField();
			JLabel bp = new JLabel("BP");
			JLabel mp = new JLabel("MP");
			bpt.setEditable(false);
			mpt.setEditable(false);
			bp.setHorizontalAlignment(SwingConstants.CENTER);
			mp.setHorizontalAlignment(SwingConstants.CENTER);
			pMilieuFils2.add(bp);
			pMilieuFils2.add(mp);
			pMilieuFils2.add(bpt);
			pMilieuFils2.add(mpt);
			pMilieu.add(pMilieuFils1);
			pMilieu.add(pMilieuFils2);
		}
		this.add(pMilieu, BorderLayout.CENTER);
		
		//Partie droite
		JPanel pDroit = new JPanel();
		JPanel pDroitFils = new JPanel();
		pDroit.setLayout(new GridLayout(1,2));		
		pDroitFils.setLayout(new GridLayout(1,4));
		
		for(int i=0;i<4;i++) {
			JTextField t = new JTextField();
			t.setEditable(false);
			pDroitFils.add(t);
		}
		
		pDroit.add(pDroitFils);
		pDroit.add(new JButton("Valider"));
		this.add(pDroit, BorderLayout.SOUTH);		
	}
}
