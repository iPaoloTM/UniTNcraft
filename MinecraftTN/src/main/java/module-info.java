module it.unitn.disi.prog2.aliprandi.myproject.myproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.unitn.disi.prog2.aliprandi.myproject.main to javafx.fxml;
    exports it.unitn.disi.prog2.aliprandi.myproject.main;
}