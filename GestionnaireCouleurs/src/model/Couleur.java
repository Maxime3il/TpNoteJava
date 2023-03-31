package model;

public class Couleur {

	private String nom;
	private int rouge;
	private int vert;
	private int bleu;
	
	/**
	 * Constructeur initialisant le RGB de la couleur 
	 * Ainsi que son nom attribuée
	 * @param nom
	 * @param rouge
	 * @param vert
	 * @param bleu
	 */
	public Couleur(String nom, int rouge, int vert, int bleu) {
		this.nom = nom;
		this.rouge = rouge;
		this.vert = vert;
		this.bleu = bleu;
	}

	/**
	 * Accesseur pour la variable nom de la couleur
	 * @return nom de la couleur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur pour la variable rouge de la couleur
	 * @return rgb rouge de la couleur
	 */
	public int getRouge() {
		return rouge;
	}

	/**
	 * Accesseur pour la variable vert de la couleur
	 * @return rgb vert de la couleur
	 */
	public int getVert() {
		return vert;
	}

	/**
	 * Accesseur pour la variable bleu de la couleur
	 * @return rgb bleu de la couleur
	 */
	public int getBleu() {
		return bleu;
	}

}
