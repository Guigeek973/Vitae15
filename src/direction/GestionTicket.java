package direction;

import java.util.List;

import hotel.Ticket;
import hotel.Ticket.STATUT_TICKET;

public class GestionTicket {
	private List<Ticket> lesTickets;
	
	public GestionTicket(List<Ticket> lesTickets) {
		super();
		this.lesTickets = lesTickets;
	}
	
	public List<Ticket> getLesTickets() {
		return lesTickets;
	}
	public void setLesTickets(List<Ticket> lesTickets) {
		this.lesTickets = lesTickets;
	}
	
	public void addTicket(String titre, String description, STATUT_TICKET statut) {
		
	}
	public void deleteTicket(Ticket ticket) {
		
	}
	public void modifierTicket(String titre, String description, STATUT_TICKET statut) {
		
	}
}
