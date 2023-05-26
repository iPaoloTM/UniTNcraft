package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;

import java.util.Random;

public abstract class AbstractBlock implements Block {

    public char contenuto;
    public boolean falls_with_gravity;
    public boolean falls_through;
    public String blockname;
    public boolean pickable;
    int id;
    public int hardness;

    public AbstractBlock() {
        this.pickable=false;
        Random r = new Random();
        this.id = r.nextInt(999);
        switch (this.display()) {
            case '.':
            case 'D':
            case 'W':
            case 'S':
                this.hardness=0;
                break;
            case 'F':
            case 'A':
            case 'C':
                this.hardness=3;
                break;
            case 'P':
                this.hardness=5;
                break;
        }
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean is_pickable() {
        return this.pickable;
    }

    public boolean getFallsWithGravity() {
        return this.falls_with_gravity;
    }

    public boolean getFallsThrough() {
        return this.falls_through;
    }
    public char display() {
        return this.contenuto;
    }

    @Override
    public String toString() {
        return "AbstractBlock{" +
                "contenuto=" + contenuto +
                ", falls_with_gravity=" + falls_with_gravity +
                ", falls_through=" + falls_through +
                ", blockname='" + blockname +
                ", id='" + id + '\'' +
                '}';
    }



}
