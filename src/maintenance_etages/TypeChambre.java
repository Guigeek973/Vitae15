package maintenance_etages;

import main.Connection;

public class TypeChambre {
	private int id;
	private String libelle;
	private float prix;
	private double taxes;
	private int places;
	
	public enum TAXES {
		LOW(5.5),
		MEDIUM(10),
		HIGH(20);
		
		private double taxe;
		
		TAXES(double tax) {
			this.taxe = tax;
		}
		public double getTaxe() {
			return this.taxe;
		}
	}

	public TypeChambre(int id, String libelle, float prix, TAXES tax, int places) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.taxes = tax.getTaxe();
		this.places = places;
	}

	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public float getPrix() {
		return prix;
	}
	public double getTaxes() {
		return taxes;
	}
	public int getPlaces() {
		return places;
	}

	
	
	public void setLibelle(String libelle) {
		if (this.libelle != libelle) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE roomtype SET label = '" + this.libelle + "'");
		}
	}
	public void setPrix(float prix) {
		if (this.prix != prix) {
			this.prix = prix;
			Connection.execSQL("UPDATE roomtype SET price = " + this.prix);
		}
	}
	public void setTaxes(double taxes) {
		if (this.taxes != taxes) {
			this.taxes = taxes;
			Connection.execSQL("UPDATE roomtype SET taxes = " + this.taxes);
		}
	}
	public void setPlaces(int places) {
		if (this.places != places) {
			this.places = places;
			Connection.execSQL("UPDATE roomtype SET nbPlaces = " + this.places);
		}
	}
	
	
	
	
}
