module org.openjfx.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.openjfx.poo to javafx.fxml;
    exports org.openjfx.poo;
    
    opens org.openjfx.poo.Model to javafx.fxml;
    exports org.openjfx.poo.Model;
    
    opens org.openjfx.poo.Controller to javafx.fxml;
    exports org.openjfx.poo.Controller;
    
    opens org.openjfx.poo.View to javafx.fxml;
    exports org.openjfx.poo.View;
    
    opens org.openjfx.poo.Model.Dao to javafx.fxml;
    exports org.openjfx.poo.Model.Dao;
    
    
}
