module se.kth.arafatul.labb4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.kth.arafatul.labb4 to javafx.fxml;
    exports se.kth.arafatul.labb4;
}