package direction;

import java.util.List;

import hotel.Client;
import maintenance_etages.Chambre;
import maintenance_etages.ReservationChambre;

public class Hotel {
	private List<Chambre> lesChambres;
	private List<ReservationChambre> lesReservationsChambre;
	private List<Client> lesClients;

	public Hotel(List<Chambre> lesChambres, List<ReservationChambre> lesReservationsChambre, List<Client> clients) {
		super();
		this.lesChambres = lesChambres;
		this.lesReservationsChambre = lesReservationsChambre;
		this.lesClients = clients;
	}
	
	public List<Chambre> getLesChambres() {
		return lesChambres;
	}
	public List<ReservationChambre> getLesReservationsChambre() {
		return lesReservationsChambre;
	}
	public List<Client> getLesClients() {
		return lesClients;
	}
	public void setLesClients(List<Client> lesClients) {
		this.lesClients = lesClients;
	}
	public void setLesChambres(List<Chambre> lesChambres) {
		this.lesChambres = lesChambres;
	}
	public void setLesReservationsChambre(List<ReservationChambre> lesReservationsChambre) {
		this.lesReservationsChambre = lesReservationsChambre;
	}
	
	public double getTauxJournalier() {
		return 0;
	}
	public double getDureeMoyenne() {
		return 0;
	}
	public double getPanierMoyen() {
		return 0;
	}
	
}
