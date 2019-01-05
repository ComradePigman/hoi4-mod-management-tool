package mmt.comradepigman.pattern;

import java.util.ArrayList;
import java.util.List;

public class PLocalisation extends PDecorator {

    public PLocalisation(PatternComponent component) {
    	super(component);
    }

    @Override
    public String parse(int indent) {
    	PStatement statement = (PStatement) this.component;
    	return SEPARATOR + this.createIndent(indent) + statement.getSName() + ":0 \"" + statement.getSValue() + "\"";
    }
}
