package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import views.AccueilController;
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
	     * Shows the person overview inside the root layout.
	     */
	  

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
