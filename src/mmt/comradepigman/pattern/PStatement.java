package mmt.comradepigman.pattern;

public class PStatement extends PatternComponent {

    private final String sName; // s : Statement

    private final String sValue; // s : Statement

    public PStatement(String statementName, String statementValue) {
	this.sName = statementName;
	this.sValue = statementValue;
    }

    @Override
    public String parse(int indent) {
	return SEPARATOR + this.createIndent(indent) + this.getSName() + " = " + this.sValue;
    }

	public String getSName() {
		return this.sName;
	}

	public String getSValue() {
		return this.sValue;
	}

}
