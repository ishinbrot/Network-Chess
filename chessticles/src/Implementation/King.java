package Implementation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class King extends ChessPiece {

    public King(Color color) {
        setColor(color);
        setPlayer(color);
        if (getColor() == Color.white) {
            setImage("../Chess_Pictures/white/king.png");
        }

        if (getColor() == Color.black) {
            setImage("../Chess_Pictures/black/king.png");
        }
        setValue(0);
        setMoveLimit(1);
        setName("King");

    }

    public boolean validMove(int[] initialPosition, int[] finalPosition, Square[] board, boolean lookForCheck) {
        if (Math.abs(initialPosition[0] - finalPosition[0])==2 && initialPosition[1]==finalPosition[1]) {
            if (!this.isMoved()) {
                if (finalPosition[0] > initialPosition[0]) {
                    Square s = board[initialPosition[1] * 8 + 7];
                    if (!s.getCurrentPiece().isMoved()) {
                        for (int i = initialPosition[0]+1; i < 7; i++) {
                            if (board[initialPosition[1] * 8 + i].getCurrentPiece() != null) {
                                return false;
                            }
                        }
                        return true;

                    } else return false;
                }

               else if (finalPosition[0] < initialPosition[0]) {
                    Square s = board[initialPosition[1] * 8];
                    if (!s.getCurrentPiece().isMoved()) {
                        for (int i = 1; i <initialPosition[0] ; i++) {
                            if (board[initialPosition[1] * 8 + i].getCurrentPiece() != null) {
                                return false;
                            } 
                        }
                        return true;
                    } else return false;
                }
            }
        }
        if (Math.abs(initialPosition[1] - finalPosition[1]) > getMoveLimit()) {
            return false;
        }
        if (Math.abs(initialPosition[0] - finalPosition[0]) > getMoveLimit()) {
            return false;
        }

        
            if (horizontal(initialPosition, finalPosition, board) ||
                    vertical(initialPosition, finalPosition, board) ||
                    diagonal(initialPosition, finalPosition, board)) {
                if (lookForCheck) {
                    if (check(initialPosition, finalPosition, board)) {
                        this.inCheck();
                        return false;
                    }

                }
                this.outCheck();
                return true;
            }
            return false;


        
    }
}
