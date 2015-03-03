package Implementation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Rook extends ChessPiece {

    public Rook(Color color) {
        setColor(color);
        if (getColor() == Color.white) {
            setImage("../Chess_Pictures/white/rook.png");
        }

        if (getColor() == Color.black) {
            setImage("../Chess_Pictures/black/rook.png");
        }
        setValue(5);
        setMoveLimit(8);
    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, Square[] board){
        return horizontal(initialPosition, finalPosition, board)||
                vertical(initialPosition, finalPosition, board);
    }
}
