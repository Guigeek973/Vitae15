package hotel;

import java.util.Date;

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
	public Ticket(String titre, String description, STATUT_TICKET statut, Service service) {
		super();
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
	public void setId(int id) {
		this.id = id;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatut(STATUT_TICKET statut) {
		this.statut = statut;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}
	public void setPersonnelAffecte(Personnel personnelAffecte) {
		this.personnelAffecte = personnelAffecte;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	
}
