import javax.swing.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Knight extends ChessPiece {

    public Knight(String color) {
        
        super.color=color;
        if (super.color == "white") {
        
            image = "Chess_Pictures/white/knight.png";
        }

        if (super.color == "black") {
            image = "Chess_Pictures/black/knight.png";
        }
    }
}
