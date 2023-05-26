package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.data.WaterBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collection;

public class InventoryPane extends HBox {

    public Text text;
    public HBox hbox;
    public Collection<Block> c;

    public InventoryPane() {

        this.text = new Text("Inventory");
        this.hbox = new HBox();
        this.c = new ArrayList<Block>();

        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);

        this.getChildren().add(this.text);
        this.getChildren().add(this.hbox);

        addBlocks();
    }

    public void addBlocks() {

        Block b = null;

        for (int i=0; i<9; i++) {
            b = new WaterBlock();
            c.add(b);
            this.hbox.getChildren().add(new AnonymListener(b, null, i));
        }
    }
}
