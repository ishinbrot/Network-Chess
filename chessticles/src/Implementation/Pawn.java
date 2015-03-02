package Implementation;

import java.awt.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Pawn extends ChessPiece {

    public Pawn(Color color) {
        setColor(color);
        if (getColor() == Color.white) {
            setImage("../Chess_Pictures/white/pawn.png");
        }

        if (getColor() == Color.black) {
            setImage("../Chess_Pictures/black/pawn.png");
        }
        setValue(1);

    }
    

}
