package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;

public class WaterBlock extends AbstractBlock implements Block {

    public WaterBlock() {
        super();
        this.contenuto='W';
        this.falls_through=true;
        this.falls_with_gravity=true;
        this.blockname="Water";
        this.hardness=0;
    }

    @Override
    public boolean getFallsWithGravity() {
        return this.falls_with_gravity;
    }

    @Override
    public boolean getFallsThrough() {
        return this.falls_through;
    }

    @Override
    public char display() {
        return this.contenuto;
    }

    @Override
    public int getHardness() {
        return this.hardness;
    }

    @Override
    public void mine() {
        this.hardness--;
    }
}
