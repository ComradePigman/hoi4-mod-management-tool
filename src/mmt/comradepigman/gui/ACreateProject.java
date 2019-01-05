package mmt.comradepigman.gui;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mmt.comradepigman.components.GameProject;
import mmt.comradepigman.localization.Localization;
import mmt.comradepigman.main.Main;

public class ACreateProject extends AController {

    private static final String FXML_RESOURCE = "ACreateProject.fxml";

    private boolean isNewMode = true;

    private GameProject dataReference;

    public boolean isNewMode() {
	return isNewMode;
    }

    public void setNewMode(boolean isNewMode) {
	this.isNewMode = isNewMode;
    }

    @FXML
    private Pane projectTags;

    @FXML
    private TextField projectTitle;

    @FXML
    private TextField projectFolder;

    public ACreateProject() {
    }

    public static Stage createInstance(GameProject project) {
	try {
	    Stage stage = new Stage();
	    stage.setTitle("MMT - Select your Project");

	    File file = new File(System.getProperty("user.dir") + "/res/" + FXML_RESOURCE);

	    FXMLLoader loader = new FXMLLoader(file.toURI().toURL(), Localization.getBundle());
	    Parent root = (Parent) loader.load();
	    ACreateProject controller = (ACreateProject) loader.getController();
	    controller.setStage(stage); // or what you want to do
	    controller.dataReference = project;

	    final Scene scene = new Scene(root, 500, 400);
	    stage.setScene(scene);

	    return stage;
	} catch (IOException e) {
	    return null;
	}
    }

    @FXML
    private void initialize() {
    }

    @FXML
    public void saveProject() {
	GameProject project;

	if (isNewMode) {
	    project = new GameProject();
	    project.setPName(projectTitle.getText());
	    project.setPFolder(projectFolder.getText());

	    Main.setActiveProject(project);
	    this.stage.close();
	} else {
	    // project = this.project;
	}
    }
}
