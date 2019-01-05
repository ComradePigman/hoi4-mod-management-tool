package mmt.comradepigman.components;

import mmt.comradepigman.pattern.PatternComponent;

public class GLCountries extends GList {

	@Override
	public void parse() {
		for(GParsable comp : this.getComponents()) {
			comp.parse();
		}
	}

}
