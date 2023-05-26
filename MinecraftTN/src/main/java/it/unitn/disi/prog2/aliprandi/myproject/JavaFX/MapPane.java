package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.data.AirBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MapPane extends GridPane {

    private int dim;

    public MapPane(int dim) {
        this.dim=dim;
        this.initialise_air();
    }

    public void initialise_air() {

        for (int i=0; i<10;i++) {
            for (int j = 0; j < 10; j++) {
                ExternalListener b = new ExternalListener(new AirBlock(),null, i, j);
                GridPane.setRowIndex(b,i);
                GridPane.setColumnIndex(b,j);
                this.getChildren().add(b);

            }
        }

    }

    public static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp.getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }

    public ExternalListener get_block_at_coord(int r, int c) {
        ExternalListener p = (ExternalListener) getElementAt(this, r,c);
        return p;
    }

    public void setCell(int r, int c, Block b) {
        ExternalListener p = new ExternalListener(b,null,r,c);
        GridPane.setRowIndex(p, r);
        GridPane.setColumnIndex(p, c);
        ObservableList<Node> children = this.getChildren();
        for (Node node : children) {
            if (GridPane.getRowIndex(node) == r && GridPane.getColumnIndex(node) == c) {
                children.remove(node);
                break;
            }
        }
        children.add(p);
    }


}
