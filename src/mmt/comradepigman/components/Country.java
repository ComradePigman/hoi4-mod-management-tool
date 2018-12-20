package mmt.comradepigman.components;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import mmt.comradepigman.pattern.PatternComponent;

public class Country implements GParsable, Renderable {

    private final CAutonomy autonomyHandler = new CAutonomy();
    private final CPolitics politicsHandler = new CPolitics();

    @Override
    public PatternComponent parse() {
	return this.autonomyHandler.parse();
    }

    public CAutonomy getAutonomyHandler() {
	return this.autonomyHandler;
    }

    public CPolitics getPoliticsHandler() {
	return this.politicsHandler;
    }

    @Override
    public Node init() {
	final VBox container = new VBox();
	container.getChildren().add(this.autonomyHandler.init());
	container.getChildren().add(this.politicsHandler.init());
	return container;
    }

}
