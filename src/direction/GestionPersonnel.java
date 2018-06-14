package direction;

import java.util.List;

import hotel.Job;
import hotel.Permission;
import hotel.Personnel;
import hotel.Service;
import main.Connection;

public class GestionPersonnel {
	private List<Personnel> lePersonnel;
	private List<Job> lesJobs;
	private List<Service> lesServices;
	public GestionPersonnel(List<Personnel> lePersonnel, List<Job> lesJobs, List<Service> lesServices) {
		super();
		this.lePersonnel = lePersonnel;
		this.lesJobs = lesJobs;
		this.lesServices = lesServices;
	}
	public List<Personnel> getLePersonnel() {
		return lePersonnel;
	}
	public List<Job> getLesJobs() {
		return lesJobs;
	}
	public List<Service> getLesServices() {
		return lesServices;
	}
	public void setLePersonnel(List<Personnel> lePersonnel) {
		this.lePersonnel = lePersonnel;
	}
	public void setLesJobs(List<Job> lesJobs) {
		this.lesJobs = lesJobs;
	}
	public void setLesServices(List<Service> lesServices) {
		this.lesServices = lesServices;
	}
	
	public void createPersonnel(String nom, String prenom, String login, String password) {
		if (!nom.isEmpty() && !prenom.isEmpty() && !login.isEmpty() && !password.isEmpty()) {
			Personnel personnel = new Personnel(nom, prenom, login, password);
			Connection.execSQL("INSERT INTO staff(lastname, firstname, login, password) VALUES ('"+nom+"','"+prenom+"','"+login+"','"+password+"')");
			this.ajouterPersonnel(personnel);
		}
	}
	
	public void modifierPersonnel(Personnel personnel, String nom, String prenom, String login) {
		boolean isModified = false; // Sert à savoir si il y'a eu ou non une modification
		
		if (!personnel.getNom().equals(nom) && !nom.isEmpty()) {
			personnel.setNom(nom);
			isModified = true;
		}
		if (!personnel.getPrenom().equals(prenom) && !prenom.isEmpty()) {
			personnel.setPrenom(prenom);
			isModified = true;
		}
		if (!personnel.getLogin().equals(login) && !login.isEmpty()) {
			personnel.setLogin(login);
			isModified = true;
		}
		
		if (isModified) {
			Connection.execSQL("UPDATE staff SET lastname = '"+nom+"', firstname = '"+prenom+"', login = '"+login+"' "
							 + "WHERE id = "+personnel.getId());
		}
			
	}
	public void modifierPersonnelPassword(Personnel personnel, String password) {
		if (!password.isEmpty()) {
			personnel.setPassword(password);
		}
	}
	public void deletePersonnel(Personnel personnel) {
		this.lePersonnel.remove(personnel);
		Connection.execSQL("DELETE FROM staff WHERE id = " + personnel.getId());		
	}
	public void modifierDroits(Job job, List<Permission> permissions) {
//		for (Permission permission : permissions) {
//			job.setPermission(permission);
//		}
	}
	public void affecterService(Service service, Job job) {
		job.setService(service);
		Connection.execSQL("UPDATE job SET id_ServiceJob = "+service.getId()+" WHERE id = " + job.getId());
	}
	public void ajouterPersonnel(Personnel personnel) {
		this.lePersonnel.add(personnel);
	}
}
