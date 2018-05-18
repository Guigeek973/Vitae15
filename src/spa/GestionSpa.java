package spa;

import java.util.Date;
import java.util.List;

public class GestionSpa {
	private List<PrestationSpa> lesPrestations;

	public GestionSpa(List<PrestationSpa> lesPrestations) {
		super();
		this.lesPrestations = lesPrestations;
	}

	public List<PrestationSpa> getLesPrestations() {
		return lesPrestations;
	}

	public void setLesPrestations(List<PrestationSpa> lesPrestations) {
		this.lesPrestations = lesPrestations;
	}
	
	public void addPrestation(String libelle, double prix, Date duree) {
		
	}
	public void deletePrestation(PrestationSpa p) {
		
	}
	public void modifierPrestation(PrestationSpa p, String libelle, double prix, Date duree) {
		
	}
	public PrestationSpa getPrestation(int id) {
		return null;
	}
}
