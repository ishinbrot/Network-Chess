package Implementation;

import java.awt.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Queen extends ChessPiece {


    public Queen(Color color) {
        setColor(color);
        if (getColor() == Color.white) {
            setImage("../Chess_Pictures/white/queen.png");
        }

        if (getColor() == Color.black) {
            setImage("../Chess_Pictures/black/queen.png");
        }
        setValue(10);
    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, ChessBoard board){
        return horizontal(initialPosition, finalPosition, board)||
                vertical(initialPosition, finalPosition, board)||
                diagonal(initialPosition, finalPosition, board);
    }

}
