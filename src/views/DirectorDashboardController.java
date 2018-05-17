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
	     * Called when the user clicks ok.
	     * @return 
	     * @throws IOException 
	     */
	    @FXML
	    private boolean handleOk() throws IOException {
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
