package mmt.comradepigman.gui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mmt.comradepigman.main.Main;
import mmt.comradepigman.main.ProjectLoader;

public class AEditor extends Stage implements ANavigable {

    public BorderPane root = new BorderPane();

    public ANavigation nav = new ANavigation(this);

    public AEditor() {

	this.setTitle("MMT - Projecteditor");

	root.setLeft(nav);

	EIdeologies mainpane = new EIdeologies(Main.getActiveProject().getIdeologies());
	root.getChildren().add(mainpane);

	final Label label = new Label(Main.getActiveProject().getPName());
	root.getChildren().add(label);

	final Button btnSave = new Button();
	btnSave.setText("SAVE!!!!!");
	btnSave.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		ProjectLoader.saveProject(Main.getActiveProject());
	    }
	});
	root.getChildren().add(btnSave);

	final Button btnConvert = new Button();
	btnConvert.setText("Generate Modfiles");
	btnConvert.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		Main.getActiveProject().generateContent();
	    }
	});
	root.setBottom(btnConvert);

	final Scene scene = new Scene(root, 1000, 500);

	File f = new File(System.getProperty("user.dir") + "/res/stylesheet.css");
	scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));

	this.setScene(scene);
    }

    @Override
    public void changeContent(Node newContent) {
	root.setCenter(newContent);
    }
}
