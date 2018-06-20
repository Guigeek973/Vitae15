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
import java.util.List;
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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.Connection;
import main.Initialisation;
import maintenance_etages.ReservationChambre;

import java.time.LocalDate;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ReceptionDashboardReservationChambreController {

	@FXML
	private JFXTreeTableView<Model_ReservationChambre> reservationChambreTable;
	@FXML
	private JFXTreeTableColumn<Model_ReservationChambre, String> id_ReservationColumn;
	@FXML
	private JFXTreeTableColumn<Model_ReservationChambre, String> firstNameColumn;
	@FXML
	private JFXTreeTableColumn<Model_ReservationChambre, String> lastNameColumn;
	@FXML
	private JFXTreeTableColumn<Model_ReservationChambre, Date> startDateColumn;
	@FXML
	private JFXTreeTableColumn<Model_ReservationChambre, Date> endDateColumn;
	
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
    
    private ObservableList<Model_ReservationChambre> data;

	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	 // Initialize the ReservationChambre table with the two columns.
    	setupTableView();
    }
    
    
    private <T> void setupCellValueFactory(JFXTreeTableColumn<Model_ReservationChambre, T> column, Function<Model_ReservationChambre, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<Model_ReservationChambre, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    
	private void setupTableView() {
		setupCellValueFactory(id_ReservationColumn, Model_ReservationChambre::id_ReservationProperty);
        setupCellValueFactory(firstNameColumn, Model_ReservationChambre::firstNameProperty);
        setupCellValueFactory(lastNameColumn, Model_ReservationChambre::lastNameProperty);
        setupCellValueFactory(startDateColumn, Model_ReservationChambre::startDateProperty);
        setupCellValueFactory(endDateColumn, Model_ReservationChambre::endDateProperty);

        // add editors
        id_ReservationColumn.setCellFactory((TreeTableColumn<Model_ReservationChambre, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
//        Callback<TreeTableColumn<Object, String>, TreeTableCell<Object, String>> defaultCellFactory = TextFieldTreeTableCell.forTreeTableColumn() ;
//        id_ReservationColumn.setCellFactory(c -> {
//            TreeTableCell<Object, String> cell = defaultCellFactory.;
//            cell.indexProperty().addListener((obs, oldIndex, newIndex) -> {
//                if (newIndex.intValue() >= 0) {
//                    TreeItem<Object> item = cell.getTreeTableView().getTreeItem(newIndex.intValue());
//                    boolean canEdit = item != null && item.getValue() instanceof Model_ReservationChambre ;
//                    cell.setEditable(canEdit);
//                } else {
//                    cell.setEditable(false);
//                }
//            });
//            return cell ;
//        });
        firstNameColumn.setCellFactory((TreeTableColumn<Model_ReservationChambre, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        lastNameColumn.setCellFactory((TreeTableColumn<Model_ReservationChambre, String> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        lastNameColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<Model_ReservationChambre, String> t) -> {
            ((Model_ReservationChambre) t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue()).lastName.set(t.getNewValue());
//            //TODO : modification BD
//            String id = t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().id_Reservation.getValue();
//            String req = "SELECT id_Client FROM reservationroom WHERE id_Reservation='"+ id + "'";
//            ResultSet rs = Connection.getResultSetSQL(req);
//            int idClient = 0;
//            try {
//				idClient = rs.getInt("id_Client");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            String req1 = "UPDATE client SET lastname='" + t.getNewValue() + "' WHERE id='"+ idClient + "'";
//            Connection.execSQL(req1);
            
        });
        startDateColumn.setCellFactory((TreeTableColumn<Model_ReservationChambre, Date> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        startDateColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<Model_ReservationChambre, Date> t) -> {
        	 t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().startDate.set(t.getNewValue());
        });
        endDateColumn.setCellFactory((TreeTableColumn<Model_ReservationChambre, Date> param) -> {
            return new GenericEditableTreeTableCell<>(
                new TextFieldEditorBuilder());
        });
        endDateColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<Model_ReservationChambre, Date> t) -> {
        	t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().endDate.set(t.getNewValue());
        });
        
        final ObservableList<Model_ReservationChambre> dummyData = generateDummyData(200);
        reservationChambreTable.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        reservationChambreTable.setShowRoot(false);
        reservationChambreTable.setEditable(true);
        reservationChambreTableCount.textProperty()
                                  .bind(Bindings.createStringBinding(() -> PREFIX + reservationChambreTable.getCurrentItemsCount() + POSTFIX,
                                		  reservationChambreTable.currentItemsCountProperty()));
        searchField.textProperty()
                    .addListener(setupSearchField(reservationChambreTable));
    }
    
    private ChangeListener<String> setupSearchField(final JFXTreeTableView<Model_ReservationChambre> tableView) {
    	DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return (o, oldVal, newVal) ->
            tableView.setPredicate(reservationChambreProp -> {
                final Model_ReservationChambre reservationChambre = reservationChambreProp.getValue();
                return reservationChambre.getFirstName().contains(newVal)
                    || reservationChambre.getLastName().contains(newVal)
                    || formatter.format(reservationChambre.getStartDate()).contains(newVal)
                	|| formatter.format(reservationChambre.getEndDate()).contains(newVal);
            });
            
    }

    private ObservableList<Model_ReservationChambre> generateDummyData(final int numberOfEntries) {
        final ObservableList<Model_ReservationChambre> dummyData = FXCollections.observableArrayList();
        	for(Model_ReservationChambre current : buildData()){
        		dummyData.add(current);
        	}
        return dummyData;
    }
    
    public ObservableList<Model_ReservationChambre> buildData(){        
        data = FXCollections.observableArrayList();
        //List<ReservationChambre> list = Initialisation.recupererReservationsChambres();
        //GET FROM SQL
        String query = "SELECT id_Reservation, firstname, lastname, startDate, endDate FROM reservationroom JOIN reservation ON id_Reservation = reservation.id JOIN client ON id_Client = client.id";
        ResultSet rs = Connection.getResultSetSQL(query);
        try {
			while (rs.next()) {
			    try {
			    	Model_ReservationChambre rc = new Model_ReservationChambre(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5)); 
			        rc.id_Reservation.set(Integer.toString(rs.getInt(1)));
			        rc.firstName.set(rs.getString(2));
					rc.lastName.set(rs.getString(3));
					rc.startDate.set(rs.getDate(4));
			        rc.endDate.set(rs.getDate(5));
			        data.add(rc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			      
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        for (ReservationChambre rs : listSQL) {
//        	Model_ReservationChambre rc = new Model_ReservationChambre(Integer.toString(rs.getIdReservation()), rs.getClient().getPrenom(), rs.getClient().getNom(), rs.getStartDate(), rs.getEndDate()); 
//            rc.id_Reservation.set(Integer.toString(rs.getIdReservation()));
//            rc.firstName.set(rs.getClient().getPrenom());
//            rc.lastName.set(rs.getClient().getNom());
//            rc.startDate.set(rs.getStartDate());
//            rc.endDate.set(rs.getEndDate());
//            data.add(rc);   
//        }
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
    
    
    
    
    public class Model_ReservationChambre extends RecursiveTreeObject<Model_ReservationChambre>{
    	private StringProperty id_Reservation;
    	private StringProperty firstName;
        private StringProperty lastName;
        private ObjectProperty<Date> startDate;
        private ObjectProperty<Date> endDate;
        
    	
    	public Model_ReservationChambre(String id_Reservation, String firstName, String lastName, Date startDate, Date endDate) {
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

