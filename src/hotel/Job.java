package hotel;

import java.util.List;

import hotel.Job;
import main.Connection;

public class Job {
	private int id;
	private String libelle;
	private Service service;
	private Permission permission;
	
	public Job(int id, String libelle, Service service, Permission permission) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.service = service;
		this.permission = permission;
	}
	
	public int getId() {
		return id;
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
