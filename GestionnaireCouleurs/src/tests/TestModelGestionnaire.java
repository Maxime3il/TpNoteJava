package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import model.Couleur;
import model.ModelGestionnaire;

class TestModelGestionnaire {
	
	private ModelGestionnaire model = new ModelGestionnaire();

	@Test
	public void testAjouterCouleur() {
		Couleur c = new Couleur("rouge", 255, 0, 0);
		model.ajouterCouleur(c);
		Assertions.assertEquals(c, model.getCouleurCourante());
		Assertions.assertEquals(1, model.getCouleurs().size());
	}

	@Test
	public void testSupprimerCouleur() {
		Couleur c1 = new Couleur("rouge", 255, 0, 0);
		Couleur c2 = new Couleur("vert", 0, 255, 0);
		model.ajouterCouleur(c1);
		model.ajouterCouleur(c2);
		model.supprimerCouleur(1);
		Assertions.assertEquals(1, model.getCouleurs().size());
		Assertions.assertEquals(c1, model.getCouleurs().get(0));
		Assertions.assertEquals(c1, model.getCouleurCourante());
	}

}
