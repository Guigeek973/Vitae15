package views;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.IntegerTextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import application.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Connection;
import models.ReservationChambre;

import java.time.LocalDate;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ReceptionDashboardReservationChambreController {

	@FXML
	private JFXTreeTableView<ReservationChambre> reservationChambreTable;
	@FXML
	private JFXTreeTableColumn<ReservationChambre, String> id_ReservationColumn;
	@FXML
	private JFXTreeTableColumn<ReservationChambre, String> firstNameColumn;
	@FXML
	private JFXTreeTableColumn<ReservationChambre, String> lastNameColumn;
	@FXML
	private JFXTreeTableColumn<ReservationChambre, Date> startDateColumn;
	@FXML
	private JFXTreeTableColumn<ReservationChambre, Date> endDateColumn;
	
	@FXML
	private Label id_Reservation;
	@FXML
	private Label firstName;
	@FXML
	private Label lastName;
	@FXML
	private Label startDate;
	@FXML
	private Label endDate;
    @FXML
    private Label reservationChambreTableCount;
    @FXML
    private Button reservationChambreTableAdd;
    @FXML
    private Button reservationChambreTableRemove;
    @FXML
    private JFXTextField searchField;
	
    
	private Stage primaryStage;
    private boolean okClicked = false;
    
    private static final String PREFIX = "( ";
    private static final String POSTFIX = " )";
    
    private ObservableList<ReservationChambre> data;

	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	 // Initialize the ReservationChambre table with the two columns.
    	setupTableView();
    }
    
    public void showReservationChambreOverview(ReservationChambre rc) {
    	DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	if (rc != null) {
    		firstName.setText(rc.getFirstName());
    		lastName.setText(rc.getLastName());
    		startDate.setText(formatter.format(rc.getStartDate()));
    		endDate.setText(formatter.format(rc.getEndDate()));
    	} else {
    		firstName.setText("");
    		lastName.setText("");
    		startDate.setText("");
    		endDate.setText("");
    	}
    }
    
    private void updateDataClient(String column, String newValue, String id) {
        String req = "UPDATE client SET "+column+" = ? WHERE id IN(SELECT id_Client FROM reservationroom WHERE id_Reservation = ? )";
    	PreparedStatement stmt = Connection.getPreparedStatement(req);
        try {
			stmt.setString(1, newValue);
			stmt.setString(2, id);
            stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void updateDataReservation(String column, String newValue, String id) {
        String req = "UPDATE reservationroom SET "+column+" = ? WHERE id_Reservation = ? ";
    	PreparedStatement stmt = Connection.getPreparedStatement(req);
        try {
			stmt.setString(1, newValue);
			stmt.setString(2, id);
            stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    private <T> void setupCellValueFactory(JFXTreeTableColumn<ReservationChambre, T> column, Function<ReservationChambre, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<ReservationChambre, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    
	private void setupTableView() {
		setupCellValueFactory(id_ReservationColumn, ReservationChambre::id_ReservationProperty);
        setupCellValueFactory(firstNameColumn, ReservationChambre::firstNameProperty);
        setupCellValueFactory(lastNameColumn, ReservationChambre::lastNameProperty);
        setupCellValueFactory(startDateColumn, ReservationChambre::startDateProperty);
        setupCellValueFactory(endDateColumn, ReservationChambre::endDateProperty);

        // add editors
        id_ReservationColumn.setCellFactory((TreeTableColumn<ReservationChambre, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        id_ReservationColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<ReservationChambre, String> t) -> {
            t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().id_Reservation.set(t.getNewValue());
            
        });
        firstNameColumn.setCellFactory((TreeTableColumn<ReservationChambre, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        firstNameColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<ReservationChambre, String> t) -> {
            t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().firstName.set(t.getNewValue());
            
        });
        lastNameColumn.setCellFactory((TreeTableColumn<ReservationChambre, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        lastNameColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<ReservationChambre, String> t) -> {
            ((ReservationChambre) t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue()).lastName.set(t.getNewValue());
            //TODO : modification BD
//            ReservationChambre rc = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue();
//            rc.setLastName(t.getNewValue());
//            updateDataClient("lastname", t.getNewValue(), rc.id_Reservation.getValue());
            
        });
        startDateColumn.setCellFactory((TreeTableColumn<ReservationChambre, Date> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        startDateColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<ReservationChambre, Date> t) -> {
        	 t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().startDate.set(t.getNewValue());
        });
        endDateColumn.setCellFactory((TreeTableColumn<ReservationChambre, Date> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        endDateColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<ReservationChambre, Date> t) -> {
        	t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().endDate.set(t.getNewValue());
        });
        
        final ObservableList<ReservationChambre> dummyData = generateDummyData(200);
        reservationChambreTable.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        reservationChambreTable.setShowRoot(false);
        reservationChambreTable.setEditable(true);
        reservationChambreTableCount.textProperty()
                                  .bind(Bindings.createStringBinding(() -> PREFIX + reservationChambreTable.getCurrentItemsCount() + POSTFIX,
                                		  reservationChambreTable.currentItemsCountProperty()));
        searchField.textProperty()
                    .addListener(setupSearchField(reservationChambreTable));
    }
    
    private ChangeListener<String> setupSearchField(final JFXTreeTableView<ReservationChambre> tableView) {
    	DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return (o, oldVal, newVal) ->
            tableView.setPredicate(reservationChambreProp -> {
                final ReservationChambre reservationChambre = reservationChambreProp.getValue();
                return reservationChambre.getFirstName().contains(newVal)
                    || reservationChambre.getLastName().contains(newVal)
                    || formatter.format(reservationChambre.getStartDate()).contains(newVal)
                	|| formatter.format(reservationChambre.getEndDate()).contains(newVal);
            });
            
    }

    private ObservableList<ReservationChambre> generateDummyData(final int numberOfEntries) {
        final ObservableList<ReservationChambre> dummyData = FXCollections.observableArrayList();
        	for(ReservationChambre current : buildData()){
        		dummyData.add(current);
        	}
        return dummyData;
    }
    
    public ObservableList<ReservationChambre> buildData(){        
        data = FXCollections.observableArrayList();
        try{      
            String SQL = "SELECT * FROM reservationroom JOIN reservation ON reservationroom.id_Reservation = reservation.id"
            		+ " JOIN client ON reservation.id_Client = client.id"
            		+ " ORDER BY startDate DESC";            
            ResultSet rs = Connection.getResultSetSQL(SQL); 
            while(rs.next()){
                ReservationChambre rc = new ReservationChambre(Integer.toString(rs.getInt("id_Reservation")), rs.getString("firstname"), rs.getString("lastname"), rs.getDate("startDate"), rs.getDate("endDate")); 
                rc.id_Reservation.set(Integer.toString(rs.getInt("id_Reservation")));
                rc.firstName.set(rs.getString("firstname"));
                rc.lastName.set(rs.getString("lastname"));
                rc.startDate.set(rs.getDate("startDate"));
                rc.endDate.set(rs.getDate("endDate"));
                data.add(rc);                  
            }
            //reservationChambreTable.setItems(data);
        }
        catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");            
        }
		return data;
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param primaryStage
     */
    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    
    
    
    public class ReservationChambre extends RecursiveTreeObject<ReservationChambre>{
    	private StringProperty id_Reservation;
    	private StringProperty firstName;
        private StringProperty lastName;
        private ObjectProperty<Date> startDate;
        private ObjectProperty<Date> endDate;
        
    	
    	public ReservationChambre(String id_Reservation, String firstName, String lastName, Date startDate, Date endDate) {
    		this.id_Reservation = new SimpleStringProperty(id_Reservation);
    		this.firstName = new SimpleStringProperty(firstName);
    	    this.lastName = new SimpleStringProperty(lastName);
    	    this.startDate = new SimpleObjectProperty<Date>(startDate);
    	    this.endDate = new SimpleObjectProperty<Date>(endDate);
    	}

    	public String getId_Reservation() {
    		return id_Reservation.get();
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
    	
    	public void setId_Reservation(String id) {
    		this.id_Reservation.set(id);
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

    	public StringProperty id_ReservationProperty() {
			return id_Reservation;
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
    }
    
    /**
     * Called when the user clicks Direction.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToDirection() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/DirectorDashboard.fxml"));
		Pane rootLayout;
		try {
			rootLayout = (Pane) loader.load();
			Scene scene = new Scene(rootLayout);
			DirectorDashboardController controller = loader.getController();
	        loader.setController(controller);
	        //primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        primaryStage.setScene(scene);
	        controller.setStage(primaryStage);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return okClicked;
    }
    
    /**
     * Called when the user clicks Hebergement.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToHebergement() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/Hebergement.fxml"));
		Pane rootLayout;
		try {
			rootLayout = (Pane) loader.load();
			Scene scene = new Scene(rootLayout);
			HebergementDashboardController controller = loader.getController();
	        loader.setController(controller);
	        //primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        primaryStage.setScene(scene);
	        controller.setStage(primaryStage);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return okClicked;
    }

    /**
     * Called when the user clicks Reception.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToReception() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/views/ReceptionDashboard.fxml"));
    	Pane rootLayout;
		try {
			rootLayout = (Pane) loader.load();
			Scene scene = new Scene(rootLayout);
			ReceptionDashboardController controller = loader.getController();
	        loader.setController(controller);
	        //primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        primaryStage.setScene(scene);
	        controller.setStage(primaryStage);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return okClicked;
    }
    
    /**
     * Called when the user clicks ok.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToMaintenance() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/views/MaintenanceDashboard.fxml"));
    	Pane rootLayout;
		try {
			rootLayout = (Pane) loader.load();
			Scene scene = new Scene(rootLayout);
			MaintenanceDashboardController controller = loader.getController();
	        loader.setController(controller);
	        //primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        primaryStage.setScene(scene);
	        controller.setStage(primaryStage);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return okClicked;
    }
    
    /**
     * Called when the user clicks Restaurant.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToRestaurant() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/RestaurantDashboard.fxml"));
		Pane rootLayout;
		try {
			rootLayout = (Pane) loader.load();
			Scene scene = new Scene(rootLayout);
			RestaurantDashboardController controller = loader.getController();
	        loader.setController(controller);
	        //primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        primaryStage.setScene(scene);
	        controller.setStage(primaryStage);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return okClicked;
    }
    
    
    
}

