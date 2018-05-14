package maintenance_etages;

import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;

public class ReservationChambre extends Reservation {
	private List<Chambre> lesChambres;
	private Date endDate;
	
	public ReservationChambre(int id, Client client, Date startDate, List<Chambre> chambres, Date endDate) {
		super(id, client, startDate);
		this.lesChambres = chambres;
		this.endDate = endDate;
	}

	public List<Chambre> getLesChambres() {
		return lesChambres;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setLesChambres(List<Chambre> lesChambres) {
		this.lesChambres = lesChambres;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
