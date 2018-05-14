package items;

import java.util.Hashtable;

import items.Job;

public class Personnel {
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private Job job;
	private Hashtable<String,Boolean> joursTravail;
	
	public Personnel(String nom, String prenom, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public Job getJob() {
		return job;
	}
	public Hashtable<String,Boolean> getJoursTravail() {
		return joursTravail;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public void setJoursTravail(Hashtable<String,Boolean> joursTravail) {
		this.joursTravail = joursTravail;
	}
	
	
}
