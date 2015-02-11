import javax.swing.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super.color=color;
        if (super.color == "white") {
            image= "Chess_Pictures/white/pawn.png";
        }

        if (super.color == "black") {
            image = "Chess_Pictures/black/pawn.png";
        }
    }
    
    public void move()
    {
        
        
    }
}
