package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.Controllers.MainController;
import it.unitn.disi.prog2.aliprandi.myproject.Controllers.MapController;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ExternalListener extends BlockPane implements EventHandler<MouseEvent> {
    MainController mc;
    int r;
    int c;

    ImageView overlay;
    double currentOpacity = 0.0;

    public ExternalListener(Block block, MainController mc, int r, int c) {
        super(block);
        this.mc=mc;
        setOnMouseClicked(this);
        this.r=r;
        this.c=c;
    }

    public void handle(MouseEvent event) {
        if ((event.getEventType() == MouseEvent.MOUSE_CLICKED) && (this.getBlock() != null)) {

            this.getBlock().mine();

            if (this.getBlock().getHardness()<=0) {
                if (this.getBlock().is_pickable()) {
                    this.mc.pick_up_block(this.r,this.c);
                }

            }

        }
        event.consume();
        this.mc.redraw();
    }

}