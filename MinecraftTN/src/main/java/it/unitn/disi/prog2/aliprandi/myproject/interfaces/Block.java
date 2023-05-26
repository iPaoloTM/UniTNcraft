package it.unitn.disi.prog2.aliprandi.myproject.interfaces;

public interface Block {

    public boolean getFallsWithGravity();
    public boolean getFallsThrough();
    public char display();
    public boolean is_pickable();

    public int getId();

    public int getHardness();

    public void mine();

}
