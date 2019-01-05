package mmt.comradepigman.files;

import java.io.Serializable;

import mmt.comradepigman.pattern.PatternComponent;

public abstract class FileComponent implements Serializable{
	
	private String fName; // f : File/Folder
	
	public String getFName() {
		return this.fName;
	}
	
	public FileComponent(String name) {
		this.fName = name;
	}
	
	public abstract void createContent(String currentDir);
	
	public abstract FFile returnFile(String currentDir);
	
	public void add(FileComponent comp) {
		// Leere Defaultimplementierung.
		// Für Leafs nicht sinnvoll.
		// Werden nur von Composites überschrieben.
	    }

    public void remove(FileComponent comp) {
	// Leere Defaultimplementierung.
    }

    public FileComponent getChild(int index) {
	// Leere Defaultimplementierung.
    	return null;
    }
}
