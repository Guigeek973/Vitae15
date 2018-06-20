package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.Model_ReservationChambre;
import models.Model_ReservationSpa;
import views.AccueilController;
import views.ReceptionDashboardController;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	    private Stage primaryStage;
	    private Pane rootLayout;
	    	    
	    @Override
	    public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("TomKhaKai Hotel");

	        initRootLayout();

	        //showPersonOverview();
	    }

	    /**
	     * Initializes the root layout.
	     * @return 
	     */
	    public boolean initRootLayout() {
	        // Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/views/Accueil.fxml"));
			try {
				rootLayout = (Pane) loader.load();
				Scene scene = new Scene(rootLayout);
				AccueilController controller = loader.getController();
		        controller.setStage(this.primaryStage);
		        loader.setController(controller);
		        primaryStage.setScene(scene);
				primaryStage.show();

		        return controller.isOkClicked();
		        
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
	    }
	    
	    /**
	     * Returns the main stage.
	     * @return
	     */
	    public Stage getPrimaryStage() {
	        return primaryStage;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	
	
}
