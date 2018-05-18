package hotel;

import java.util.Date;

import main.Connection;

public class Ticket {
	private int id;
	private String titre;
	private String description;
	private STATUT_TICKET statut;
	private Date created_at;
	private Date modified_at;
	private Personnel personnelAffecte;
	private Service service;
	public enum STATUT_TICKET {
		ATTENTE,
		EN_COURS,
		VALIDE
	}
	public Ticket(int id, String titre, String description, STATUT_TICKET statut, Service service) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	public String getDescription() {
		return description;
	}
	public STATUT_TICKET getStatut() {
		return statut;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public Date getModified_at() {
		return modified_at;
	}
	public Personnel getPersonnelAffecte() {
		return personnelAffecte;
	}
	public Service getService() {
		return service;
	}

	
	public void setTitre(String titre) {
		
		if(this.titre != titre) 
		{
			this.titre = titre;
			Connection.execSQL("UPDATE ticket SET titre = '" + this.titre + "'");
		}
	}
	public void setDescription(String description) {
		
		if(this.description != description) 
		{
			this.description = description;
			Connection.execSQL("UPDATE ticket SET details = '" + this.description + "'");
		}
	}
	public void setStatut(STATUT_TICKET statut) {
		
		if(this.statut != statut) 
		{
			this.statut = statut;
			Connection.execSQL("UPDATE ticket SET statut = '" + this.statut + "'");
		}
	}
	public void setCreated_at(Date created_at) {
		
		if(this.created_at != created_at) 
		{
			this.created_at = created_at;
			Connection.execSQL("UPDATE ticket SET created_at = '" + this.created_at + "'");
		}
	}
	public void setModified_at(Date modified_at) {
		
		if(this.modified_at != modified_at) 
		{
			this.modified_at = modified_at;
			Connection.execSQL("UPDATE ticket SET modified_at = '" + this.modified_at + "'");
		}
	}
	public void setPersonnelAffecte(Personnel personnelAffecte) {
		
		if(this.personnelAffecte != personnelAffecte) 
		{
			this.personnelAffecte = personnelAffecte;
			Connection.execSQL("UPDATE ticket SET id_Staff = '" + this.personnelAffecte + "'");
		}
	}
	public void setService(Service service) {
		
		if(this.service != service) 
		{
			this.service = service;
			Connection.execSQL("UPDATE ticket SET id_ServiceJob = '" + this.service + "'");
		}
	}
	
	
}
