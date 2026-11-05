module oop2.assignment_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens oop2.assignment_3 to javafx.fxml;
    exports oop2.assignment_3;
}
