package mmt.comradepigman.components;

public enum AutonomousState {
    INTEGRATED_PUPPET("autonomy_integrated_puppet"), DOMINION("autonomy_dominion");

    private String sValue; // s : Statement

    AutonomousState(String statementValue) {
	this.sValue = statementValue;
    }

    public String getValue() {
	return this.sValue;
    }
}
