import javax.swing.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Pawn extends ChessPiece {

    public Pawn(String color) {
        setColor(color);
        if (getColor() == "white") {
            setImage("Chess_Pictures/white/pawn.png");
        }

        if (getColor() == "black") {
            setImage("Chess_Pictures/black/pawn.png");
        }
        setValue(1);

    }
    

}
