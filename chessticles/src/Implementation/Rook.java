package Implementation;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class Rook extends ChessPiece {

    public Rook(String color) {
        setColor(color);
        if (getColor() == "white") {
            setImage("../Chess_Pictures/white/rook.png");
        }

        if (getColor() == "black") {
            setImage("../Chess_Pictures/black/rook.png");
        }
        setValue(5);
    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, ChessBoard board){
        return horizontal(initialPosition, finalPosition, board)||
                vertical(initialPosition, finalPosition, board);
    }
}