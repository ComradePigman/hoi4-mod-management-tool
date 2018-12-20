package mmt.comradepigman.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.VBox;
import mmt.comradepigman.components.CAutonomy;
import mmt.comradepigman.components.ParsableComponent;

public class ECountries extends VBox {

    private final List<ParsableComponent> childComponents = new ArrayList<>();

    public ECountries() {
	this.childComponents.add(new CAutonomy());
    }
}
