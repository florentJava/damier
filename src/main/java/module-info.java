module com.example.damierenfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.damierenfx to javafx.fxml;
    exports com.example.damierenfx;
}