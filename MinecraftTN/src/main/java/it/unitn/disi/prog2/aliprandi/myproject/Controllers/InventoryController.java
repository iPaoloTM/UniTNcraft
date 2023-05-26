package it.unitn.disi.prog2.aliprandi.myproject.Controllers;

import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.AnonymListener;
import it.unitn.disi.prog2.aliprandi.myproject.data.*;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.BlockPane;
import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.FurnacePane;
import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.InventoryPane;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SimpleController;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class InventoryController implements SimpleController {

    public Inventory inventory;
    public InventoryPane inventoryPane;
    private MainController mc;

    public InventoryController(Inventory inventory, InventoryPane inventoryPane, MainController mc) {
        this.inventoryPane=inventoryPane;
        this.inventory = inventory;

        this.mc=mc;

        redraw();
    }
    @Override
    public void redraw() {

        List<Node> children = this.inventoryPane.getChildren();
        ListIterator<Node> iterator = children.listIterator();

        while (iterator.hasNext()) {
            Node x = iterator.next();
            iterator.remove();
        }

        children.add(new Text("Inventory"));

        int i=0;

        for (Block b: this.inventory.getCollection()) {

            this.inventoryPane.getChildren().add(new AnonymListener(b, this.mc, i));
            i++;

        }

    }
}
