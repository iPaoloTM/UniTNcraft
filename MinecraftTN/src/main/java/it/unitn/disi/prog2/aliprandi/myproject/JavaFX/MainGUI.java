package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.Controllers.MainController;
import it.unitn.disi.prog2.aliprandi.myproject.data.Furnace;
import it.unitn.disi.prog2.aliprandi.myproject.data.Inventory;
import it.unitn.disi.prog2.aliprandi.myproject.data.Map;
import it.unitn.disi.prog2.aliprandi.myproject.data.SandBlock;
import it.unitn.disi.prog2.aliprandi.myproject.main.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class MainGUI extends BorderPane implements EventHandler<KeyEvent> {

    public MapPane mapPane;
    Map map;
    Furnace furnace;
    public FurnacePane furnacePane;
    ButtonListPane buttons;
    Inventory inventory;
    public InventoryPane inventoryPane;
    public MainController mainController;
    public MainView mainView;

    public MainGUI(MainController mc) {

        BorderPane inner = new BorderPane();
        this.mainView = mc.mainView;
        this.map = mc.mainView.map;
        this.mapPane = new MapPane(this.map.dim);
        this.furnacePane = new FurnacePane();
        this.inventoryPane = new InventoryPane();
        this.mainController = mc;
        this.buttons = new ButtonListPane(this.mainController);

        inner.setCenter(this.mapPane);
        inner.setRight(this.furnacePane);
        inner.setBottom(this.inventoryPane);

        this.setCenter(inner);
        this.setBottom(this.buttons);

        this.setOnKeyPressed(this);

    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.S) {
            System.out.println("S");
            this.inventory.toggle_inventory_comparator();
        } else if (event.getCode() == KeyCode.N) {
            System.out.println("N");
            this.map.addRandomBlock();
        } else if (event.getCode() == KeyCode.R) {
            System.out.println("R");
            for (int i=0; i<10; i++) {
                this.map.addRandomBlock();
            }
        }
    }

}
