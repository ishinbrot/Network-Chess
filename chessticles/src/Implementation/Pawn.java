package Implementation;

import java.awt.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Pawn extends ChessPiece {

    public Pawn(Color color) {
        setColor(color);
        setPlayer(color);
        setName("Pawn");
        
        if (getColor() == Color.white) {
            setImage("../Chess_Pictures/white/pawn.png");
        }

        if (getColor() == Color.black) {
            setImage("../Chess_Pictures/black/pawn.png");
        }
        setValue(1);
        setMoveLimit(2);
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
        if (getColor()==Color.black){
            if (initialPosition[1]-finalPosition[1]<0){return false;}


        }else{
            if (initialPosition[1]-finalPosition[1]>0){return false;}
        }

        int ip=(initialPosition[1]*8)+initialPosition[0];
        int fp=(finalPosition[1]*8)+finalPosition[0];
        if (isMoved()){
            setMoveLimit(1);
        }

        if (Math.abs(initialPosition[1]-finalPosition[1])>getMoveLimit()){return false;}
        if (board[fp].getCurrentPiece()!=null){
            if ((Math.abs(initialPosition[0] - finalPosition[0])==Math.abs(initialPosition[1]-finalPosition[1]))&&
                    (Math.abs(initialPosition[0] - finalPosition[0])==1)){
                if (board[fp].getCurrentPiece().getColor()!=board[ip].getCurrentPiece().getColor()){
                    if (lookForCheck){
                        if (check(initialPosition, finalPosition, board)){
                            return false;
                        }
                    }
                    return true;
                }
                return false;

            }
            return false;
        }


        if( vertical(initialPosition, finalPosition, board)){
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
