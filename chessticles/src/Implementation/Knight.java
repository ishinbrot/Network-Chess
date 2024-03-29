package Implementation;

import java.awt.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Knight extends ChessPiece {

    public Knight(Color color) {
        
        setColor(color);
        setPlayer(color);
        setName("Knight");
        if (getColor() == Color.white) {
        
            setImage("../Chess_Pictures/white/knight.png");
        }

        if (getColor() == Color.black) {
            setImage("../Chess_Pictures/black/knight.png");
        }
        setValue(3);
        setMoveLimit(3);
    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, Square[] board, boolean lookForCheck){

        if (L_shape(initialPosition, finalPosition, board)) {
            if (lookForCheck){
                if (check(initialPosition, finalPosition, board)){
                    return false;
                }

            }
            return true;
        }
        return false;
    }
}
