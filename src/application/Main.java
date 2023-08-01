package application;


import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();

        Scanner input = new Scanner(System.in);

        while(true){
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Sorce: ");
            ChessPosition source = UI.readChessPosition(input);

            System.out.println();
            System.out.print("Targe position: ");
            ChessPosition target = UI.readChessPosition(input);


            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }

    }
}