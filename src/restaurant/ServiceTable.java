package restaurant;

import java.util.Date;

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
		this.nbCouvertsRestant = nbCouvertsRestant;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
