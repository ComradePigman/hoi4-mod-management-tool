package mmt.comradepigman.pattern;

import java.util.ArrayList;
import java.util.List;

public class PGroup extends PatternComponent {

    private final List<PatternComponent> childComponents = new ArrayList<>();

    private final String gName; // g : Group

    public PGroup(String groupName) {
	this.gName = groupName;
    }

    @Override
    public String parse(int indent) {
	String out = SEPARATOR + this.createIndent(indent) + this.gName + " = {";

	final StringBuilder bld = new StringBuilder();
	for (final PatternComponent childComps : this.childComponents) {
	    bld.append(childComps.parse(indent + 1));
	}
	out = out + bld.toString() + SEPARATOR + this.createIndent(indent) + "}";
	return out;
    }

    @Override
    public void add(PatternComponent comp) {
	this.childComponents.add(comp);
    }

    @Override
    public void remove(PatternComponent comp) {
	this.childComponents.remove(comp);
    }

    @Override
    public PatternComponent getChild(int index) {
	return this.childComponents.get(index);
    }
}
