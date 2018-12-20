package mmt.comradepigman.components;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.scene.Node;
import mmt.comradepigman.gui.EPolitics;
import mmt.comradepigman.pattern.PGroup;
import mmt.comradepigman.pattern.PStatement;
import mmt.comradepigman.pattern.PatternComponent;

public class CPolitics implements GParsable, Renderable {

    private final HashMap<CParty, Integer> parties = new HashMap<>();

    private CParty rulingParty;

    private Date lastElection;

    private int electionFrequency;

    private boolean electionsAllowed;

    public void setParty(CParty party, int popularity) {
	this.parties.put(party, popularity);
    }

    @Override
    public Node init() {
	final EPolitics component = new EPolitics();

	for (final Entry<CParty, Integer> aSet : this.parties.entrySet()) {
	    component.addItem(aSet.getKey(), aSet.getValue());
	}

	component.addItem(this);

	return component;

    }

    @Override
    public PatternComponent parse() {
	final PGroup dGroup = new PGroup("set_politics");

	final PGroup pGroup = new PGroup("parties");
	for (final Entry<CParty, Integer> aSet : this.parties.entrySet()) {
	    final PGroup aGroup = new PGroup(aSet.getKey().getIdeology().getSName());
	    aGroup.add(new PStatement("popularity", aSet.getValue().toString()));
	    pGroup.add(aGroup);
	}

	dGroup.add(pGroup);

	final StringBuilder bld = new StringBuilder();
	for (final Entry<CParty, Integer> aSet : this.parties.entrySet()) {
	    final PGroup aGroup = new PGroup("create_country_leader");
	    aGroup.add(new PStatement("name", "\"" + aSet.getKey().getLeader().getName() + "\""));
	    bld.append(aGroup.parse());
	}

	return dGroup;
    }
}
