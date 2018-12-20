package mmt.comradepigman.pattern;

import java.util.Collections;

public abstract class PatternComponent {

    protected static final String SEPARATOR = System.getProperty("line.separator");

    public final String parse() {
	return this.parse(0);
    }

    public abstract String parse(int indent);

    public void add(PatternComponent comp) {
	// Leere Defaultimplementierung.
	// Für Leafs nicht sinnvoll.
	// Werden nur von Composites überschrieben.
    }

    public void remove(PatternComponent comp) {
	// Leere Defaultimplementierung.
    }

    public PatternComponent getChild(int index) {
	// Leere Defaultimplementierung.
	return null;
    }

    public String createIndent(int indent) {
	// create a string made up of n copies of string "/t"
	return String.join("", Collections.nCopies(indent, "	"));
    }
}
