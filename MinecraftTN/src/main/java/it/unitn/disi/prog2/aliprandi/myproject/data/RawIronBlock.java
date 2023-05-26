package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {

    public RawIronBlock() {
        super();
        this.contenuto='F';
        this.blockname="Raw Iron";
        this.hardness=3;
    }

    @Override
    public Block smelt() {
        IronSwordBlock ironsword = new IronSwordBlock();
        return ironsword;
    }
}
