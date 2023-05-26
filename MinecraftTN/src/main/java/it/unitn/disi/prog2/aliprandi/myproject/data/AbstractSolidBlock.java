package it.unitn.disi.prog2.aliprandi.myproject.data;

public class AbstractSolidBlock extends AbstractBlock{

    public AbstractSolidBlock() {
        super();
        this.pickable=true;
        this.falls_through=false;
        this.falls_with_gravity=false;
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
