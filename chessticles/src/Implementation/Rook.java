package Implementation;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Rook extends ChessPiece {

    public Rook(String color) {
        setColor(color);
        if (getColor() == "white") {
            setImage("Chess_Pictures/white/rook.png");
        }

        if (getColor() == "black") {
            setImage("Chess_Pictures/black/rook.png");
        }
        setValue(5);
    }
}
