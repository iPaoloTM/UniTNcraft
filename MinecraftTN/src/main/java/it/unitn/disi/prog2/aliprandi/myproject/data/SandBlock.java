package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock  {

    public SandBlock() {
        super();
        this.pickable=true;
        this.contenuto='S';
        this.falls_through=false;
        this.falls_with_gravity=true;
        this.blockname="Sand";
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

    @Override
    public Block smelt() {
        GlassBlock glass = new GlassBlock();
        return glass;
    }
}
