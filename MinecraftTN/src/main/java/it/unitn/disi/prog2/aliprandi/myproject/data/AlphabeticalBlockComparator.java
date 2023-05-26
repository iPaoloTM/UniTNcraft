package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import javafx.beans.property.adapter.JavaBeanLongProperty;

import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block o1, Block o2) {
        return o1.display()-o2.display();
    }
}
