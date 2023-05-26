package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.Controllers.MainController;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class InternalListener extends BlockPane implements EventHandler<MouseEvent> {
    MainController mc;
    String type;
    public InternalListener(Block block, MainController mc, String type) {
        super(block);
        setOnMouseClicked(this);
        this.mc=mc;
        this.type=type;
    }

    @Override
    public void handle(MouseEvent event) {
        if ((event.getEventType() == MouseEvent.MOUSE_CLICKED) && (this.getBlock() != null)) {
            //System.out.println("[I]Pressed " + this.getBlock().display());
            switch (this.type) {
                case "input":
                    this.mc.smelt();
                    break;
                case "output":
                    this.mc.move_into_inventory_from_furnace();
                    break;
                case "fuel":
                    break;
            }
        }
        event.consume();
    }
}