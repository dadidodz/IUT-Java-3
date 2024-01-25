import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		ModeleMastermind jeu = new ModeleMastermind();
		jeu.genererCombinaison();
		
		//Affiche la combinaison générée
		jeu.getCombinaison();
		System.out.println(jeu.toString());
		
		Scanner entree = new Scanner( System.in );
		int tabCombJoueur[] = new int[jeu.getTaille()];
        while (jeu.nbChiffresBienPlaces(tabCombJoueur) != tabCombJoueur.length) {
        	System.out.print( "Saisir une combinaison :" );
            for (int i = 0; i < tabCombJoueur.length; i++) {
            	int combJoueur = entree.nextInt();
                tabCombJoueur[i] = combJoueur;
            }
            System.out.println("Votre combinaison est : ");
            String res = "( ";
            for (int i = 0; i < tabCombJoueur.length; i++) {
            	res = res + tabCombJoueur[i] + " ";
            }
            res = res + ")";
            System.out.println(res);
            System.out.println("Vous avez " + jeu.nbChiffresBienPlaces(tabCombJoueur) + " chiffre(s) bien(s) placé(s).");
            System.out.println("Vous avez " + jeu.nbChiffresMalPlaces(tabCombJoueur) + " chiffre(s) mal(s) placé(s).\n");
            res = null;
        }
        entree.close();
        System.out.println("Bravo ! Vous avez trouvé la combinaison !");
	}
}
