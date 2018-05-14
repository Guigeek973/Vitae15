package direction;

import java.util.List;

import hotel.Job;
import hotel.Permission;
import hotel.Personnel;
import hotel.Service;

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
	
	public void addPersonnel(int id, String nom, String prenom, String login, String password) {
		
	}
	public void modifierPersonnel(Personnel p, String nom, String prenom, String login) {
		
	}
	public void modifierPersonnelPassword(Personnel p, String password) {
		
	}
	public void deletePersonnel(Personnel p) {
	
	}
	public void modifierDroits(Job job, List<Permission> permissions) {
		
	}
	public void affecterService(Service service, Job job) {
		
	}
	public void ajouterPersonnel(Personnel p) {
		
	}
	public Job getJob(int id) {
		return null;
	}
	public Service getService(int id) {
		return null;
	}
	public Personnel getPersonnel(int id) {
		return null;
	}
}
