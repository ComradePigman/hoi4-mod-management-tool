package mmt.comradepigman.pattern;

import java.util.ArrayList;
import java.util.List;

public class PIfElse extends PDecorator {

    private final List<PatternComponent> ifComponents = new ArrayList<>();

    private final List<PatternComponent> elseComponents = new ArrayList<>();

    public PIfElse(PatternComponent component) {
	super(component);
    }

    @Override
    public String parse(int indent) {
	StringBuilder bld;

	String out = SEPARATOR + this.createIndent(indent) + "if = {";
	out = out + SEPARATOR + this.createIndent(indent + 1) + "limit = {" + this.component.parse(indent + 2)
		+ SEPARATOR + this.createIndent(indent + 1) + "}";

	bld = new StringBuilder();
	for (final PatternComponent childComps : this.ifComponents) {
	    bld.append(childComps.parse(indent + 1));
	}
	out = out + bld.toString();

	if (!this.elseComponents.isEmpty()) {
	    bld = new StringBuilder();
	    for (final PatternComponent childComps : this.elseComponents) {
		bld.append(childComps.parse(indent + 2));
	    }

	    out = out + SEPARATOR + this.createIndent(indent + 1) + "else = {" + bld.toString() + SEPARATOR
		    + this.createIndent(indent + 1) + "}";
	}

	out = out + SEPARATOR + this.createIndent(indent) + "}";

	return out;
    }

    @Override
    public void add(PatternComponent comp) {
	this.ifComponents.add(comp);
    }

    @Override
    public void remove(PatternComponent comp) {
	this.ifComponents.remove(comp);
    }

    @Override
    public PatternComponent getChild(int index) {
	return this.ifComponents.get(index);
    }

    public void addElse(PatternComponent comp) {
	this.elseComponents.add(comp);
    }
}
