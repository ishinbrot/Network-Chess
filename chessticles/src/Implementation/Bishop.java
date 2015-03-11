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

    /**
     * 
     * @param initialPosition the initial position of the square array
     * @param finalPosition the final position in the square array
     * @param board the chessboard
     * @param lookForCheck if the user would like to look for check
     * @return
     */
    public boolean validMove(int[] initialPosition, int[] finalPosition, Square[] board, boolean lookForCheck) {


        if (diagonal(initialPosition, finalPosition, board)) {
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
