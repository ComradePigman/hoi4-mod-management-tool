package mmt.comradepigman.components;

import java.util.HashMap;
import java.util.Map.Entry;

import javafx.scene.Node;
import mmt.comradepigman.gui.EAutonomy;
import mmt.comradepigman.pattern.PGroup;
import mmt.comradepigman.pattern.PIfElse;
import mmt.comradepigman.pattern.PStatement;
import mmt.comradepigman.pattern.PatternComponent;

public class CAutonomy implements GParsable, Renderable {

    private final HashMap<String, AutonomousState> autonomy = new HashMap<>();

    public void addAutonomy(String countryTag, AutonomousState aState) {
	this.autonomy.put(countryTag, aState);
    }

    @Override
    public Node init() {
	final EAutonomy component = new EAutonomy();

	for (final Entry<String, AutonomousState> aSet : this.autonomy.entrySet()) {
	    component.addItem(aSet.getKey(), aSet.getValue());
	}

	return component;
    }

    @Override
    public PatternComponent parse() {
	final PStatement aCondition = new PStatement("has_dlc", "\"Together for Victory\"");
	final PIfElse dGroup = new PIfElse(aCondition);

	for (final Entry<String, AutonomousState> aSet : this.autonomy.entrySet()) {
	    final PGroup aGroup = new PGroup("set_autonomy");
	    aGroup.add(new PStatement("target", aSet.getKey()));
	    aGroup.add(new PStatement("autonomous_state", aSet.getValue().getValue()));
	    dGroup.addElse(new PStatement("puppet", aSet.getKey()));
	    dGroup.add(aGroup);
	}

	return dGroup;
    }
}
