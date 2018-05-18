package hotel;

import java.util.Hashtable;

import hotel.Job;
import main.Connection;

public class Personnel {
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private Job job;
	private Hashtable<String,Boolean> joursTravail;
	
	public Personnel(int id, String nom, String prenom, String login, String password) {
		super();
		this.id = id;
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

	
	public void setNom(String nom) {
		if (this.nom != nom) {
			this.nom = nom;
			Connection.execSQL("UPDATE staff SET firstname = '" + this.nom + "'");
		}
	}
	public void setPrenom(String prenom) {
		if (this.prenom != prenom) {
			this.prenom = prenom;
			Connection.execSQL("UPDATE staff SET lastname = '" + this.prenom + "'");
		}
	}
	public void setLogin(String login) {
		if (this.login != login) {
			this.login = login;
			Connection.execSQL("UPDATE staff SET login = '" + this.login + "'");
		}
	}
	public void setPassword(String password) {
		if (this.password != password) {
			this.password = password;
			Connection.execSQL("UPDATE staff SET password = '" + this.password + "'");
		}
	}
	public void setJob(Job job) {
		if (this.job != job) {
			this.job = job;
			Connection.execSQL("UPDATE staff SET id_Job = '" + this.job.getId() + "'");
		}
	}
	
	//TODO : PAS DE TABLE BD POUR STOCKER JOURS TRAVAIL
	public void setJoursTravail(Hashtable<String,Boolean> joursTravail) {
		this.joursTravail = joursTravail;
	}
	
	
}
