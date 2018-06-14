package maintenance_etages;

import java.sql.ResultSet;
import java.sql.SQLException;

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

	public TypeChambre(String libelle, float prix, TAXES tax, int places) {
		this.libelle = libelle;
		this.prix = prix;
		this.taxes = tax.getTaxe();
		this.places = places;
	}

	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL("SELECT id FROM roomtype"
					+ " WHERE label = " + this.libelle
					+ " AND price = " + this.prix
					+ " AND taxes = " + this.taxes
					+ " AND nbPlaces = " + this.places);
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.id;
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
			if (!Connection.existSQL("SELECT id FROM roomtype WHERE label = '" + libelle + "'")) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE roomtype SET label = '" + libelle + "'");
			}
		}
	}
	public void setPrix(float prix) {
		if (this.prix != prix) {
			this.prix = prix;
			Connection.execSQL("UPDATE roomtype SET price = " + prix);
		}
	}
	public void setTaxes(double taxes) {
		if (this.taxes != taxes) {
			this.taxes = taxes;
			Connection.execSQL("UPDATE roomtype SET taxes = " + taxes);
		}
	}
	public void setPlaces(int places) {
		if (this.places != places) {
			this.places = places;
			Connection.execSQL("UPDATE roomtype SET nbPlaces = " + places);
		}
	}
	
	
	
	
}
