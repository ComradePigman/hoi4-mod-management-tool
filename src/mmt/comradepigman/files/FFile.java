package mmt.comradepigman.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import mmt.comradepigman.pattern.PatternComponent;

public class FFile extends FileComponent {

    private List<PatternComponent> childComponents = new ArrayList<>();

    public FFile(String name) {
	super(name);
    }

    public void addPattern(PatternComponent patternComponent) {
	childComponents.add(patternComponent);
    }

    @Override
    public void createContent(String currentDir) {
	try {
	    String path = currentDir + "/" + getFName();
	    File f = new File(path);

	    f.getParentFile().mkdirs(); // TODO: Not needed, keep it for until better solution found
	    f.createNewFile();

	    final StringBuilder bld = new StringBuilder();
	    for (final PatternComponent childComps : this.childComponents) {
		bld.append(childComps.parse(0));
	    }
	    String content = bld.toString();

	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"));
	    writer.write(content);
	    writer.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public FFile returnFile(String currentDir) {
	return this;
    }

}
