package it.unitn.disi.prog2.aliprandi.myproject.main;

import it.unitn.disi.prog2.aliprandi.myproject.System.*;
import it.unitn.disi.prog2.aliprandi.myproject.data.*;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.FuelBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;

import static java.lang.Thread.sleep;

public class MainView {

    public Map map;
    public Furnace furnace;
    public Inventory inventory;
    public MapTextController mt;
    public FurnaceTextController ft;
    public InventoryTextController it;

    public MainView() {
        this.map = new Map();
        this.furnace = new Furnace();
        this.inventory = new Inventory();
    }

    public void smelt() {
        this.furnace.smelt();
        Block b = this.furnace.getOutput();
        //this.inventory.add_block((Block) b);
    }

    public void move_into_furnace(int row, int col) {
        if (this.map.isSmeltable(row, col)) {
            try {
                this.furnace.setInput(this.map.getSmeltableBlock(row, col));
            } catch (BlockErrorException x) {
                x.printStackTrace();
            }
            Block a = new AirBlock();
            this.map.change_cell(row, col, a);
        } else {
            System.out.println("***The "+this.map.getBlock(row,col).display()+" is not smeltable***");
        }
    }

    public void load_fuel(FuelBlock f) {
        this.furnace.load_fuel(f);
    }

    public void move_into_inventory_from_furnace() {
        Block b = this.furnace.getOutput();
        this.furnace.clearOutput();
        this.inventory.add_block(b);
        this.inventory.display();
    }

    public void move_into_furnace_from_inventory(int i) {
        if (this.inventory.isSmeltable(i)) {
            SmeltableBlock b = null;
            try {
                 b = this.inventory.get_smeltable_item(i);
            } catch (BlockErrorException x) {
                x.printStackTrace();
            }
            this.furnace.setInput((SmeltableBlock) b);
            System.out.println("Moving "+b.getClass()+" to the furnace");
        } else if (this.inventory.isFuel(i)) {
            FuelBlock f=null;
            try {
                f = this.inventory.get_fuel_item(i);
            } catch (BlockErrorException x) {
                x.printStackTrace();
            }
            this.furnace.load_fuel(f);
            System.out.println("fueling furnace with "+f.getClass());
        } else  {
            System.out.println("This block is not smeltable or not fuel, can't put into furnace");
        }
    }

    public void pick_up_block(int i, int j) {
        Block b = this.map.gimme_pickable(i,j);

        this.map.matrix[i][j]=new AirBlock();

        this.inventory.add_block(b);
    }

    public void toggle_inventory_comparator() {
        this.inventory.toggle_inventory_comparator();
    }

    public void updatePrinter(MapTextController mt) {
        this.mt.updatePrinter(this.map);
        this.ft.updatePrinter(this.furnace);
        this.it.updatePrinter(this.inventory);
    }

}
