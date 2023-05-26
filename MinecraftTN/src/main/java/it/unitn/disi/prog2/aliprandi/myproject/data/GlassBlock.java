package it.unitn.disi.prog2.aliprandi.myproject.data;

public class GlassBlock extends AbstractSolidBlock {


    public GlassBlock() {
        super();
        this.contenuto='G';
        this.blockname="Glass";
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
}
