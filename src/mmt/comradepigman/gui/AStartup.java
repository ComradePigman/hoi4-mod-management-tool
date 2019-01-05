package mmt.comradepigman.gui;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mmt.comradepigman.localization.Localization;
import mmt.comradepigman.main.Main;
import mmt.comradepigman.main.ProjectLoader;

public class AStartup extends AController {

    private static final String FXML_RESOURCE = "AStartup.fxml";

    public static Stage createInstance() {
	try {
	    Stage stage = new Stage();
	    stage.setTitle("MMT - Select your Project");

	    File file = new File(System.getProperty("user.dir") + "/res/" + FXML_RESOURCE);

	    FXMLLoader loader = new FXMLLoader(file.toURI().toURL(), Localization.getBundle());
	    Parent root = (Parent) loader.load();
	    AStartup controller = (AStartup) loader.getController();
	    controller.setStage(stage); // or what you want to do

	    final Scene scene = new Scene(root, 500, 400);
	    stage.setScene(scene);

	    return stage;
	} catch (IOException e) {
	    return null;
	}
    }

    @FXML
    private ImageView patreonImg;

    public AStartup() {
    }

    @FXML
    private void initialize() {
	File file = new File(System.getProperty("user.dir") + "/res/patreon-image.png");
	Image image = new Image(file.toURI().toString());
	patreonImg.setImage(image);
    }

    @FXML
    public void loadProject() {
	FileChooser fileChooser = new FileChooser();
	File file = fileChooser.showOpenDialog(stage);
	if (file != null && file.getName().contains(".mmt")) {
	    Main.setActiveProject(ProjectLoader.loadProject(file));
	    Main.startApplication();
	    stage.close();
	} else {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setHeaderText("Selected file not compatible!");
	    alert.setContentText("The selected file is either empty or does not match the requested format (.mmt)");
	    alert.showAndWait();
	}
    }

    @FXML
    public void createProject() {
	Stage dialog = ACreateProject.createInstance(null);

	dialog.initOwner(stage);
	dialog.initModality(Modality.APPLICATION_MODAL);
	dialog.showAndWait();

	Main.startApplication();
	this.stage.close();
    }
}
