package items;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String CP;
	private String tel;
	private int age;
	private Boolean isExternal;
	
	public Client(String nom, String prenom, String adresse, String cP, String tel, int age) { //Client interne
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.CP = cP;
		this.tel = tel;
		this.age = age;
		this.isExternal = false;
	}
	
	public Client(String nom, String prenom, String tel) { //Client externe
		super();
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
	public int getAge() {
		return age;
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
	public void setAge(int age) {
		this.age = age;
	}
	public void setIsExternal(Boolean isExternal) {
		this.isExternal = isExternal;
	}
	
	
	

}
