package stock;

import main.Connection;

public class ArticleRestaurant {
	private int id;
	private String libelle;
	private String description;
	private int quantite;
	private double prix;
	private double taxes;
	private TYPE_FOOD typeNourriture;
	public enum TYPE_FOOD {
		BOISSON_CHAUDE(10),
		BOISSON_FROIDE(10),
		VIENNOISERIE(5.5),
		PLAT(10),
		FRUIT(5.5);
		
		private double taxe;
		TYPE_FOOD(double tax) {
			this.taxe = tax;
		}
		
		public double getTaxe() {
			return this.taxe;
		}
	}
	
	public ArticleRestaurant(int id, String libelle, String description, int quantite, double prix, TYPE_FOOD typeFood) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
		this.typeNourriture = typeFood;
		this.taxes = typeFood.getTaxe();
	}
	
	
	public double getPrix() {
		return prix;
	}
	public double getTaxes() {
		return taxes;
	}
	public TYPE_FOOD getTypeNourriture() {
		return typeNourriture;
	}
	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public String getDescription() {
		return description;
	}
	public int getQuantite() {
		return quantite;
	}
	
	
	//SETTERS
	public void setQuantite(int quantite) {
		if (this.quantite != quantite) {
			this.quantite = quantite;
			Connection.execSQL("UPDATE ArticleRestaurant SET quantity = " + this.quantite);
		}
	}
	public void setPrix(double prix) {
		if (this.prix != prix) {
			this.prix = prix;
			Connection.execSQL("UPDATE ArticleRestaurant SET price = " + this.prix);
		}
	}
	public void setTaxes(double taxes) {
		if (this.taxes != taxes) {
			this.taxes = taxes;
			Connection.execSQL("UPDATE ArticleRestaurant SET taxes = " + this.taxes);
		}
	}
	public void setTypeNourriture(TYPE_FOOD typeNourriture) {
		if (this.typeNourriture != typeNourriture) {
			this.typeNourriture = typeNourriture;
			Connection.execSQL("UPDATE ArticleRestaurant SET typeFood = '" + this.typeNourriture + "'");
		}
	}
	public void setLibelle(String libelle) {
		if (this.libelle != libelle) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE ArticleRestaurant SET label = '" + this.libelle + "'");
		}
	}
	public void setDescription(String description) {
		if (this.description != description) {
			this.description = description;
			Connection.execSQL("UPDATE ArticleRestaurant SET description = '" + this.description + "'");
		}
	}
}