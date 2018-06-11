package maintenance_etages;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.Connection;

public class Chambre {
	private int id;
	private TypeChambre typeChambre;
	private String libelle;
	private ETAT_CHAMBRE etatChambre;
	private Boolean isOccuped;
	public enum ETAT_CHAMBRE {
		SALE,
		PROPRE
	}
	public Chambre(TypeChambre typeChambre, String libelle, ETAT_CHAMBRE etatChambre, Boolean isOccuped) {
		super();
		this.typeChambre = typeChambre;
		this.libelle = libelle;
		this.etatChambre = etatChambre;
		this.isOccuped = isOccuped;
	}
	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL("SELECT id FROM room"
					+ " WHERE label = " + this.libelle
					+ " AND id_RoomType = " + this.typeChambre.getId()
					+ " AND isAvailable = " + this.isOccuped
					+ " AND status = " + this.etatChambre);
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setId(id);
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TypeChambre getTypeChambre() {
		return typeChambre;
	}
	public String getLibelle() {
		return libelle;
	}
	public ETAT_CHAMBRE getEtatChambre() {
		return etatChambre;
	}
	public Boolean getIsOccuped() {
		return isOccuped;
	}
	
	
	public void setTypeChambre(TypeChambre typeChambre) {
		if (this.typeChambre != typeChambre) {
			this.typeChambre = typeChambre;
			Connection.execSQL("UPDATE room SET id_RoomType = " + typeChambre.getId());
		}
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
		if (this.libelle != libelle) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE room SET label = '" + libelle + "'");
		}
	}
	public void setEtatChambre(ETAT_CHAMBRE etatChambre) {
		this.etatChambre = etatChambre;
		if (this.etatChambre != etatChambre) {
			this.etatChambre = etatChambre;
			Connection.execSQL("UPDATE room SET status = '" + etatChambre + "'");
		}
	}
	public void setIsOccuped(Boolean isOccuped) {
		if (this.isOccuped != isOccuped) {
			this.isOccuped = isOccuped;
			Connection.execSQL("UPDATE room SET isAvailable = " + isOccuped);
		}
	}
}