package Implementation;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class King extends ChessPiece {

    public King(String color) {
        setColor(color);
        if (getColor() == "white") {
            setImage("../Chess_Pictures/white/king.png");
        }

        if (getColor() == "black") {
            setImage("../Chess_Pictures/black/king.png");
        }
    }
}
