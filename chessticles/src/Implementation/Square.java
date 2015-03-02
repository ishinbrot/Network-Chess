package Implementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Buzz on 2/11/2015.
 */
public class Square extends JPanel{
    ChessPiece currentPiece=null;
    int [] coord=new int[2];
    boolean clicked=false;
    public Square ( LayoutManager layout){
        super.setLayout(layout);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getCurrentPiece().getMoveLimit();
                System.out.println();
                ChessGame.CurrentPosition = getCurrentPiece().getPosition();

                if (getCurrentPiece() != null)           // check if valid piece clicked
                {

                   currentPiece = getCurrentPiece();
                    clicked=true;
                    setBackground(Color.ORANGE);        // selected square turns gray
                    int position = getCurrentPiece().getPosition();
                }

                if (getBackground() == Color.ORANGE)       // change to color that valid squares will be
                {
                    // move piece here
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
