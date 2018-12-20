package mmt.comradepigman.components;

import java.util.ArrayList;
import java.util.List;

public abstract class GList implements GParsable {

    private final List<GParsable> components = new ArrayList<>();

    public List<GParsable> getComponents() {
	return this.components;
    }

}
