package it.unitn.disi.prog2.aliprandi.myproject.System;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.TextPrinter;

public class MapPrinter implements TextPrinter {

    private int dim;
    private Block matrix[][];
    @Override
    public void display_on_out() {
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                System.out.print(matrix[i][j].display() + " ");
            }
            System.out.println();
        }
    }

    public void update(Block[][] map, int dim) {
        this.matrix=map;
        this.dim=dim;
    }
}
