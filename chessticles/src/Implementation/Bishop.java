package Implementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 import Implementation.ChessPiece;
 * Created by ianshinbrot on 1/14/15.
 */
public class Bishop extends ChessPiece {

    public Bishop(String color) {
        setColor(color);
        if (getColor()=="white") {
            setImage("Chess_Pictures/white/bishop.png");
        }
        
        if (getColor()=="black") {
            setImage("Chess_Pictures/black/bishop.png");
        }
        
        setValue(3);
    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, ChessBoard board){
        return diagonal(initialPosition, finalPosition, board);
    }
    
}
