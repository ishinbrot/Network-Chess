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
    
    public ChessPiece upgradePawn(ChessPiece pawn)
    {
        String input="";
        do {
            if ((this.getCoord()[0]==0 && pawn.getColor()==Color.black) || this.getCoord()[0]==8 && pawn.getColor()==Color.white) {
                String[] choices = {"Queen", "Bishop", "Rook", "Knight"};
                 input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                        "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        choices, // Array of choices
                        choices[1]); // Initial choice
            }
        } while (input=="");
        
        if (input=="Queen")
        {
            return new Queen(pawn.getColor());
        }
        if (input=="Rook")
        {
            return new Rook(pawn.getColor());
        }
        if (input=="Knight") {
            return new Knight(pawn.getColor());
        }
        else // this should never happen so I'll close the program
        {
            this.Error_Message("Something is wrong with the program, aborting...");
            System.exit(2);
        }
        return null;
    }

    public void Error_Message(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }
}
