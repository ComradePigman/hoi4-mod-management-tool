/**
 * 
 */
/**
 * @author z003jnja
 *
 */
module concreteapplication {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens mmt.comradepigman.components;
    opens mmt.comradepigman.gui;
    opens mmt.comradepigman.pattern;
    opens mmt.comradepigman.main;
}