package direction;

import java.util.List;

import hotel.Reservation;
import hotel.TicketRoomService;
import main.Connection;
import stock.ArticleRestaurant;

public class Facture {
	 private int id;
	 private String libelle;
	 private double total;
	 private List<Reservation> lesReservations;
	 private List<TicketRoomService> lesTicketsRoomService;
	 private STATUS status;
	 public enum STATUS {
		 PAYEE,
		 EN_COURS
	 }
	public Facture(int id, String libelle, double total, List<Reservation> lesReservations,
			List<TicketRoomService> lesTicketsRoomService, STATUS status) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.total = total;
		this.lesReservations = lesReservations;
		this.lesTicketsRoomService = lesTicketsRoomService;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public double getTotal() {
		return total;
	}
	public STATUS getStatus() {
		return status;
	}
	public List<Reservation> getLesReservations() {
		return lesReservations;
	}
	public List<TicketRoomService> getLesTicketsRoomService() {
		return lesTicketsRoomService;
	}
	
	
	public void setLibelle(String libelle) {
		if (this.libelle != libelle) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE bill SET label = '" + this.libelle + "'");
		}
	}
	public void setTotal(double total) {
		if (this.total != total) {
			this.total = total;
			Connection.execSQL("UPDATE bill SET amount = '" + this.total + "'");
		}
	}
	public void setStatus(STATUS status) {
		if (this.status != status) {
			this.status = status;
			Connection.execSQL("UPDATE bill SET status = '" + this.status + "'");
		}
	}
	

	
	public void setLesReservations(List<Reservation> lesReservations) {
		Connection.execSQL("DELETE FROM facturer WHERE id_Bill = " + this.getId());
		ajoutReservation(lesReservations);
	}
	public void ajoutReservation(List<Reservation> lesReservations) {
		for(Reservation article : lesReservations) {
			this.lesReservations.add(article);
			Connection.execSQL("INSERT INTO facturer VALUES (" + article.getId() + ", " + this.getId() + ")");
		}
	}
	
	
	// chaque ticket a une chambre donc selectionnez la chambre et recuperer le client associé pour une date donné et donc sa reservation (abstract pour le facturer.
	/*
	public void setLesTicketsRoomService(List<TicketRoomService> lesTicketsRoomService) {
		Connection.execSQL("DELETE FROM XXXXXXXXXX WHERE id_Bill = " + this.getId());
		ajoutTicket(lesTicketsRoomService);
	}
	public void ajoutTicket(List<TicketRoomService> lesTicketsRoomService) {
		for(TicketRoomService article : lesTicketsRoomService) {
			this.lesTicketsRoomService.add(article);
			Connection.execSQL("INSERT INTO XXXXXXXXXX VALUES (" + article.getId() + ", " + this.getId() + ")");
		}
	}
	
	*/
	
	
	
}
