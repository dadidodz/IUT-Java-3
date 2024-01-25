import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


/**
 * Cette classe permet de construire un <b>panneau</b> compos� de trois
 * �tiquettes et de trois champs de texte
 * 
 * @author Christine JULIEN
 * @version 1.1.6
 * @see java.awt.Label
 * @see java.awt.Panel
 * @see java.awt.Canvas
 * @see java.awt.GridLayout
 * @see java.awt.TextField
 * @see java.awt.event.FocusAdapter
 * @see java.awt.event.FocusEvent
 */

public class VueCouleur extends JPanel implements CaretListener{
    /**
     * champ textuel associ� � la valeur de la nuance rouge
     */
    private JTextField tRouge;

    /**
     * champ textuel associ� � la valeur de la nuance verte
     */
    private JTextField tVert;

    /**
     * champ textuel associ� � la valeur de la nuance bleue
     */
    private JTextField tBleu;

    /**
     * canevas dont la couleur de fond correspond � la combinaison des nuances
     * RVB
     */
    private JTextField cCouleur;

    /**
     * construit une vue couleur
     */
    public VueCouleur() {
        // s�lectionner le gestionnaire de mise en page du PanneauCouleur :
        // grille d'1 ligne et de 2 colonnes
        this.setLayout(new GridLayout(1, 2));
        // cr�er un canevas de couleur de fond noire
        this.cCouleur = new JTextField();
        this.cCouleur.setEditable(false);
        this.cCouleur.setBackground(Color.black);
        // associer le canevas au PanneauCouleur
        this.add(this.cCouleur);
        // cr�er un panneau puis s�lectionner
        // son gestionnaire de mise en page : grille de 3 lignes et 3 colonnes
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 10, 10));
        // ajouter le panneau � l'instance courante
        this.add(p);
        // cr�er et ajouter dans le panneau
        // l'�tiquette de libell� "rouge" align� � droite et un champ de texte
        // initialis� � "0"
        p.add(new JLabel("rouge", JLabel.RIGHT));
        this.tRouge = new JTextField("0");
        p.add(this.tRouge);
        // cr�er et ajouter dans le panneau
        // l'�tiquette de libell� "vert" align� � droite et un champ de texte
        // initialis� � "0"
        p.add(new JLabel("vert", JLabel.RIGHT));
        this.tVert = new JTextField("0");
        p.add(this.tVert);
        // cr�er et ajouter dans le panneau
        // l'�tiquette de libell� "bleu" align� � droite et un champ de texte
        // initialis� � "0"
        p.add(new JLabel("bleu", JLabel.RIGHT));
        this.tBleu = new JTextField("0");
        p.add(this.tBleu);
        // associer un controleur de focus � chaque
        // champ de texte pour �tre � l'�coute d'un changement de focus
        //ControleurCouleur controleur = new ControleurCouleur(this);
        this.tRouge.addCaretListener(this);
        this.tVert.addCaretListener(this);
        this.tBleu.addCaretListener(this);
    }

    /**
     * change la couleur de fond du canevas
     */
    public void setCouleurCanvas(Color c) {
        this.cCouleur.setBackground(c);
    }

    /**
     * acc�de au champ textuel contenant la nuance rouge
     */
    public JTextField getTRouge() {
        return this.tRouge;
    }

    /**
     * acc�de au champ textuel contenant la nuance verte
     */
    public JTextField getTVert() {
        return this.tVert;
    }

    /**
     * acc�de au champ textuel contenant la nuance bleue
     */
    public JTextField getTBleu() {
        return this.tBleu;
    }

	@Override
	public void caretUpdate(CaretEvent e) {
		Color c;
        // convertir le contenu du premier champ de texte
        // en un entier pour obtenir la nuance rouge
        int v1 = Integer.parseInt(this.getTRouge().getText());
        // convertir le contenu du deuxieme champ de texte
        // en un entier pour obtenir la nuance verte
        int v2 = Integer.parseInt(this.getTVert().getText());
        // convertir le contenu du troisieme champ de texte
        // en un entier pour obtenir la nuance bleue
        int v3 = Integer.parseInt(this.getTBleu().getText());
        // creer une couleur a partir des 3 nuances obtenues
        c = new Color(v1, v2, v3);
        // changer la couleur de fond du canevas couleurRVB
        // a partir de la nouvelle couleur obtenue
        this.setCouleurCanvas(c);
		
	}
}
