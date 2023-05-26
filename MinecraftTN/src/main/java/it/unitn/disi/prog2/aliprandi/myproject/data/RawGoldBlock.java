package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;

public class RawGoldBlock extends AbstractSolidBlock implements SmeltableBlock {
    public RawGoldBlock() {
        super();
        this.contenuto='A';
        this.blockname="Raw Gold";
        this.hardness=3;
    }

    @Override
    public Block smelt() {
        GoldIngot gold = new GoldIngot();
        return gold;
    }
}
