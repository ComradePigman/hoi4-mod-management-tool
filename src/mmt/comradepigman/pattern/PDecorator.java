package mmt.comradepigman.pattern;

public abstract class PDecorator extends PatternComponent {

    protected PatternComponent component;

    public PDecorator(PatternComponent component) {
	this.component = component;
    }

}
