package Implementation;

import java.awt.*;
/**
 import Implementation.ChessPiece;
 * Created by ianshinbrot on 1/14/15.
 */
public class Bishop extends ChessPiece {

    public Bishop(Color color) {
        setColor(color);
        setPlayer(color);
        setName("Bishop");
        if (getColor()==Color.white) {
            setImage("../Chess_Pictures/white/bishop.png");
        }
        
        if (getColor()==Color.black) {
            setImage("../Chess_Pictures/black/bishop.png");
        }
        
        setValue(3);
        setMoveLimit(8);
    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, Square[] board){
        return diagonal(initialPosition, finalPosition, board);
    }
    
}
