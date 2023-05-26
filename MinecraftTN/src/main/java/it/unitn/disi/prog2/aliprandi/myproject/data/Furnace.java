package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.FuelBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;

public class Furnace {

    public SmeltableBlock input;
    public Block output;
    public FuelBlock fuel;
    public int fuel_level=1;

    public Furnace() {
        NullBlock nullBlock = new NullBlock();
        this.input = (SmeltableBlock) nullBlock;
        this.output = nullBlock;
        this.fuel  = new Coal(1);
    }

    public void display() {
        if ((this.input instanceof NullBlock) && (this.output instanceof NullBlock)) {
            System.out.println("***The furnace is empty (fuel level="+this.fuel_level+")***");
        } else {
            System.out.println("|| " + this.input.display() + " --> " + this.output.display() + " ||");
        }
    }

    public void load_fuel(FuelBlock f) {
        this.fuel=f;
        this.fuel_level+=f.getFuelValue();
    }

    public void smelt() {
        if ((!(this.input instanceof NullBlock)) && this.fuel_level>0) {
            this.fuel_level=this.fuel_level-1;
            this.output=this.input.smelt();
            System.out.println("***Smelting "+this.input.display()+", fuel level="+this.fuel_level+"***");
            NullBlock nullBlock = new NullBlock();
            this.input = (SmeltableBlock) nullBlock;
        } else if (this.input instanceof NullBlock) {
            System.out.println("***Cannot smelt anything!***");
        } else if (this.fuel_level==0) {
            this.fuel=null;
            System.out.println("***No fuel available!***");
        }
    }

    public void setInput(SmeltableBlock b) {
        this.input=b;
        //this.output = this.input.smelt();
    }

    public SmeltableBlock getInput() {
        SmeltableBlock b = this.input;
        //this.input=new NullBlock();
        return b;
    }
    public Block getOutput() {
        Block b = this.output;
        //this.output= new NullBlock();
        return b;
    }

    public FuelBlock getFuel() {
        return this.fuel;
    }

    public int getFuelLevel() {
        return this.fuel_level;
    }

    public void clearOutput() {
        NullBlock b = new NullBlock();
        this.output=b;
    }

}
