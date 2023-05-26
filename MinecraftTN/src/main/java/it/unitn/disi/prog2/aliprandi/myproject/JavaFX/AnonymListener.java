package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.Controllers.MainController;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.FuelBlock;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class AnonymListener extends BlockPane implements EventHandler<MouseEvent> {
    MainController mc;
    int index;
    public AnonymListener(Block block, MainController mc, int index) {
        super(block);
        setOnMouseClicked(this);
        this.mc=mc;
        this.index=index;
    }

    @Override
    public void handle(MouseEvent event) {
        if ((event.getEventType() == MouseEvent.MOUSE_CLICKED) && (this.getBlock() != null)) {
            //System.out.println("[A]Pressed " + this.getBlock().display());
            this.mc.move_into_furnace_from_inventory(this.index);

        }

        event.consume();
        this.mc.inventoryController.redraw();
    }
}
