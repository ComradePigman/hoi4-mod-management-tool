package mmt.comradepigman.components;

public class CParty {

    private final GIdeology pIdeology;

    private final CLeader pLeader;

    public CParty(GIdeology ideology, CLeader leader) {
    	this.pIdeology = ideology;
    	this.pLeader = leader;
    }

    public GIdeology getIdeology() {
    	return this.pIdeology;
    }

    public CLeader getLeader() {
    	return this.pLeader;
    }

    public String getEName() {
    	return "Test";
    }

}
