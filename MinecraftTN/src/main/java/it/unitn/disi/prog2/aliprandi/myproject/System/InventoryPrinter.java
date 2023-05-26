package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.data.BlockComparator;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.TextPrinter;

import java.util.ArrayList;
import java.util.Comparator;

public class InventoryPrinter implements TextPrinter {

    private ArrayList<Block> inventory;
    private Comparator<Block> comparator;
    @Override
    public void display_on_out() {
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

    public void update(ArrayList<Block> inventory, Comparator<Block> comparator) {
        this.inventory=inventory;
        this.comparator=comparator;
    }
}
