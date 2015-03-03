package Implementation;

import Implementation.Bishop;
import Implementation.ChessBoard;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by Buzz on 2/19/2015.
 */

public class ChessGame {//extends ChessRules{
    private ChessBoard board;



    private ChessPiece highlightedPiece;
    public static final int player1 = 0;
    public static final int player2 = 1;
    int playerToMove = player1;

    public boolean test() {

        return true;
    }

    
    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public void addPiece(ChessPiece chessPiece, int location) {
        board.squares[location].setCurrentPiece(chessPiece);
        chessPiece.setPosition(location);
        ImageIcon image = new ImageIcon(this.getClass().getResource(chessPiece.getImage()));
        JLabel picLabel = new JLabel(image);
        //System.out.println(chessPiece.image);
        //System.out.println(picLabel.getIcon().toString());
        board.squares[location].add(picLabel);
    }

    public void startPlayer2() {
        Color color = Color.black;

        addPiece(new Rook(color), 0);
        addPiece(new Knight(color), 1);
        addPiece(new Bishop(color), 2);
        addPiece(new King(color), 3);
        addPiece(new Queen(color), 4);
        addPiece(new Bishop(color), 5);
        addPiece(new Knight(color), 6);
        addPiece(new Rook(color), 7);
        addPiece(new Pawn(color), 8);
        addPiece(new Pawn(color), 9);
        addPiece(new Pawn(color), 10);
        addPiece(new Pawn(color), 11);
        addPiece(new Pawn(color), 12);
        addPiece(new Pawn(color), 13);
        addPiece(new Pawn(color), 14);
        addPiece(new Pawn(color), 15);

    }

    public void startPlayer1() {
        // place black pieces
        Color color = Color.white;
        addPiece(new Rook(color), 63);
        addPiece(new Knight(color), 62);
        addPiece(new Bishop(color), 61);
        addPiece(new Queen(color), 60);
        addPiece(new King(color), 59);
        addPiece(new Bishop(color), 58);
        addPiece(new Knight(color), 57);
        addPiece(new Rook(color), 56);
        addPiece(new Pawn(color), 55);
        addPiece(new Pawn(color), 54);
        addPiece(new Pawn(color), 53);
        addPiece(new Pawn(color), 52);
        addPiece(new Pawn(color), 51);
        addPiece(new Pawn(color), 50);
        addPiece(new Pawn(color), 49);
        addPiece(new Pawn(color), 48);

    }

    public int nextPlayer(int player) {
        if (player == player1) return player2;
        return player1;
    }

    public Square[] getPath(int[] initialPosition, int[] finalPosition) {
        int len = Math.max(Math.abs(initialPosition[1] - finalPosition[1]), Math.abs(initialPosition[0] - finalPosition[0]));
        Square[] path = new Square[len];

        return null;
    }

    public boolean validatePath(Square[] path) {
        return false;
    }


}
