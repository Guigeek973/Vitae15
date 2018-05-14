package hotel;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String CP;
	private String tel;
	private Boolean isExternal;
	
	public Client(int id, String nom, String prenom, String adresse, String cP, String tel) { //Client interne
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.CP = cP;
		this.tel = tel;
		this.isExternal = false;
	}
	
	public Client(int id, String nom, String prenom, String tel) { //Client externe
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.isExternal = true;
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
	public String getAdresse() {
		return adresse;
	}
	public String getCP() {
		return CP;
	}
	public String getTel() {
		return tel;
	}
	public Boolean getIsExternal() {
		return isExternal;
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
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setCP(String cP) {
		CP = cP;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setIsExternal(Boolean isExternal) {
		this.isExternal = isExternal;
	}
	
	
	

}
