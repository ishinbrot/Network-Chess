import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Created by mike on 1/13/2015.
 */
public class ChessBoard extends JFrame {

    private Dimension boardSize;
    private JLayeredPane layeredPane;
    private JPanel chessBoard;
    private JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;

    public ChessBoard()
    {
        //Initialize Board and it's components

        boardSize = new Dimension(600, 600);
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);

        //Add the Board to the Pane

        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8,8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0,0,boardSize.width,boardSize.height);

        //Add Squares and Color them

        for(int i=0;i<64;i++)
        {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            int row = (i/8)%2;
            if(row == 0)
            {
                if(i%2 == 0)
                {
                    square.setBackground(Color.DARK_GRAY);
                }
                else square.setBackground(Color.white);
            }
            else
            {
                if(i%2 == 0)
                {
                    square.setBackground(Color.white);
                }
                else square.setBackground(Color.DARK_GRAY);
            }
        }
    }
}
