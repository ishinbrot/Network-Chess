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

    /**
     * 
     * @return the default color of the square
     */
    public Color getDefaultColor() {
        return defaultColor;
    }

    /**
     * 
     * @param defaultColor the color that the default square will have
     */
    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    /**
     * 
     * @return the chess piece of a current square
     */
    public ChessPiece getCurrentPiece() {
        return currentPiece;
    }

    /**
     * this methods sets the chess piece in a given square
     * @param currentPiece the current chess piece of the square
     */
    public void setCurrentPiece(ChessPiece currentPiece) {
        this.currentPiece = currentPiece;
    }
    

    /**
     * 
     * @return the current coordinates of the square
     */
    public int[] getCoord() {
        return coord;
    }

    /**
     * 
     * @param coord the coordinates of the square, in a two dimensional array
     */
    public void setCoord(int[] coord) {
        this.coord = coord;
    }
    

}
