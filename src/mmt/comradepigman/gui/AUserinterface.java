package mmt.comradepigman.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mmt.comradepigman.components.AutonomousState;
import mmt.comradepigman.components.CIdeology;
import mmt.comradepigman.components.CLeader;
import mmt.comradepigman.components.CParty;
import mmt.comradepigman.components.Country;

public class AUserinterface extends Application {
    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
	primaryStage.setTitle("Hello World!");
	final Button btn = new Button();
	btn.setText("Say 'Hello World'");
	btn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
		System.out.println("Hello World!");
	    }
	});

	final BorderPane root = new BorderPane();
	final Country autonomy = new Country();
	autonomy.getAutonomyHandler().addAutonomy("USA", AutonomousState.INTEGRATED_PUPPET);
	autonomy.getPoliticsHandler().setParty(new CParty(new CIdeology("liberalism"), new CLeader("Urs")), 50);
	autonomy.getPoliticsHandler().setParty(new CParty(new CIdeology("conservatism"), new CLeader("Urs")), 50);

	System.out.println(autonomy.parse());

	root.setCenter(autonomy.init());

	final Scene scene = new Scene(root, 500, 400);

	scene.getStylesheets().add("stylesheet.css");

	primaryStage.setScene(scene);
	primaryStage.show();
    }
}
