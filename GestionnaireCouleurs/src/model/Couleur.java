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

}
