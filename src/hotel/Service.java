package hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import main.Connection;

public class Service {
	private int id;
	private String nom;
	private List<Personnel> lesEmployes;
	
	public Service(String nom, List<Personnel> lesEmployes) {
		super();
		this.nom = nom;
		this.lesEmployes = lesEmployes;
	}
	

	public int getId() {
		int id = 0;
		ResultSet rs = Connection.getResultSetSQL(
				"SELECT id FROM servicejob"
				+ " WHERE label = " + this.nom );
			
		try {
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setId(id);
		return this.id;
	}
	public String getNom() {
		return nom;
	}
	public List<Personnel> getLesEmployes() {
		return lesEmployes;
	}
	
	
	public void setNom(String nom) {
		
		
		if(this.nom != nom) 
		{
			this.nom = nom;
			Connection.execSQL("UPDATE servicejob SET laber = '" + this.nom + "'");
		}
	}
	public void setLesEmployes(List<Personnel> lesEmployes) {
		this.lesEmployes = lesEmployes;
	}
	
	
	
}
