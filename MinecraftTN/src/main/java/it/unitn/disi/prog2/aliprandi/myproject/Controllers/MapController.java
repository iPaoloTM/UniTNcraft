package it.unitn.disi.prog2.aliprandi.myproject.Controllers;

import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.BlockPane;
import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.ExternalListener;
import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.FurnacePane;
import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.MapPane;
import it.unitn.disi.prog2.aliprandi.myproject.data.AirBlock;
import it.unitn.disi.prog2.aliprandi.myproject.data.Furnace;
import it.unitn.disi.prog2.aliprandi.myproject.data.Map;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SimpleController;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.ListIterator;

public class MapController implements SimpleController {

    public Map map;
    public MapPane mapPane;
    private MainController mc;

    public MapController(Map map, MapPane mapPane, MainController mc) {
        this.map = map;
        this.mapPane=mapPane;
        this.mc=mc;

        redraw();
    }
    @Override
    public void redraw() {

        List<Node> children = this.mapPane.getChildren();
        ListIterator<Node> iterator = children.listIterator();

        while (iterator.hasNext()) {
            Node x = iterator.next();
            iterator.remove();
        }

        for (int i=0; i<this.map.dim; i++) {
            for (int j=0; j<this.map.dim; j++) {

                Block b = this.map.matrix[i][j];

                ExternalListener bp = new ExternalListener(b, this.mc, i,j);
                GridPane.setRowIndex(bp,i);
                GridPane.setColumnIndex(bp,j);
                this.mapPane.getChildren().add(bp);

            }
        }

    }
}
