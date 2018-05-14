package direction;

import java.util.List;

import hotel.Reservation;
import hotel.TicketRoomService;

public class Facture {
	 private int id;
	 private String libelle;
	 private double total;
	 private List<Reservation> lesReservations;
	 private List<TicketRoomService> lesTicketsRoomService;
	 private String status;
	 public enum STATUS {
		 PAYEE,
		 EN_COURS
	 }
	public Facture(int id, String libelle, double total, List<Reservation> lesReservations,
			List<TicketRoomService> lesTicketsRoomService, String status) {
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
	public String getStatus() {
		return status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	
}
