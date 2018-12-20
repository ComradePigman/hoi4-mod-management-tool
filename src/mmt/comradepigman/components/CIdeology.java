package mmt.comradepigman.components;

public class CIdeology {

    private final String sName; // s : Statement i.e. the internal name

    private String eName; // e : External i.e. the name to be displayed in game

    private String eNoun; // e : External i.e. the ideology's noun in game

    private String eDesc; // e : External i.e. how you would refer to a nation with that ideology in game

    public CIdeology(String name) {
	this.sName = name;
    }

    public String getSName() {
	return this.sName;
    }

    public String getEName() {
	return this.eName;
    }
}
