package mmt.comradepigman.main;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mmt.comradepigman.components.GameProject;
import mmt.comradepigman.gui.AEditor;
import mmt.comradepigman.gui.AStartup;
import mmt.comradepigman.localization.Localization;

public class Main extends Application {

    private static GameProject activeProject;

    private static Stage userInterface;

    public static Stage getUserInterface() {
	return userInterface;
    }

    public static void setUserInterface(Stage userInterface) {
	Main.userInterface = userInterface;
    }

    public static void setActiveProject(GameProject activeProject) {
	Main.activeProject = activeProject;
    }

    public static GameProject getActiveProject() {
	return activeProject;
    }

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	Font.loadFont(getClass().getResource("/OpenSans-Regular.ttf").toExternalForm(), 10);
	Font.loadFont(getClass().getResource("/OpenSans-Bold.ttf").toExternalForm(), 10);

	Localization.setLocalization();
	Main.setUserInterface(AStartup.createInstance());
	Main.getUserInterface().show();
    }

    public static void startApplication() {
	Main.setUserInterface(new AEditor());
	Main.getUserInterface().show();
    }
}
