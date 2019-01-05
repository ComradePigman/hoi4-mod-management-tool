package mmt.comradepigman.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mmt.comradepigman.components.CParty;
import mmt.comradepigman.components.CPolitics;

public class EPolitics extends VBox {

	public EPolitics() {
		final Button btn = new Button();
		btn.setText("Add");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				EPolitics.this.addItem(null, null);
			}
		});
		this.getChildren().add(btn);
	}

	public void addItem(CParty party, Integer popularity) {

		final VBox mContainer = new VBox();

		final HBox pContainer = new HBox();
		final VBox cPHolder = new VBox();

		final Label cPLabel = new Label("Party");
		final TextField cPField = new TextField();

		cPHolder.getChildren().add(cPLabel);
		cPHolder.getChildren().add(cPField);

		pContainer.getChildren().add(cPHolder);

		mContainer.getChildren().add(pContainer);

		this.getChildren().add(0, mContainer);
	}

	public void addItem(CPolitics cPolitics) {
		// TODO Auto-generated method stub

	}

}
