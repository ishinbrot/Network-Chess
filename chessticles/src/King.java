import javax.swing.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class King extends ChessPiece {

    public King(String color) {
        super.color=color;
        if (super.color == "white") {
            image= "Chess_Pictures/white/king.png";
        }

        if (super.color == "black") {
            image = "Chess_Pictures/black/king.png";
        }
    }
}
