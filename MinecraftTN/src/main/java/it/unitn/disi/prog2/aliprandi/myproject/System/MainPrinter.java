package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.TextPrinter;

public class MainPrinter implements TextPrinter {

    MapPrinter m;
    FurnacePrinter f;
    InventoryPrinter i;
    @Override
    public void display_on_out() {
        this.m.display_on_out();
        this.f.display_on_out();
        this.i.display_on_out();
    }

    public void update(MapPrinter m, FurnacePrinter f, InventoryPrinter i) {
        this.m=m;
        this.f=f;
        this.i=i;
    }
}
