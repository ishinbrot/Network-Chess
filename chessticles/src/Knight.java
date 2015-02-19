import javax.swing.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Knight extends ChessPiece {

    public Knight(String color) {
        
        setColor(color);
        if (getColor() == "white") {
        
            setImage("Chess_Pictures/white/knight.png");
        }

        if (getColor() == "black") {
            setImage("Chess_Pictures/black/knight.png");
        }
        setValue(3);
    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, ChessBoard board){
        return L_shape(initialPosition, finalPosition, board);
    }
}
