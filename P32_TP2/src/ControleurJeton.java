import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ControleurJeton implements ActionListener{
	
	private enum EtatControleur {
		ATTENTE_CLIC_DEPART, ATTENTE_CLIC_ARRIVEE
	}
	
	private JButton button;
	private EtatControleur etat;
	
	public ControleurJeton() {
		this.etat = EtatControleur.ATTENTE_CLIC_DEPART;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		switch (this.etat) {
		case ATTENTE_CLIC_DEPART :
			this.button = b;
			this.etat = EtatControleur.ATTENTE_CLIC_ARRIVEE;
			break;
		case ATTENTE_CLIC_ARRIVEE :
			VueJeton.deplacerJeton(this.button, b);
			this.etat = EtatControleur.ATTENTE_CLIC_DEPART;
			break;
		
		}
	}
}
