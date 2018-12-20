package mmt.comradepigman.components;

public class CParty {

    private final CIdeology pIdeology;

    private final CLeader pLeader;

    public CParty(CIdeology ideology, CLeader leader) {
	this.pIdeology = ideology;
	this.pLeader = leader;
    }

    public CIdeology getIdeology() {
	return this.pIdeology;
    }

    public CLeader getLeader() {
	return this.pLeader;
    }

    public String getEName() {
	return "Test";
    }

}
