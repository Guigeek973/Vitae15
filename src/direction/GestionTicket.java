package direction;

import java.util.List;

import hotel.Service;
import hotel.Ticket;
import hotel.Ticket.STATUT_TICKET;
import main.Connection;

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
	
	public boolean creerTicket(String titre, String description, STATUT_TICKET statut, Service service) {
		if (!Connection.existSQL("SELECT id FROM ticket WHERE title = '" + titre + "'")) {
			Connection.execSQL("INSERT INTO ticket(details, status, title, id_serviceJob) VALUES ('" + description + "', '" + statut + "', '" + titre + "', " + service.getId() + ")");
			this.lesTickets.add(new Ticket(titre, description, statut, service));
			return true;
		}
		return false;
	}
	public void deleteTicket(Ticket ticket) {
		Connection.execSQL("DELETE FROM ticket WHERE ticket.id = " + ticket.getId());
	}
	public void modifierTicket(Ticket ticket, String titre, String description, STATUT_TICKET statut) {
		Connection.execSQL("UPDATE ticket SET title = '" + titre + "', details = '"+description+"', status = '"+statut+"' WHERE ticket.id = " + ticket.getId());
	}
}
