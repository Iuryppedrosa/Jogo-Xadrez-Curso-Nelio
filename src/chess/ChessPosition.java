package chess;

import boardgame.Position;

public class ChessPosition
{
    private char columm;
    private int row;

    public ChessPosition(char columm, int row) {
        if(columm < 'a' || columm > 'h' || row < 1 || row > 8){
            throw new ChessException("Erro ao instanciar uma posicao no xadrex.");
        }
        this.columm = columm;
        this.row = row;
    }

    public char getColumm() {
        return columm;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition(){ // ># significa protected no IML
        return new Position(8 - row, columm - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + columm + row;
    }

}
