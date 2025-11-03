module org.example.log121tp5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.log121tp5 to javafx.fxml;
    exports org.example.log121tp5;
}