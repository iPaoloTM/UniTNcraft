package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.FuelBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.InventoryBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Inventory {
    private ArrayList<Block> inventory;
    public Comparator<Block> comparator;
    public Inventory() {

        this.inventory = new ArrayList<>();
        this.comparator = new BlockComparator();
    }

    public void display() {
        if (this.inventory.isEmpty()) {
            System.out.println("Inventory empty");
        } else {
            if (this.comparator instanceof BlockComparator) {
                for (Block b: this.inventory) {
                    System.out.println("[" + b.display() + "]");
                }
            } else {
                    for (Block b: this.inventory) {
                        System.out.println("{"+b.display()+"}");
             }
            }
        }
    }

    public void reorder() {
        this.inventory.sort(this.comparator);
    }

    public void add_block(Block b) {
        if (!(b instanceof NullBlock)) {
            System.out.println("Adding "+b.getClass()+" to inventory");
            this.inventory.add(b);
            this.reorder();
        } else {
            System.out.println("***Cannot add NullBlock to inventory***");
        }
    }

    public boolean isSmeltable(int i) {
        return (this.inventory.get(i) instanceof SmeltableBlock);
    }

    public boolean isFuel(int i) {
        return (this.inventory.get(i) instanceof FuelBlock);
    }

    public Block getItem(int i) {
        Block b=null;
        try {
            b=this.inventory.get(i);
            this.inventory.remove(i);
        } catch (Exception x) {
            //x.printStackTrace();
            System.out.println("ERROR! There is no item in the inventory at position "+i);
        }
        return b;
    }

    public SmeltableBlock get_smeltable_item(int i)  throws BlockErrorException {
        SmeltableBlock b=null;
        try {
            b = (SmeltableBlock) this.inventory.get(i);
            this.inventory.remove(i);
        } catch (Exception x) {
            System.out.println("Not smeltable");
            x.printStackTrace();
        }
        return b;
    }

    public FuelBlock get_fuel_item(int i)  throws BlockErrorException {
        FuelBlock b=null;
        try {
            b = (FuelBlock) this.inventory.get(i);
            this.inventory.remove(i);
        } catch (Exception x) {
            System.out.println("Not fuel");
            x.printStackTrace();
        }
        return b;
    }

    public void toggle_inventory_comparator() {
        if (this.comparator instanceof BlockComparator) {
            this.comparator=new AlphabeticalBlockComparator();
        } else if (this.comparator instanceof AlphabeticalBlockComparator) {
            this.comparator=new BlockComparator();
        }
        this.inventory.sort(this.comparator);
    }

    public Block getBlock(int i) {
        return this.inventory.get(i);
    }

    public void removeBlock(int i) {
        this.inventory.remove(i);
    }

    public ArrayList<Block> getCollection() {
        return this.inventory;
    }

}
