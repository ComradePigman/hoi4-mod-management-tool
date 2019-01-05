package mmt.comradepigman.components;

import java.io.Serializable;

import mmt.comradepigman.files.FFolder;
import mmt.comradepigman.files.FileHandler;

public class GameProject implements Serializable {

    private static final long serialVersionUID = -1635043078253952404L;

    private FileHandler gFileHandler;

    private GLCountries gCountries = new GLCountries();

    private GLIdeologies gIdeologies = new GLIdeologies();

    private String pName; // p : Project

    private String pFolder; // p : Project

    private String pVersion; // p : Project

    public String getPName() {
	return this.pName;
    }

    public void setPName(String name) {
	this.pName = name;
    }

    public String getPFolder() {
	return pFolder;
    }

    public void setPFolder(String pFolder) {
	this.pFolder = pFolder;
    }

    public String getPVersion() {
	return pVersion;
    }

    public void setPVersion(String pVersion) {
	this.pVersion = pVersion;
    }

    public GLCountries getCountries() {
	return gCountries;
    }

    public void generateContent() {
	gFileHandler = new FileHandler(
		new FFolder("D:/Dokumente/Modding/Paradox/Hearts of Iron/Blood and Iron/" + pFolder));
	gIdeologies.parse(null);
	gFileHandler.createContent();
    }

    public FileHandler getFileHandler() {
	return this.gFileHandler;
    }

    public GLIdeologies getIdeologies() {
	return gIdeologies;
    }
}
