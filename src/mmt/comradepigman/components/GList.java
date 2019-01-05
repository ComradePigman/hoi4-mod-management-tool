package mmt.comradepigman.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class GList implements GParsable, Serializable {

    private static final long serialVersionUID = 5138407383829821831L;

    private final List<GParsable> components = new ArrayList<>();

    public List<GParsable> getComponents() {
	return this.components;
    }
}
