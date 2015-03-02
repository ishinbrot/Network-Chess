package Implementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Buzz on 2/11/2015.
 */
public class Square extends JPanel implements MouseListener{
    ChessPiece currentPiece=null;
    Color defaultColor;



    int [] coord=new int[2];
    boolean clicked=false;
    public Square ( LayoutManager layout){
        super.setLayout(layout);
        //addMouseListener(this);
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

    public int[] getCoord() {
        return coord;
    }

    public void setCoord(int[] coord) {
        this.coord = coord;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(this.getCurrentPiece().getName());
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
}
