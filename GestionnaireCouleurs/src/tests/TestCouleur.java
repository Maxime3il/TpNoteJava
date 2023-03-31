package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Couleur;

class TestCouleur {

	@Test
	void testConstructeurCouleur() {
		Couleur couleurTest = new Couleur("rouge", 255, 0, 0);
		Assertions.assertEquals("rouge", couleurTest.getNom());
	}

}
