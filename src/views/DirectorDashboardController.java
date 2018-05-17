package views;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Connection;

public class DirectorDashboardController {

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
	     * Called when the user clicks cancel.
	     */
	    @FXML
	    private void handleCancel() {
	        primaryStage.close();
	    }


}
