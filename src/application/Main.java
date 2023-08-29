package application;


import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();

        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Sorce: ");
                ChessPosition source = UI.readChessPosition(input);

                boolean[][] possiblieMoves = chessMatch.possiblieMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possiblieMoves);

                System.out.println();
                System.out.print("Targe position: ");
                ChessPosition target = UI.readChessPosition(input);


                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }

        }
    }
}