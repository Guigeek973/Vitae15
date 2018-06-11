package direction;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
import hotel.Reservation.STATUT_RESERVATION;
import main.Connection;
import maintenance_etages.Chambre;
import maintenance_etages.ReservationChambre;
import restaurant.ReservationRestaurant;
import restaurant.ServiceTable;
import spa.PrestationSpa;
import spa.ReservationSpa;
import stock.Menu;

public class GestionReservation {
	private List<Reservation> lesReservations;
	
	public boolean prendreReservation(Client client, Date startDate, Date endDate) throws SQLException { //CHAMBRE
		int idReservation = 0;
		//si une reservation avec ce client et cette startDate existe alors on la prend en reference sinon on la cr�e
		if (Connection.existSQL("SELECT id FROM reservation"
				+ " WHERE id_Client = " + client.getId()
				+ " AND startDate = " + startDate)) {
			idReservation = Connection.getResultSetSQL("SELECT id FROM reservation"
					+ " WHERE id_Client = " + client.getId()
					+ " AND startDate = " + startDate).getInt(1);
		}
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.s");
		    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		    
			Connection.execSQL("INSERT INTO reservation VALUES(" + timestamp + ", "  + startDate + ", " +  STATUT_RESERVATION.EN_COURS + ", " +  client.getId() + ")" );
		}
		if (!Connection.existSQL("SELECT id FROM reservation"
				+ " JOIN reservationroom"
				+ " ON reservationroom.id_Reservation = reservation.id"
				+ " WHERE id_Client = " + client.getId()
				+ " AND startDate = " + startDate 
				+ " AND endDate = " + endDate)) {

			Connection.execSQL("INSERT INTO reservationroom VALUES(" +  endDate + ", " + idReservation + ")" );
			this.lesReservations.add(new ReservationChambre(client, startDate, endDate));
			return true;
		}
		return false;
	}
	public boolean prendreReservation(Client client, Date startDate, int nbCouverts, ServiceTable service) throws SQLException { //TABLE
		if (!Connection.existSQL("SELECT id FROM reservationtableset WHERE client = " + client + "AND startDate =" + startDate + "AND nbTableSet = " + nbCouverts + "AND id_ServiceTable = " + service.getId())) {
			Connection.execSQL("INSERT INTO reservationtableset VALUES(" + client + "," + startDate + "," + nbCouverts + "," + service.getId() + ")" );
			this.lesReservations.add(new ReservationRestaurant(client, startDate, nbCouverts, service));
			return true;
		}
		return false;
	}
	public boolean prendreReservation(Client client, Date startDate, PrestationSpa prestation) throws SQLException { //SPA
		if (!Connection.existSQL("SELECT id FROM reservationspa WHERE client = " + client + "AND startDate =" + startDate + "AND id_Prestation = " + prestation.getId())) {
			Connection.execSQL("INSERT INTO reservationspa VALUES(" + client + "," + startDate + "," + prestation.getId() + ")" );
			int idReservationResto = Connection.getResultSetSQL("SELECT id FROM reservationspa WHERE client = " + client + "AND startDate =" + startDate + "AND id_Prestation = " + prestation.getId()).getInt("id");
			this.lesReservations.add(new ReservationSpa(idReservationResto, client, startDate, prestation));
			return true;
		}
		return false;
	}
	public void deleteReservation(Reservation reservation) {
		this.lesReservations.remove(reservation);
		
		if (reservation.getClass().getSimpleName() == "ReservationChambre") {
			ReservationChambre resa = (ReservationChambre) reservation;
			Connection.getResultSetSQL("SELECT id FROM reservationroom WHERE client = " + resa.getClient() + "AND startDate =" + resa.getStartDate() + "AND endDate = " + resa.getEndDate());
		}
		else if (reservation.getClass().getSimpleName() == "ReservationRestaurant") {
			ReservationRestaurant resa = (ReservationRestaurant) reservation;
			Connection.getResultSetSQL("SELECT id FROM reservationtableset WHERE client = " + resa.getClass() + "AND startDate =" + resa.getStartDate() + "AND nbTableSet = " + resa.getNbCouverts() + "AND id_ServiceTable = " + resa.getService().getId());
		}
		else if (reservation.getClass().getSimpleName() == "ReservatioSpa") {
			ReservationSpa resa = (ReservationSpa) reservation;
			Connection.getResultSetSQL("DELETE FROM reservationspa WHERE client = " + reservation.getClient() + "AND startDate =" + reservation.getStartDate() + "AND id_Prestation = " + resa.getPrestation().getId());
		}
	}
	
	//TODO : verif ces fonctions
	public void modifierReservation(Client client, Date startDate, Date endDate) {
		Connection.execSQL("INSERT INTO reservationroom VALUES(" + client + "," + startDate + "," + endDate +")" );
		
	}
	public void modifierReservation(Client client, Date startDate, int nbCouverts, ServiceTable service) {
		Connection.execSQL("INSERT INTO reservationtableset VALUES(" + client + "," + startDate + "," + nbCouverts + "," + service.getId() + ")" );

	}
	public void modifierReservation(Client client, Date startDate, PrestationSpa prestation) {
		Connection.execSQL("INSERT INTO reservationspa VALUES(" + client + "," + startDate + "," + prestation.getId() + ")" );

	}
}
