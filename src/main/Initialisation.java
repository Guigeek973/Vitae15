package main;
import main.Connection;
import maintenance_etages.Chambre;
import maintenance_etages.Chambre.ETAT_CHAMBRE;
import maintenance_etages.ReservationChambre;
import maintenance_etages.TypeChambre;
import maintenance_etages.TypeChambre.TAXES;
import stock.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import direction.Hotel;
import hotel.Client;

public class Initialisation {
	
	private static String reqClients = "SELECT * FROM client";
	private static String reqChambres = "SELECT * FROM room JOIN roomtype ON id_RoomType = roomtype.id";
	private static String reqReservationsChambres = "SELECT id_Client, startDate, endDate FROM reservationroom JOIN reservation ON id_Reservation = reservation.id";
	private static String reqTypeChambre= "SELECT * FROM roomtype";

	public static void initialisation() {
		//Hotel.getInstance(recupererChambres(), recupererReservationsChambres(), recupererClients() );
		
		
	}
//	public static Client findClient(int id) {
//		ResultSet rs = Connection.getResultSetSQL(reqClients);
//		try {
//			Client cl = null;
//			while (rs.next()) {
//				for(Client client : Hotel.getLesClients()) {
//					if (client.getId() == id)  {
//						cl = client;
//					}
//				}	
//			}
//			return cl;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//	public static TypeChambre findTypeChambre(int id) {
//		TypeChambre tc = null;
//		for(TypeChambre c : Initialisation.recupererTypeChambre()) {
//			if (c.getId() == id) tc = c;
//		}	
//		return tc;
//	}
//	public static TAXES findTaxes(double id) {
//		TAXES t = null;
//		if (id == TAXES.LOW.getTaxe()) t = TAXES.LOW;
//		if (id == TAXES.MEDIUM.getTaxe()) t = TAXES.MEDIUM;
//		if (id == TAXES.HIGH.getTaxe()) t = TAXES.HIGH;
//		return t;
//	}
//	public static List<TypeChambre> recupererTypeChambre() {
//		List<TypeChambre> lesTypeChambre = new ArrayList<TypeChambre>();
//		ResultSet rs = Connection.getResultSetSQL(reqTypeChambre);
//		try {
//			while (rs.next()) {
//				lesTypeChambre.add(new TypeChambre(rs.getString("label"), rs.getInt("price"), findTaxes(rs.getDouble("taxes")), rs.getInt("nbPlaces")));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lesTypeChambre;
//	}
//	public static ETAT_CHAMBRE findEtatChambre(String id) {
//		ETAT_CHAMBRE t = null;
//		if (id == ETAT_CHAMBRE.SALE.getString()) t = ETAT_CHAMBRE.SALE;
//		if (id == ETAT_CHAMBRE.PROPRE.getString()) t = ETAT_CHAMBRE.PROPRE;
//		return t;
//	}
//	
//	
//	public static List<Client> recupererClients() {
//		List<Client> lesClients = new ArrayList<Client>();
//		ResultSet rs = Connection.getResultSetSQL(reqClients);
//		try {
//			while (rs.next()) {
//				Client cl = new Client(rs.getString("firstname"), rs.getString("lastname"), rs.getString("adress"), rs.getString("postal_code"), rs.getString("tel"));
//				//cl.getId();
//				lesClients.add(cl);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lesClients;
//	}
//	public static List<Chambre> recupererChambres() {
//		List<Chambre> lesChambres = new ArrayList<Chambre>();
//		ResultSet rs = Connection.getResultSetSQL(reqChambres);
//		try {
//			while (rs.next()) {
//				
//				lesChambres.add(new Chambre(findTypeChambre( rs.getInt("id_RoomType")), rs.getString("label"), findEtatChambre(rs.getString("status")), (rs.getInt("isAvailable") == 1) ? true : false ));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lesChambres;
//	}
//	public static List<ReservationChambre> recupererReservationsChambres() {
//		List<ReservationChambre> lesRChambres = new ArrayList<ReservationChambre>();
//		ResultSet rs = Connection.getResultSetSQL(reqReservationsChambres);
//		try {
//			while (rs.next()) {
//				lesRChambres.add(new ReservationChambre(findClient(rs.getInt("id_Client")), rs.getDate("startDate"), rs.getDate("endDate")));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lesRChambres;
//	}
//	
//	
	
	
}