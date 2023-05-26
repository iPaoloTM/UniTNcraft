package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.FuelBlock;

public class Coal implements FuelBlock {
    public int fuel_value;

    public Coal(int fuel_value) {
        this.fuel_value = fuel_value;
    }

    @Override
    public void burn() {
        this.fuel_value=this.fuel_value-1;
    }

    @Override
    public int getFuelValue() {
        return this.fuel_value;
    }

    @Override
    public boolean getFallsWithGravity() {
        return false;
    }

    @Override
    public boolean getFallsThrough() {
        return false;
    }

    @Override
    public char display() {
        return 'c';
    }

    @Override
    public boolean is_pickable() {
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getHardness() {
        return this.getHardness();
    }

    @Override
    public void mine() {
        this.mine();
    }
}
