import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 import ChessPiece;
 * Created by ianshinbrot on 1/14/15.
 */
public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super.color=color;
        if (super.color=="white") {
            image = "Chess_Pictures/white/bishop.png";
        }
        
        if (super.color=="black") {
            image = "Chess_Pictures/black/bishop.png";
        }
        
        
    }
    
}
