package hotel;

import java.util.List;

public class Permission {
	private int id;
	private Boolean create;
	private Boolean read;
	private Boolean update;
	private Boolean delete;
	private Service service;
	
	public Permission(int id, Boolean create, Boolean read, Boolean update, Boolean delete, Service service) {
		super();
		this.id = id;
		this.create = create;
		this.read = read;
		this.update = update;
		this.delete = delete;
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public Boolean getCreate() {
		return create;
	}
	public Boolean getRead() {
		return read;
	}
	public Boolean getUpdate() {
		return update;
	}
	public Boolean getDelete() {
		return delete;
	}
	public Service getService() {
		return service;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCreate(Boolean create) {
		this.create = create;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	public void setUpdate(Boolean update) {
		this.update = update;
	}
	public void setDelete(Boolean delete) {
		this.delete = delete;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	
	public void modifierPermissions() {
		
	}
	public List<Boolean> getCRUD() {
		return null;
	}
}
