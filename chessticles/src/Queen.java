import javax.swing.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Queen extends ChessPiece {


    public Queen(String color) {
        setColor(color);
        if (getColor() == "white") {
            setImage("Chess_Pictures/white/queen.png");
        }

        if (getColor() == "black") {
            setImage("Chess_Pictures/black/queen.png");
        }
        setValue(10);
    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, ChessBoard board){
        return horizontal(initialPosition, finalPosition, board)||
                vertical(initialPosition, finalPosition, board)||
                diagonal(initialPosition, finalPosition, board);
    }

}
