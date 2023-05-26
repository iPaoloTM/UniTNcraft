package it.unitn.disi.prog2.aliprandi.myproject.data;

import it.unitn.disi.prog2.aliprandi.myproject.data.AbstractBlock;
import it.unitn.disi.prog2.aliprandi.myproject.data.AirBlock;
import it.unitn.disi.prog2.aliprandi.myproject.data.SandBlock;
import it.unitn.disi.prog2.aliprandi.myproject.data.WaterBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.SmeltableBlock;

import java.util.Random;
import java.util.Scanner;

public class Map {
    public Block matrix[][];

    public int dim;

    public Map() {
        System.out.println("Enter Map dimensions:");

        Scanner myObj = new Scanner(System.in);

        this.dim = myObj.nextInt();

        matrix = new AbstractBlock[this.dim][this.dim];

        Random rand = new Random();

        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                matrix[i][j] = new AirBlock();
            }
        }

        addStoneLayer(this.dim);
        addStoneLayer(this.dim-1);
        addSoil(this.dim-2);
        addSoil(this.dim-3);
        addSoil(this.dim-4);
        RaddSoil(this.dim-5);

        addRiver();

        for (int i = 0 ; i < 20; i++){

            int x = rand.nextInt(2);

            Block b=null;

            switch (x) {
                case 0: b=new WaterBlock();
                    break;
                case 1: b=new SandBlock();
                    break;
            }

            int r = rand.nextInt(this.dim);
            int c = rand.nextInt(this.dim);

            this.insert_at_coords(r,c,b);
        }
    }

    public Block getBlock(int i, int j) {
        Block b = this.matrix[i][j];
        AirBlock a = new AirBlock();
        change_cell(i,j,a);
        return b;
    }

    public void addRandomBlock() {
        Random rand = new Random();

        int r = rand.nextInt(this.dim);
        int c = rand.nextInt(this.dim);

        int t = rand.nextInt(10);

        Block b=null;

        switch(t) {
            case 0:
                b=new AirBlock();
                break;
            case 1:
                b=new WaterBlock();
                break;
            case 2:
                b=new SandBlock();
                break;
            case 3:
                b=new GlassBlock();
                break;
            case 4:
                b=new DirtBlock();
                break;
            case 5:
                b=new StoneBlock();
                break;
            case 6:
                b=new RawCoalBlock();
                break;
            case 7:
                b=new RawIronBlock();
                break;
            case 8:
                b=new RawGoldBlock();
                break;
            case 9:
                b=new TorchBlock();
                break;
        }

        this.change_cell(r,c,b);
    }

    public boolean isSmeltable (int i, int j) {
        return (this.matrix[i][j] instanceof SmeltableBlock) ? true : false;
    }

    public SmeltableBlock getSmeltableBlock(int i, int j) throws BlockErrorException {
        return (SmeltableBlock) this.matrix[i][j];
    }
    public void display() {
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                System.out.print(matrix[i][j].display() + " ");
            }
            System.out.println();
        }
    }

    public void change_cell(int i, int j, Block b) {

        this.matrix[i][j] = null;
        this.matrix[i][j]=b;

        this.display();
    }

    public void swap(int i, int j) {

        Block fallingblock = this.matrix[i][j];

        this.matrix[i][j] = this.matrix[i+1][j];
        this.matrix[i+1][j] = fallingblock; //the block has fallen

        System.out.println("swap");

        this.display();
    }

    public void insert_at_coords(int i, int j, Block b) {
        //System.out.println("Inserting "+b);
        change_cell(i,j,b);
        //System.out.println("gravity of block at ["+i+","+j+"] is: "+this.matrix[i][j].getFallsWithGravity());
        if (this.matrix[i][j].getFallsWithGravity()) {
            while (i+1 < this.dim && this.matrix[i + 1][j].getFallsThrough()==true) {
                    //System.out.println("porosity of block at ["+(i+1)+","+j+"] is: "+this.matrix[i+1][j].getFallsThrough());
                    swap(i, j);
                    i++;
                if (i==0) {
                    AirBlock a = new AirBlock();
                    this.matrix[i+1][j]=a;
                }
            }
        }
    }

    private void addRowsOfWater() {

        for (int x=0; x<dim; x++) {
            WaterBlock w = new WaterBlock();
            insert_at_coords(0,x, w);
        }
    }

    private void addSoil(int depth_level) {

        for (int x=0; x<this.dim; x++) {
            DirtBlock d = new DirtBlock();
            insert_at_coords(depth_level-1,x, d);
        }
    }

    private void RaddSoil(int depth_level) {

        Random r = new Random();

        for (int x=0; x<this.dim; x++) {
            int c = r.nextInt(2);
            if (c==0) {
                DirtBlock d = new DirtBlock();
                insert_at_coords(depth_level-1,x, d);
            }
        }
    }

    private void addStoneLayer(int depth_level) {

        Random r = new Random();
        Block b = new AirBlock();

        for (int x=0; x<this.dim; x++) {

            switch (r.nextInt(13)) {
                case 0:
                    b = new StoneBlock();
                    break;
                case 1:
                    b = new StoneBlock();
                    break;
                case 2:
                    b = new StoneBlock();
                    break;
                case 3:
                    b = new RawIronBlock();
                    break;
                case 4:
                    b = new RawIronBlock();
                    break;
                case 5:
                    b= new RawGoldBlock();
                    break;
                case 6:
                    b = new DirtBlock();
                    break;
                case 7:
                    b = new DirtBlock();
                    break;
                case 8:
                    b = new DirtBlock();
                    break;
                case 9:
                    b = new DirtBlock();
                    break;
                case 10:
                    b = new DirtBlock();
                    break;
                case 11:
                    b = new RawCoalBlock();
                    break;
                case 12:
                    b = new RawCoalBlock();
                    break;
            }

            insert_at_coords(depth_level-1,x, b);
        }
    }

    public void addRiver() {
        addRowsOfWater();
    }

    public void addSea() {
        addRowsOfWater();
        addRowsOfWater();
        addRowsOfWater();
    }

    public boolean is_pickable(int i, int j) {
        return this.matrix[i][j].is_pickable();
    }

    public Block gimme_pickable(int i, int j) {
        Block b = null;
        if (this.is_pickable(i,j)) {
            b = this.matrix[i][j];
            AirBlock a = new AirBlock();
            change_cell(i,j,a);
        } else {
            System.out.println("This block is not pickable");
            NullBlock n=new NullBlock();
            return n;
        }
        return b;
    }


}
