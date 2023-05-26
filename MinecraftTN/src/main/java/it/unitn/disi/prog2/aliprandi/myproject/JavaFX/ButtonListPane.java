package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.Controllers.FurnaceController;
import it.unitn.disi.prog2.aliprandi.myproject.Controllers.InventoryController;
import it.unitn.disi.prog2.aliprandi.myproject.Controllers.MainController;
import it.unitn.disi.prog2.aliprandi.myproject.Controllers.MapController;
import it.unitn.disi.prog2.aliprandi.myproject.data.*;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.FuelBlock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Random;

public class ButtonListPane extends VBox {

    public HBox row1;
    public HBox row2;
    public HBox row3;
    public HBox row4;
    public HBox row5;
    public MainController mainController;

    public ButtonListPane(MainController mainController) {

        this.row1 = new HBox();
        this.row2 = new HBox();
        this.row3 = new HBox();
        this.row4 = new HBox();
        this.row5 = new HBox();

        this.mainController = mainController;

        TextField row = new TextField("0");
        TextField col = new TextField("0");

        this.row1.getChildren().add(row);
        this.row1.getChildren().add(col);
        Button pick = new Button("Pick");

        pick.setOnAction(new EventHandler<ActionEvent>() {

            int r,c;

            @Override
            public void handle(ActionEvent event) {

                try {
                    r = Integer.parseInt(row.getText());
                    c = Integer.parseInt(col.getText());
                    mainController.pick_up_block(r,c);
                } catch (Exception x) {
                    System.out.println("ERROR!"+row.getText()+" "+col.getText()+" are not valid coordinates");
                    //x.printStackTrace();
                }

                mainController.inventoryController.redraw();
            }});

        this.row1.getChildren().add(pick);

        TextField index = new TextField("0");
        this.row2.getChildren().add(index);
        Button move = new Button("Move to Furnace");

        move.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int i=0;
                try {
                    i = Integer.parseInt(index.getText());
                    mainController.move_into_furnace_from_inventory(i);
                } catch (Exception x) {
                    System.out.println("ERROR!"+index.getText()+" is not a valid index");
                    //x.printStackTrace();
                }

            }});

        Button load = new Button("Load fuel");

        load.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int i=0;
                try {
                    i = Integer.parseInt(index.getText());
                    FuelBlock f = (FuelBlock) mainController.mainView.inventory.getItem(i);
                    if (f instanceof FuelBlock)  {
                        mainController.load_fuel(f);
                    }
                    mainController.move_into_furnace_from_inventory(i);
                } catch (Exception x) {
                    System.out.println("ERROR!"+index.getText()+" is not a valid index");
                    //x.printStackTrace();
                }

            }});

        this.row2.getChildren().add(move);
        this.row2.getChildren().add(load);

        Button smelt = new Button("Smelt");

        smelt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mainController.smelt();
            }});

        this.row3.getChildren().add(smelt);

        Button move_back = new Button("Move back");

        move_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mainController.move_into_inventory_from_furnace();
            }});

        this.row4.getChildren().add(move_back);

        Button toggle = new Button("Toggle Inventory Sorting");

        toggle.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mainController.toggle_inventory_comparator();
            }});

        this.row5.getChildren().add(toggle);

        this.getChildren().add(row1);
        this.getChildren().add(row2);
        this.getChildren().add(row3);
        this.getChildren().add(row4);
        this.getChildren().add(row5);
    }
}
