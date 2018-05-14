package direction;

import java.util.List;

import maintenance_etages.Chambre;
import maintenance_etages.ReservationChambre;

public class Hotel {
	private List<Chambre> lesChambres;
	private List<ReservationChambre> lesReservationsChambre;
	
	public Hotel(List<Chambre> lesChambres, List<ReservationChambre> lesReservationsChambre) {
		super();
		this.lesChambres = lesChambres;
		this.lesReservationsChambre = lesReservationsChambre;
	}
	
	public List<Chambre> getLesChambres() {
		return lesChambres;
	}
	public List<ReservationChambre> getLesReservationsChambre() {
		return lesReservationsChambre;
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
