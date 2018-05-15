package views;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Connection;

public class AccueilController {
	@FXML
    private TextField nom_de_compte;
    @FXML
    private TextField password_field;

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
     */
    @FXML
    private boolean handleOk() {
        if (isInputValid()) {
            //se_connecter à la BDD
        	//nom_de_compte.getText()
        	//password_field.getText()
        	ResultSet rs = Connection.getResultSetSQL("SELECT password FROM Eemploye WHERE login =" + nom_de_compte.getText());
        	try {
				if (password_field.getText() == rs.getString(0)) {
		        	ResultSet rs1 = Connection.getResultSetSQL("SELECT Service.label FROM Staff "
		        			+ "JOIN Job ON Staff.id = Job.id"
		        			+ "JOIN ServiceJob ON Job.id_ServiceJob = ServiceJob.id");
		        	FXMLLoader loader = new FXMLLoader();
					switch (rs1.getString(0)) {
						case "Restaurant":
							loader.setLocation(getClass().getResource("/views/RestaurantDashboard.fxml"));
							Pane rootLayout;
							try {
								rootLayout = (Pane) loader.load();
								Scene scene = new Scene(rootLayout);
								RestaurantDashboardController controller = loader.getController();
						        controller.setStage(this.primaryStage);
						        loader.setController(controller);
						        primaryStage.setScene(scene);
								primaryStage.show();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "Maintenance":
							loader.setLocation(getClass().getResource("/views/MaintenanceDashboard.fxml"));
							break;
						case "Spa":
							loader.setLocation(getClass().getResource("/views/ReceptionDashboard.fxml"));
							break;
						case "Reception":
							loader.setLocation(getClass().getResource("/views/ReceptionDashboard.fxml"));
							break;
						case "Hebergement":
							loader.setLocation(getClass().getResource("/views/Hebergement.fxml"));
							break;
						case "Direction":
							loader.setLocation(getClass().getResource("/views/DirectorDashboard.fxml"));
							break;
						default:
							break;
					}
		        	
					primaryStage.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            okClicked = true;
            primaryStage.close();
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

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nom_de_compte.getText() == null || nom_de_compte.getText().length() == 0) {
            errorMessage += "No valid login!\n";
        }
        if (password_field.getText() == null || password_field.getText().length() == 0) {
            errorMessage += "No valid password!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(primaryStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
