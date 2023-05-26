package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.data.NullBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.TextPrinter;

public class FurnacePrinter implements TextPrinter {

    private SmeltableBlock input;
    private Block output;
    private int fuel_level;
    @Override
    public void display_on_out() {

        if ((this.input instanceof NullBlock) && (this.output instanceof NullBlock)) {
            System.out.println("***The furnace is empty (fuel level="+this.fuel_level+")***");
        } else {
            System.out.println("|| " + this.input.display() + " --> " + this.output.display() + " ||");
        }

    }

    public void update(SmeltableBlock input, Block output, int fuel_level) {
        this.input=input;
        this.output=output;
        this.fuel_level=fuel_level;
    }
}
