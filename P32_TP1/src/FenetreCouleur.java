
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Cette classe permet de construire une <b>fenetre</b> composee d'un
 * PanneauCouleur.
 * 
 * 
 * @author Christine JULIEN
 * @version 1.1.6
 * @see java.awt.Frame
 * @see java.awt.Canvas
 * @see java.awt.GridLayout
 * @see java.awt.event.WindowAdapter
 * @see java.awt.event.WindowEvent
 * @see PanneauCouleur
 */

public class FenetreCouleur {
    /**
     * Construit une FenetreCouleur contenant un PanneauCouleur
     */
    public FenetreCouleur() {
    	JFrame f = new JFrame();
        // associer un titre à la FenetreCouleur
        f.setTitle("Conversions RVB");
        // selectionner le gestionnaire de mise en page de la FenetreCouleur
        f.setLayout(new GridLayout(1, 1));
        // creer une vue couleur et l'ajouter a la FenetreCouleur
        f.add(new VueCouleur());
        // associer un gestionnaire de fenetre a la FenetreCouleur
        // a l'ecoute d'un evenement se produisant sur la fenetre
        f.addWindowListener(new ControleurFenetre());
        // afficher la FenetreCouleur
        f.pack();
        f.setVisible(true);
        // associer une taille à la FenetreCouleur
        f.setSize(300, 150);
    }
}
