import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControleurMorpion implements ActionListener {

	private enum EtatControleur {
		JOUEUR1, JOUEUR2, PARTIE_FINIE
	}
	
	private VueMorpion vue;
	private ModeleMorpion modele;
	private EtatControleur etat;
	
	public ControleurMorpion(VueMorpion vue) {
		this.vue = vue;
		this.modele = new ModeleMorpion();
		this.etat = EtatControleur.JOUEUR1;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		Couple couple;
		int i;
		int j;
		if (b.getText().contentEquals("Effacer")) {
			this.vue.initialiser();
			this.modele.initialiser();
			System.out.println(this.modele);
			this.etat = EtatControleur.JOUEUR1;
		} else {
			switch (this.etat) {
			case JOUEUR1 :
				b.setText("X");
				b.setEnabled(false);
				couple = this.vue.coordonnéesBtCaseGrille(b);
				i = couple.getC1();
				j = couple.getC2();
				this.modele.setValeurCase(i, j, TypeCase.JOUEUR1);
				if (this.modele.casesAlignées(i, j)) {
					this.vue.afficherResultat(1);
					this.etat = EtatControleur.PARTIE_FINIE;
				} else {
					this.vue.afficherJoueurCourant(2);
					this.etat = EtatControleur.JOUEUR2;
				}
				System.out.println(this.modele);
				break;
			case JOUEUR2 :
				b.setText("O");
				b.setEnabled(false);
				couple = this.vue.coordonnéesBtCaseGrille(b);
				i = couple.getC1();
				j = couple.getC2();
				this.modele.setValeurCase(i, j, TypeCase.JOUEUR2);
				if (this.modele.casesAlignées(i, j)) {
					this.vue.afficherResultat(2);
					this.etat = EtatControleur.PARTIE_FINIE;
				} else {
					this.vue.afficherJoueurCourant(1);
					this.etat = EtatControleur.JOUEUR1;
				}
				System.out.println(this.modele);
				break;
			}
		}

	}

}
