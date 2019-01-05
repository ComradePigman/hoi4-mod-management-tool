package mmt.comradepigman.files;

import java.io.Serializable;

public class FileHandler implements Serializable {

    private static final long serialVersionUID = 8802068617863341861L;

    private FFolder mainDir;

    public FileHandler(FFolder dir) {
	this.mainDir = dir;
    }

    public FFile returnFile(String searchDir) {
	return mainDir.returnFile(searchDir);
    }

    public void createContent() {
	mainDir.createContent("");
    }
}
