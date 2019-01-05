package mmt.comradepigman.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mmt.comradepigman.pattern.PatternComponent;

public class FFolder extends FileComponent{

	private final List<FileComponent> childComponents = new ArrayList<>();
	
	public FFolder(String name) {
		super(name);
	}

	@Override
	public void createContent(String currentDir) {
		String path = currentDir + "/" + getFName();
		File f = new File(path);
	
		f.mkdirs();
		
		for (final FileComponent childComps : this.childComponents) {
			childComps.createContent(path);
		}
	}
	
	@Override
    public void add(FileComponent comp) {
		this.childComponents.add(comp);
    }

    @Override
    public void remove(FileComponent comp) {
    	this.childComponents.remove(comp);
    }

    @Override
    public FileComponent getChild(int index) {
    	return this.childComponents.get(index);
    }

	@Override
	public FFile returnFile(String currentDir) {
		String[] splitDir = currentDir.split("/");
		
		for (final FileComponent childComps : this.childComponents) {
			if(childComps.getFName().equals(splitDir[0])) {
				return childComps.returnFile(currentDir.substring(currentDir.indexOf("/")+1));
			}
		}
	
		FileComponent lastComponent = this;
		for (String name: splitDir) {
			FileComponent component;
			
		    if(name.contains(".")) {	// . means it is a filename
		    	component = new FFile(name);
		    } else {
		    	component = new FFolder(name);
		    }
		    
	    	lastComponent.add(component);
	    	lastComponent = component;
		}
		
		return (FFile) lastComponent;
	}
}
