module org.example.TugasModul6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.TUGAS6MDL6 to javafx.fxml;
    exports org.example.TUGAS6MDL6;
}
