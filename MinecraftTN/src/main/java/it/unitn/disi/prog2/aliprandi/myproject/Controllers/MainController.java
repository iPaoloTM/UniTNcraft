package it.unitn.disi.prog2.aliprandi.myproject.Controllers;

import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.FurnacePane;
import it.unitn.disi.prog2.aliprandi.myproject.JavaFX.MainGUI;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.FuelBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SimpleController;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;
import it.unitn.disi.prog2.aliprandi.myproject.main.MainView;

import java.util.ArrayList;
import java.util.Collection;

public class MainController implements SimpleController {

    public MainView mainView;
    public MainGUI mainGUI;
    public Collection<SimpleController>  controllersList;
    public MapController mapController;
    public FurnaceController furnaceController;
    public InventoryController inventoryController;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        this.mainGUI = new MainGUI(this);
        this.mapController = new MapController(this.mainView.map, this.mainGUI.mapPane, this);
        this.furnaceController = new FurnaceController(this.mainView.furnace, this.mainGUI.furnacePane, this);
        this.inventoryController = new InventoryController(this.mainView.inventory, this.mainGUI.inventoryPane, this);

        this.controllersList = new ArrayList<>();

        this.controllersList.add(this.mapController);
        this.controllersList.add(this.furnaceController);
        this.controllersList.add(this.inventoryController);
    }

    public void smelt() {

        this.mainView.smelt();
        this.furnaceController.redraw();
    }

    public void load_fuel(FuelBlock f) {
        this.mainView.load_fuel(f);
        this.inventoryController.redraw();
        this.furnaceController.redraw();
    }

    public void move_into_inventory_from_furnace() {
        this.mainView.move_into_inventory_from_furnace();
        this.inventoryController.redraw();
        this.furnaceController.redraw();
    }

    public void move_into_furnace_from_inventory(int i) {
        this.mainView.move_into_furnace_from_inventory(i);
        this.inventoryController.redraw();
        this.furnaceController.redraw();
    }

    public void pick_up_block(int i, int j) {
        this.mainView.pick_up_block(i,j);
        this.mapController.redraw();
    }

    public void toggle_inventory_comparator() {
        this.mainView.toggle_inventory_comparator();
        this.inventoryController.redraw();
    }

    @Override
    public void redraw() {

        for (SimpleController x: this.controllersList) {
            x.redraw();
        }

    }
}
