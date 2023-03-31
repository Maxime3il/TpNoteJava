package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Couleur;

class TestCouleur {

	@Test
	void testConstructeurCouleur() {
		Couleur couleurTest = new Couleur("rouge", 255, 0, 0);
		//Test du nom de la couleur
		Assertions.assertEquals("rouge", couleurTest.getNom());
		//Test d'accesseur pour le rgb rouge 
		Assertions.assertEquals(255, couleurTest.getRouge());
		//Test d'accesseur pour le rgb verte 
		Assertions.assertEquals(0, couleurTest.getVert());
		//Test d'accesseur pour le rgb bleu 
		Assertions.assertEquals(0, couleurTest.getBleu());
		
		//Test des setter de la classe Couleur
		couleurTest.setNom("bleu");
		couleurTest.setRouge(0);
		couleurTest.setVert(0);
		couleurTest.setBleu(255);
		
		//Test du nom de la couleur
		Assertions.assertEquals("bleu", couleurTest.getNom());
		//Test d'accesseur pour le rgb rouge 
		Assertions.assertEquals(0, couleurTest.getRouge());
		//Test d'accesseur pour le rgb verte 
		Assertions.assertEquals(0, couleurTest.getVert());
		//Test d'accesseur pour le rgb bleu 
		Assertions.assertEquals(255, couleurTest.getBleu());
	}

}
