package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.TextPrinter;

public abstract class AbstractTextController {
    private TextPrinter tp;

    public TextPrinter getTextPrinter() {
        return this.tp;
    }

    public void updatePrinter(TextPrinter tp) {
        this.tp=tp;
    }

    public void update_and_display(TextPrinter tp){
        this.updatePrinter(tp);
        tp.display_on_out();
    }
}
