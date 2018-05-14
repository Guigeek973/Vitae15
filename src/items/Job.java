package items;

import java.util.List;

import items.Job;

public class Job {
	private int id;
	private String libelle;
	private Service service;
	private List<Permission> permission;
	
	public Job(String libelle, Service service, List<Permission> permission) {
		super();
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
	public List<Permission> getPermission() {
		return permission;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	
	
}