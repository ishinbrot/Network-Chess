
import javax.swing.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Rook extends ChessPiece {

    public Rook(String color) {
        super.color=color;
        if (super.color == "white") {
            image ="Chess_Pictures/white/rook.png";
        }

        if (super.color == "black") {
            image = "Chess_Pictures/black/rook.png";
        }
    }
}
