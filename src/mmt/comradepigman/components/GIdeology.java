package mmt.comradepigman.components;

import java.io.Serializable;
import java.util.Map.Entry;

import mmt.comradepigman.files.FFile;
import mmt.comradepigman.main.Main;
import mmt.comradepigman.pattern.PGroup;
import mmt.comradepigman.pattern.PLocalisation;
import mmt.comradepigman.pattern.PStatement;

public class GIdeology implements GParsable, Serializable{

    private String eName; // e : External i.e. the name to be displayed in game

    private String eNoun; // e : External i.e. the ideology's noun in game

    private String eDesc; // e : External i.e. how you would refer to a nation with that ideology in game

    public GIdeology(String name) {
    	this.eName = name;
    }

    public String getSName() {
    	return this.eName.toLowerCase().replace(" ", "_") + "_ideology";	// Example: conservatism_ideology
    }

    public String getEName() {
    	return this.eName;
    }
    
	private String getENoun() {
		return this.eNoun;
	}

	@Override
	public void parse(FFile lFile) {
		
		// GENERATE LOCALISATION
		FFile locFile = Main.getActiveProject().getFileHandler().returnFile("localisation/parties_l_english.yml");
		locFile.addPattern(new PLocalisation(new PStatement(this.getSName(), this.getEName())));
		locFile.addPattern(new PLocalisation(new PStatement(this.getSName() + "_noun",this.getENoun())));
		
		// GENERATE IDEOLOGY FILE
		final PGroup iGroup = new PGroup("ideologies");
		final PGroup pGroup = new PGroup(this.getSName());
		iGroup.add(pGroup);
		
		lFile.addPattern(iGroup);		
	}
}
