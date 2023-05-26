package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.data.Map;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.TextPrinter;
import it.unitn.disi.prog2.aliprandi.myproject.main.MainView;

public class MainTextController extends AbstractTextController{

    private MainView mv;
    public MainTextController(MainView mv) {
        super();
        this.mv=mv;
        this.updatePrinter(new MainPrinter());
    }

    public void updatePrinter(MainView mv) {
        MainPrinter mp = new MainPrinter();
        mp.update((MapPrinter) mv.mt.getTextPrinter(),(FurnacePrinter) mv.ft.getTextPrinter(),(InventoryPrinter) mv.it.getTextPrinter());
        super.updatePrinter(mp);
    }
}
