package hotel;

import java.util.ArrayList;
import java.util.List;

import main.Connection;

public class Permission {
	private int id;
	private Boolean create;
	private Boolean read;
	private Boolean update;
	private Boolean delete;
	
	public Permission(int id, Boolean create, Boolean read, Boolean update, Boolean delete) {
		super();
		this.id = id;
		this.create = create;
		this.read = read;
		this.update = update;
		this.delete = delete;
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

	
	public void setCreate(Boolean create) {
		if (this.create != create) {
			this.create = create;
			Connection.execSQL("UPDATE typepermission SET creating = " + this.create);
		}
	}
	public void setRead(Boolean read) {
		if (this.read != read) {
			this.read = read;
			Connection.execSQL("UPDATE typepermission SET reading = " + this.read);
		}
	}
	public void setUpdate(Boolean update) {
		if (this.update != update) {
			this.update = update;
			Connection.execSQL("UPDATE typepermission SET updating = " + this.update);
		}
	}
	public void setDelete(Boolean delete) {
		if (this.delete != delete) {
			this.delete = delete;
			Connection.execSQL("UPDATE typepermission SET deleting = " + this.delete);
		}
	}
	
	
	public void modifierPermissions(Boolean c, Boolean r, Boolean u, Boolean d) {
		this.setCreate(c);
		this.setRead(r);
		this.setUpdate(u);
		this.setDelete(d);
	}
	public List<Boolean> getCRUD() {
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		list.add(this.create);
		list.add(this.read);
		list.add(this.update);
		list.add(this.delete);
		return list;
	}
}
