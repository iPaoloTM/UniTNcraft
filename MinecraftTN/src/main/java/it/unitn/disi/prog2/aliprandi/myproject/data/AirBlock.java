package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.data.AbstractBlock;

public class AirBlock extends AbstractBlock implements Block  {

    public AirBlock() {
        super();
        this.contenuto='.';
        this.falls_through=true;
        this.falls_with_gravity=false;
        this.blockname="Air";
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


    /**
    public AirBlock(char x, boolean y, boolean z) {
        this.contenuto=x;
        this.falls_with_gravity=y;
        this.falls_through=z;
    }
    */




}
