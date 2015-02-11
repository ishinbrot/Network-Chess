import javax.swing.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Queen extends ChessPiece {

    public Queen(String color) {
        super.color=color;
        if (super.color == "white") {
            image= "Chess_Pictures/white/queen.png";
        }

        if (super.color == "black") {
            image = "Chess_Pictures/black/queen.png";
        }
    }
}
