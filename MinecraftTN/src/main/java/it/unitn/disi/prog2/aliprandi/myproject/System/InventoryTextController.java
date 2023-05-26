package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.data.Inventory;
import it.unitn.disi.prog2.aliprandi.myproject.data.Map;

public class InventoryTextController extends AbstractTextController{
    private Inventory inventory;
    public InventoryTextController(Inventory inventory) {
        super();
        this.inventory=inventory;
        this.updatePrinter(new InventoryPrinter());
    }

    public void updatePrinter(Inventory inventory) {
        InventoryPrinter ip = new InventoryPrinter();
        ip.update(inventory.getCollection(), inventory.comparator);
        super.updatePrinter(ip);
    }
}
