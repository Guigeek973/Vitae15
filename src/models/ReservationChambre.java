package models;

import java.time.LocalDate;
import java.util.Date;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.Connection;

public class ReservationChambre extends RecursiveTreeObject<ReservationChambre>{
	private IntegerProperty id;
	private IntegerProperty id_Reservation;
	private StringProperty firstName;
    private StringProperty lastName;
    private ObjectProperty<Date> startDate;
    private ObjectProperty<Date> endDate;
    
	
	public ReservationChambre(String firstName, String lastName, Date startDate, Date endDate) {
		this.firstName = new SimpleStringProperty(firstName);
	    this.lastName = new SimpleStringProperty(lastName);
	    this.startDate = new SimpleObjectProperty<Date>(startDate);
	    this.endDate = new SimpleObjectProperty<Date>(endDate);
	}

	public int getId() {
		return id.get();
	}
	public int getId_Reservation() {
		return id_Reservation.get();
	}
	public void setId(int id) {
		this.id.set(id);
	}
	public void setId_Reservation(int id_Reservation) {
		this.id_Reservation.set(id_Reservation);
	}

	public String getFirstName() {
		return firstName.get();
	}
	public String getLastName() {
		return lastName.get();
	}
	public Date getStartDate() {
		return startDate.get();
	}
	public Date getEndDate() {
		return endDate.get();
	}
	
	public void setFirstName(String prenom) {
		this.firstName.set(prenom);
	}
	public void setLastName(String nom) {
		this.lastName.set(nom);
	}
	public void setStartDate(Date startDate) {
		this.startDate.set(startDate);
	}
	public void setEndDate(Date endDate) {
		this.endDate.set(endDate);
	}
	
	public void setFirstNameSQL(StringProperty firstName) {
		if (this.firstName != firstName) {
			this.firstName = firstName;
			Connection.execSQL("UPDATE client SET firstname = '" + this.firstName + "' WHERE id IN(SELECT id_Client FROM reservationroom WHERE id_Reservation=" + this.id_Reservation + "");
		}
	}
	public void setLastNameSQL(StringProperty lastName) {
		if (this.lastName != lastName) {
			this.lastName = lastName;
			Connection.execSQL("UPDATE client SET lastname = '" + this.lastName + "'WHERE id IN(SELECT id_Client FROM reservationroom WHERE id_Reservation=" + this.id_Reservation + "");
		}
	}
	public void setStartDateSQL(ObjectProperty<Date> startDate) {
		if (this.startDate != startDate) {
			this.startDate = startDate;
			Connection.execSQL("UPDATE reservation SET startDate = '" + this.startDate + "' WHERE id=" + this.id_Reservation + "");
		}
	}
	public void setEndDateSQL(ObjectProperty<Date> endDate) {
		if (this.endDate != endDate) {
			this.endDate = endDate;
			Connection.execSQL("UPDATE reservationroom SET endDate = '" + this.endDate + "' WHERE id_Reservation=" + this.id_Reservation + "");
		}
	}
	

	public StringProperty firstNameProperty() {
		return firstName;
	}
	public StringProperty lastNameProperty() {
		return lastName;
	}
	public ObjectProperty<Date> startDateProperty() {
		return startDate;
	}
	public ObjectProperty<Date> endDateProperty() {
		return endDate;
	}
	public IntegerProperty idProperty() {
		return id;
	}
	public IntegerProperty id_ReservationProperty() {
		return id_Reservation;
	}
	

	
}

