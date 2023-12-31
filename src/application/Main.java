package application;


import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();

        Scanner input = new Scanner(System.in);
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
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

                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }

        }

        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}