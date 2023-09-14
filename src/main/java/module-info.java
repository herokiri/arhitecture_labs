module ru.dstu.sergey.laba1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.dstu.sergey.laba1 to javafx.fxml;
    exports ru.dstu.sergey.laba1;
}