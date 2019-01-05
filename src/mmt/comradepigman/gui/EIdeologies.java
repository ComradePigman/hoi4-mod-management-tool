package mmt.comradepigman.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mmt.comradepigman.components.GIdeology;
import mmt.comradepigman.components.GLIdeologies;
import mmt.comradepigman.components.GParsable;

public class EIdeologies extends VBox {

    public GLIdeologies dataReference;

    public EIdeologies(GLIdeologies data) {
	this.dataReference = data;
	this.init();
    }

    public void init() {

	for (GParsable component : dataReference.getComponents()) {
	    GIdeology ideology = (GIdeology) component;
	    this.addContent(ideology);
	}

	final Button btnSave = new Button();
	btnSave.setText("New");
	btnSave.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		GIdeology ideo = new GIdeology("Some name");

		dataReference.getComponents().add(ideo);
		EIdeologies.this.addContent(ideo);
	    }
	});
	this.getChildren().add(btnSave);

    }

    private void addContent(GIdeology ideology) {
	HBox iBox = new HBox();
	iBox.getStyleClass().add("multiple-content-pane");

	Label name = new Label(ideology.getEName());
	iBox.getChildren().add(name);

	this.getChildren().add(iBox);
    }
}
