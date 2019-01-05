package mmt.comradepigman.gui;

import javafx.scene.layout.VBox;
import mmt.comradepigman.main.Main;

public class ANavigation extends VBox {

    private final ANavigable navOf;

    public ANavigation(ANavigable navOf) {

	this.navOf = navOf;
	this.getChildren()
		.add(new ANavitem(this, "Ideologies", new EIdeologies(Main.getActiveProject().getIdeologies())));
    }

    public ANavigable getNavOf() {
	return navOf;
    }

}
