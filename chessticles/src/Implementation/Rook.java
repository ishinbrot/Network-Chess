package Implementation;

import java.awt.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Rook extends ChessPiece {

    public Rook(Color color) {
        setColor(color);
        setPlayer(color);
        setName("Rook");
        if (getColor() == Color.white) {
            setImage("../Chess_Pictures/white/rook.png");
        }

        if (getColor() == Color.black) {
            setImage("../Chess_Pictures/black/rook.png");
        }
        setValue(5);
        setMoveLimit(8);
    }

    /**
     * 
     * @param initialPosition the initial position of the square array
     * @param finalPosition the final position in the square array
     * @param board the chessboard
     * @param lookForCheck if the user would like to look for check
     * @return
     */
    public boolean validMove(int[] initialPosition, int[] finalPosition, Square[] board, boolean lookForCheck){
        if (horizontal(initialPosition, finalPosition, board)||
                vertical(initialPosition, finalPosition, board)) {
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
