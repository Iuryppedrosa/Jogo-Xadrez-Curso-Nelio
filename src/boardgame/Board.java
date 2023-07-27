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

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColunms(int colunms) {
        this.colunms = colunms;
    }

    public Piece piece(int row, int colunms){
        return pieces[row][colunms];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }

}
