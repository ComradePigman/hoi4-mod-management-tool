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

	// mContainer.getChildren().add(lContainer);

	this.getChildren().add(0, mContainer);

	/*
	 * final HBox aBox = new HBox();
	 * 
	 * final TitledPane tp = new TitledPane();
	 * 
	 * tp.setText("My Titled Pane"); tp.setContent(new Button("Button"));
	 * 
	 * aBox.getChildren().add(tp);
	 * 
	 * final Label cLeaderLabel = new Label("Leader Name"); final TextField
	 * cLeaderField = new TextField();
	 * 
	 * aBox.getChildren().add(cLeaderLabel); aBox.getChildren().add(cLeaderField);
	 * 
	 * final VBox vBox = new VBox();
	 * 
	 * final Label cNameLabel = new Label("Party Name"); final TextField cNameField
	 * = new TextField();
	 * 
	 * vBox.getChildren().add(cNameLabel); vBox.getChildren().add(cNameField);
	 * 
	 * final Label cPopLabel = new Label("Popularity"); final TextField cPopField =
	 * new TextField();
	 * 
	 * vBox.getChildren().add(cPopLabel); vBox.getChildren().add(cPopField);
	 * 
	 * if (party != null) { cLeaderField.setText(party.getLeader().getName());
	 * cNameField.setText(party.getEName());
	 * cPopField.setText(popularity.toString()); }
	 * 
	 * aBox.getChildren().add(vBox);
	 * 
	 * final Button btn = new Button(); btn.setText("Remove"); btn.setOnAction(new
	 * EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent event) {
	 * EPolitics.this.getChildren().remove(aBox); } }); aBox.getChildren().add(btn);
	 * 
	 * this.getChildren().add(0, aBox);
	 */
    }

    public void addItem(CPolitics cPolitics) {
	// TODO Auto-generated method stub

    }

}
