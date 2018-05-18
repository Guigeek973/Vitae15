package restaurant;

import java.util.Date;

import main.Connection;

public class ServiceTable {
	private int nbCouvertsRestant;
	private int numero;
	private Date date;
	
	public ServiceTable(int nbCouvertsRestant, int numero, Date date) {
		super();
		this.nbCouvertsRestant = nbCouvertsRestant;
		this.numero = numero;
		this.date = date;
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
		
		if (this.nbCouvertsRestant != nbCouvertsRestant) {
			this.nbCouvertsRestant = nbCouvertsRestant;
			Connection.execSQL("UPDATE servicetable SET nbRestant = '" + this.nbCouvertsRestant + "'");
		}
	}
	public void setNumero(int numero) {
		
		if (this.numero != numero) {
			this.numero = numero;
			Connection.execSQL("UPDATE servicetable SET num_service = '" + this.numero + "'");
		}
	}
	public void setDate(Date date) {
		
		if (this.date != date) {
			this.date = date;
			Connection.execSQL("UPDATE servicetable SET dateTime = '" + this.date + "'");
		}
	}
	
}
