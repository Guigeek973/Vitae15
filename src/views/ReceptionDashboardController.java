package views;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class ReceptionDashboardController {
	
	private Stage primaryStage;
    private boolean okClicked = false;

	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
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
    
    /**
     * Called when the user clicks Restaurant.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToPriseReservation() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/ReceptionDashboardReservation.fxml"));
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
     * Called when the user clicks Restaurant.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToTicketsFactures() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/ReceptionDashboardFactures.fxml"));
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
     * Called when the user clicks Restaurant.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToRoomService() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/ReceptionDashboardRoomServ.fxml"));
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
     * Called when the user clicks Restaurant.
     * @return 
     * @throws IOException 
     */
    @FXML
    private boolean goToReservationChambre() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/ReceptionDashboardReservationChambre.fxml"));
		Pane rootLayout;
		try {
			rootLayout = (Pane) loader.load();
			Scene scene = new Scene(rootLayout);
			ReceptionDashboardReservationChambreController controller = loader.getController();
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
    private boolean goToReservationSpa() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/views/ReceptionDashboardReservationSpa.fxml"));
		Pane rootLayout;
		try {
			rootLayout = (Pane) loader.load();
			Scene scene = new Scene(rootLayout);
			ReceptionDashboardReservationChambreController controller = loader.getController();
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
