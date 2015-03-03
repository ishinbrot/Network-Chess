package Implementation;

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

    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, Square[] board){
        if (Math.abs(initialPosition[1]-finalPosition[1])>getMoveLimit()){return false;}
        if (Math.abs(initialPosition[0]-finalPosition[0])>getMoveLimit()){return false;}
        return horizontal(initialPosition, finalPosition, board)||
                vertical(initialPosition, finalPosition, board)||
                diagonal(initialPosition, finalPosition, board);

    }
}
