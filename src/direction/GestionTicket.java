package direction;

import java.util.List;

import hotel.Service;
import hotel.Ticket;
import hotel.Ticket.STATUT_TICKET;
import main.Connection;

public class GestionTicket {
	private List<Ticket> lesTickets;
	
	public GestionTicket(List<Ticket> lesTickets) {
		this.lesTickets = lesTickets;
	}
	
	public List<Ticket> getLesTickets() {
		return lesTickets;
	}
	public void setLesTickets(List<Ticket> lesTickets) {
		this.lesTickets = lesTickets;
	}
	
	public boolean creerTicket(String titre, String description, STATUT_TICKET statut, Service service) {
		boolean retour = false;
		if (!Connection.existSQL("SELECT id FROM ticket WHERE title = '" + titre + "'")) {
			Connection.execSQL("INSERT INTO ticket(details, status, title, id_serviceJob) VALUES ('" + description + "', '" + statut + "', '" + titre + "', " + service.getId() + ")");
			this.lesTickets.add(new Ticket(titre, description, statut, service));
			retour = true;
		}
		return retour;
	}
	public void deleteTicket(Ticket ticket) {
		this.lesTickets.remove(ticket);
		Connection.execSQL("DELETE FROM ticket WHERE ticket.id = " + ticket.getId());
	}
}
