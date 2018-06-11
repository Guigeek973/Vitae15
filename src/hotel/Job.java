package hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import hotel.Job;
import main.Connection;

public class Job {
	private int id;
	private String libelle;
	private Service service;
	private Permission permission;
	
	public Job(String libelle, Service service, Permission permission) {
		super();
		this.libelle = libelle;
		this.service = service;
		this.permission = permission;
	}
	
	public int getId() {
		int id = 0;
		ResultSet rs = Connection.getResultSetSQL(
				"SELECT id FROM job"
				+ " WHERE label = " + this.libelle 
				+ " AND id_ServiceJob = " + this.service.getId() 
				+ " AND id_TypePermission = " + this.permission.getId());
			
		try {
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setId(id);
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public Service getService() {
		return service;
	}
	public Permission getPermission() {
		return permission;
	}


	public void setLibelle(String libelle) {
		if (this.libelle != libelle) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE job SET label = '" + this.libelle + "'");
		}
	}
	public void setService(Service service) {
		if (this.service != service) {
			this.service = service;
			Connection.execSQL("UPDATE job SET id_ServiceJob = '" + this.service + "'");
		}
	}
	public void setPermission(Permission permission) {
		if (this.permission != permission) {
			this.permission = permission;
			Connection.execSQL("UPDATE job SET id_TypePermission = '" + this.permission + "'");
		}
	}
	
	
}
