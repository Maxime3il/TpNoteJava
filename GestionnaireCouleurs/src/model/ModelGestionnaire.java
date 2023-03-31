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

/**
 * Cette classe représente le modèle du gestionnaire de couleurs. 
 * Elle contient une liste de couleurs, ainsi que des informations sur la couleur courante,
 * le fichier utilisé pour sauvegarder les couleurs, 
 * et les propriétés associées à l'interface utilisateur (couleur du rectangle, libellé de l'indice de la couleur courante).
 */
public class ModelGestionnaire {
	/**
	 * liste de couleur
	 */
	private List<Couleur> couleurs;

	/**
	 * indice de la couleur courante
	 */
	private int indiceCouleurCourante;

	/**
	 * Nom du fichier utilisé pour sauvegarder les couleurs.
	 */
	private String nomFichier;

	/**
	 * Propriété de la couleur du rectangle dans l'interface utilisateur.
	 */
	private SimpleObjectProperty<Color> couleurRectangle;

	/**
	 * Propriété du libellé de l'indice de la couleur courante dans l'interface utilisateur.
	 */
	private SimpleStringProperty labelIndiceCouleur;

	/**
	 * Constructeur par défaut.Initialise la liste des couleurs, 
	 * l'indice de la couleur courante, et les propriétés associées à l'interface utilisateur.
	 */
	public ModelGestionnaire() {
		this.couleurs = new ArrayList<>();
		this.indiceCouleurCourante = 0;
		this.couleurRectangle = new SimpleObjectProperty<>();
		this.labelIndiceCouleur = new SimpleStringProperty();
	}

	/**
	 * Constructeur prenant en paramètre le nom du fichier à partir duquel charger les couleurs. Si le fichier existe, les couleurs sont chargées. Sinon,
	 * une liste de couleurs vide est créée.
	 * @param nomFichier le nom du fichier contenant les couleurs à charger
	 * @throws IOException si une erreur d'entrée/sortie se produit lors de la lecture du fichier
	 * @throws ClassNotFoundException si une classe inconnue est trouvée lors de la désérialisation du fichier
	 */
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

	/**
	 * Ajoute une couleur à la liste des couleurs.
	 * @param couleur
	 */
	public void ajouterCouleur(Couleur couleur) {
		this.couleurs.add(couleur);
	}

	/**
	 * Supprime une couleur de la liste des couleurs. Si l'indice de la couleur supprimée est celui de la couleur courante, 
	 * l'indice de la couleur courante
	 * est ajusté pour pointer sur la couleur précédente dans la liste 
	 * (ou sur la dernière couleur si la couleur supprimée était la dernière).
	 * @param indice
	 */
	public void supprimerCouleur(int indice) {
		couleurs.remove(indice);
		if(indice >= couleurs.size()) {
			indiceCouleurCourante = couleurs.size() - 1; 
		}
	}

	/**
	 * Récupère la couleur à l'indice Courant
	 * @return
	 */
	public Couleur getCouleurCourante() {
		return this.couleurs.get(this.indiceCouleurCourante);
	}

	/**
	 * Récupère le fichier et son nom
	 * @return
	 */
	public String getFichier() {
		return nomFichier;
	}

	/**
	 * Récupère l'indiceCourant
	 * @return
	 */
	public int getIndiceCouleurCourante() {
		return indiceCouleurCourante;
	}

	/**
	 * Récupère la couleur du rectangle actuelle
	 * @return
	 */
	public SimpleObjectProperty<Color> getCouleurRectangle() {
		return couleurRectangle;
	}

	/**
	 * Récupère le label avec sa couleur
	 * @return
	 */
	public SimpleStringProperty getLabelIndiceCouleur() {
		return labelIndiceCouleur;
	}

	/**
	 * Récupère toutes la listes des couleurs
	 * @return
	 */
	public List<Couleur> getCouleurs() {
		return couleurs;
	}

}
