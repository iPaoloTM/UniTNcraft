package it.unitn.disi.prog2.aliprandi.myproject.data;

public class Coordinates {

    public int row;
    public int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coordinates(int row, int col, int dim) throws WrongCoordinatesException {
        if (row >= 0 && col >= 0 && row < dim && col < dim) {
            this.row = row;
            this.col = col;
        } else {
            System.err.println("Coordinates out of bound, must be >=0 and <"+dim);
            throw new WrongCoordinatesException();
        }
    }
}
