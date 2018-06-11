package restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import main.Connection;

public class ServiceTable {
	private int id;
	private int nbCouvertsRestant;
	private int numero;
	private Date date;
	
	public ServiceTable(int nbCouvertsRestant, int numero, Date date) {
		super();
		this.nbCouvertsRestant = nbCouvertsRestant;
		this.numero = numero;
		this.date = date;
	}
	
	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL("SELECT id FROM servicetable"
					+ " WHERE nbRestant = " + this.nbCouvertsRestant
					+ " AND num_service = " + this.numero
					+ " AND dateTime = " + this.date);
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
	
	public Date getEndDate() {
		return null;
		//return // l'heure de fin du service de maniere a pouvoir l'insérer dans les endDate des reservations.
	}
	
	public int getNbCouvertsRestant() {
		return nbCouvertsRestant;
	}
	public int getNumero() {
		return numero;
	}
	public Date getDate() {
		return date;
	}
	
	public void setNbCouvertsRestant(int nbCouvertsRestant) {
		this.nbCouvertsRestant = nbCouvertsRestant;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
