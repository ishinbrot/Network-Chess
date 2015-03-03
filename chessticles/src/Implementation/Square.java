package Implementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Buzz on 2/11/2015.
 */
public class Square extends JPanel{
    ChessPiece currentPiece = null;
    Color defaultColor;

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

    public void RemovePiece(ChessPiece currentPiece) {this.currentPiece = null;}
    public int[] getCoord() {
        return coord;
    }

    public void setCoord(int[] coord) {
        this.coord = coord;
    }
}
