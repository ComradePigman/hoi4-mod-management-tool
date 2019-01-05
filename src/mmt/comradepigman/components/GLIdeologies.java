package mmt.comradepigman.components;

import mmt.comradepigman.files.FFile;
import mmt.comradepigman.main.Main;

public class GLIdeologies extends GList {

    private static final long serialVersionUID = 5888462752146738696L;

    @Override
    public void parse(FFile lFile) {

	Main.getActiveProject().getFileHandler().returnFile("common/ideologies/00_ideologies.txt");
	// The default file will be overwritten for a better overview.

	int i = 1;
	for (GParsable component : this.getComponents()) {

	    GIdeology ideology = (GIdeology) component;
	    String fileName = String.format("%02d", i) + "_" + ideology.getSName() + ".txt";
	    // Example: 01_conservatism_ideology.txt

	    FFile ideoFile = Main.getActiveProject().getFileHandler().returnFile("common/ideologies/" + fileName);

	    component.parse(ideoFile);
	    i++;
	}
    }
}
