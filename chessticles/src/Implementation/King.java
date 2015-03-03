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
    }
}
