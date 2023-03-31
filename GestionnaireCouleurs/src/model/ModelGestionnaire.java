package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;

public class ModelGestionnaire {
	private List<Couleur> couleurs;
	private int indiceCouleurCourante;
	private String nomFichier;
	private SimpleObjectProperty<Color> couleurRectangle;
	private SimpleStringProperty labelIndiceCouleur;
	
	public ModelGestionnaire(String nomFichier) throws IOException, ClassNotFoundException {
		this.couleurs = new ArrayList<>();
		this.indiceCouleurCourante = 0;
		this.nomFichier = nomFichier;
		this.couleurRectangle = new SimpleObjectProperty<>();
		this.labelIndiceCouleur = new SimpleStringProperty();
		
		try {
			FileInputStream fis = new FileInputStream(nomFichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.couleurs = (List<Couleur>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			this.couleurs = new ArrayList<>();
		}
	}
	
	public void ajouterCouleur(Couleur couleur) {
		this.couleurs.add(couleur);
	}
	
	public void supprimerCouleur(int indice) {
		couleurs.remove(indice);
	}
	
	public Couleur getCouleurCourante() {
		return this.couleurs.get(this.indiceCouleurCourante);
	}
	
	public String getFichier() {
		return nomFichier;
	}
	
	public SimpleObjectProperty<Color> getCouleurRectangle() {
		return couleurRectangle;
	}
	
	public SimpleStringProperty getLabelIndiceCouleur() {
		return labelIndiceCouleur;
	}
	
}
