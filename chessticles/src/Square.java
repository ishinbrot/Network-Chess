import javax.swing.*;
import java.awt.*;

/**
 * Created by Buzz on 2/11/2015.
 */
public class Square extends JPanel {
    ChessPiece currentPiece=null;
    int [] coord=new int[2];


    public Square ( LayoutManager layout){
        super.setLayout(layout);
    }

    public ChessPiece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(ChessPiece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public int[] getCoord() {
        return coord;
    }

    public void setCoord(int[] coord) {
        this.coord = coord;
    }
}
