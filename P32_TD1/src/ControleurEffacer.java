import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurEffacer implements ActionListener {

	private VueMorpion vue;
	private ModeleMorpion modele;
	
	public ControleurEffacer(VueMorpion vue) {
		this.vue = vue;
		this.modele = new ModeleMorpion();
		//System.out.println(this.modele);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.vue.initialiser();
		this.modele.initialiser();
		//System.out.println(this.modele);
	}

}
