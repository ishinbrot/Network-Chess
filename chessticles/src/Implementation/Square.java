package Implementation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Buzz on 2/11/2015.
 */
public class Square extends JPanel{
    private ChessPiece currentPiece = null;
    private Color defaultColor;

    int[] coord = new int[2];
    public Square(LayoutManager layout) {
        super.setLayout(layout);


    }
    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }
    public ChessPiece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(ChessPiece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public void removePiece(ChessPiece currentPiece) {this.currentPiece = null;}
    public int[] getCoord() {
        return coord;
    }

    public void setCoord(int[] coord) {
        this.coord = coord;
    }
    

}
