package mmt.comradepigman.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {

    static private Locale locale;
    static private ResourceBundle bundle;

    public static void setLocalization() {
	locale = new Locale("en", "EN");
	bundle = ResourceBundle.getBundle("mmt.comradepigman.localization.LocalizationBundle", locale);
    }

    public static String getString(String key) {
	return bundle.getString(key);
    }

    public static ResourceBundle getBundle() {
	return bundle;
    }
}
