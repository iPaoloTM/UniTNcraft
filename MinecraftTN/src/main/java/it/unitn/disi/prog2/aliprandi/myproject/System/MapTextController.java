package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.data.Map;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.TextPrinter;

public class MapTextController extends AbstractTextController{
    private Map map;

    public MapTextController(Map map) {
        super();
        this.map = map;
        this.updatePrinter(new MapPrinter());
    }

    public void updatePrinter(Map map) {
        MapPrinter mp = new MapPrinter();
        mp.update(map.matrix, map.dim);
        super.updatePrinter(mp);
    }
}
