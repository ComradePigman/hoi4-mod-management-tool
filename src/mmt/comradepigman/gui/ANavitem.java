package mmt.comradepigman.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ANavitem extends Button {

    public ANavitem(ANavigation parent, String dispText, Node objToOpen) {

	this.setText(dispText);
	this.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		parent.getNavOf().changeContent(objToOpen);
	    }
	});
    }
}
