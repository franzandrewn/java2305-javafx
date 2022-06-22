module com.andrewn.java2305javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.andrewn.java2305javafx to javafx.fxml;
    exports com.andrewn.java2305javafx;
}