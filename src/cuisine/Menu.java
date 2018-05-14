package cuisine;

import java.util.List;

public class Menu {
	private int id;
	private float prixTTC;
	private String libelle;
	//private List<ArticleRestaurant> lesArticles;
	
	public Menu(int id, float prixTTC, String libelle) {
		this.id = id;
		this.prixTTC = prixTTC;
		this.libelle = libelle;
	}
	
	public float getPrixTTC() {
		return prixTTC;
	}
	public void setPrixTTC(float prixTTC) {
		this.prixTTC = prixTTC;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
}
