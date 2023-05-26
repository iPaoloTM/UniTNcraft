package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;

public class RawCoalBlock extends AbstractSolidBlock implements SmeltableBlock {
    public RawCoalBlock() {
        super();
        this.contenuto='C';
        this.blockname="Raw coal";
    }

    @Override
    public Block smelt() {
        Coal c = new Coal(5);
        return c;
    }
}
