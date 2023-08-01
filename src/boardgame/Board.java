package boardgame;

public class Board {
    private int rows;
    private int colunms;
    private Piece[][] pieces;

    public Board(int rows, int colunms) {
        if (rows < 1 || colunms < 1){
            throw new BoardException("Erro ao criar tabuleiro, deve haver pelo menos uma coluna e um linhna");
        }
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

    public Piece piece(int row, int colunms){
        if(!positionExists(row, colunms)){
            throw new BoardException("Posicao nao está no tabuleiro");
        }
        return pieces[row][colunms];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posicao nao está no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Ja existe uma peca nessa posicao " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;

        pieces[position.getRow()][position.getColumn()] = null;

        return aux;

    }

    private boolean positionExists(int row, int colunm){
        return row >= 0 && row < rows && colunm >= 0 && colunm < colunms;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posicao nao está no tabuleiro");
        }
        return piece(position) != null;
    }



}
