package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.data.Furnace;
import it.unitn.disi.prog2.aliprandi.myproject.data.Inventory;

public class FurnaceTextController extends AbstractTextController{
    private Furnace furnace;
    public FurnaceTextController(Furnace furnace) {
        super();
        this.furnace=furnace;
        this.updatePrinter(new FurnacePrinter());
    }

    public void updatePrinter(Furnace furnace) {
        FurnacePrinter fp = new FurnacePrinter();
        fp.update(furnace.getInput(), furnace.getOutput(), furnace.getFuelLevel());
        super.updatePrinter(fp);
    }
}
