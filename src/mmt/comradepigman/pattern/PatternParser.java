package mmt.comradepigman.pattern;

import java.util.ArrayList;
import java.util.List;

import mmt.comradepigman.components.AutonomousState;
import mmt.comradepigman.components.Country;

public class PatternParser {

    public static List<PatternComponent> childComponents = new ArrayList<>();

    public static void main(String[] args) {

	final Country aCountry = new Country();
	aCountry.getAutonomyHandler().addAutonomy("ENG", AutonomousState.INTEGRATED_PUPPET);
	aCountry.getAutonomyHandler().addAutonomy("USA", AutonomousState.DOMINION);
	aCountry.parse();
    }

}
