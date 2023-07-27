package boardgame;

public class Board {
    private int rows;
    private int colunms;

    private Piece[][] pieces;

    public Board(int rows, int colunms) {
        this.rows = rows;
        this.colunms = colunms;
        pieces = new Piece[rows][colunms];
    }

    public int getRows() {
        return rows;
    }

    public int getColunms() {
        return colunms;
    }
}
