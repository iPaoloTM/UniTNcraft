package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.data.*;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FurnacePane extends VBox {

    public Furnace furnace;

    public FurnacePane() {

        this.getChildren().add(new Text("Furnace"));
        this.getChildren().add(new InternalListener(new SandBlock(),null,"input"));
        this.getChildren().add(new Text("--->"));
        HBox h  = new HBox();
        h.getChildren().add(new InternalListener(new Coal(5),null,"fuel"));
        h.getChildren().add(new InternalListener(new GlassBlock(),null,"output"));
        this.getChildren().add(h);
    }
}
