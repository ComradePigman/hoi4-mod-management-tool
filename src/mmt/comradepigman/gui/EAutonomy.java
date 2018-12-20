package mmt.comradepigman.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mmt.comradepigman.components.AutonomousState;

public class EAutonomy extends VBox {

    public EAutonomy() {
	final Button btn = new Button();
	btn.setText("Add");
	btn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		EAutonomy.this.addItem(null, null);
	    }
	});

	this.getChildren().add(btn);
    }

    public void addItem(String countryTag, AutonomousState aState) {
	final HBox aBox = new HBox();

	final Label cTagLabel = new Label("Country-Tag:");
	final TextField cTagField = new TextField();
	cTagField.setText(countryTag);

	aBox.getChildren().add(cTagLabel);
	aBox.getChildren().add(cTagField);

	final ComboBox<AutonomousState> cbxAutonomousState = new ComboBox<>();
	cbxAutonomousState.getItems().setAll(AutonomousState.values());
	cbxAutonomousState.setValue(aState);

	aBox.getChildren().add(cbxAutonomousState);

	final Button btn = new Button();
	btn.setText("Remove");
	btn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		EAutonomy.this.getChildren().remove(aBox);
	    }
	});
	aBox.getChildren().add(btn);

	this.getChildren().add(0, aBox);
    }
}
