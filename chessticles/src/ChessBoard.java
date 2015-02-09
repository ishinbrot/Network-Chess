import java.awt.*;
import javax.swing.*;

/**
 * Created by mike on 1/13/2015.
 */
public class ChessBoard extends JFrame {

    private Dimension boardSize;
    private JLayeredPane layeredPane;
    public JPanel chessBoard;
    public JPanel[] squares = new JPanel[64];
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
            squares[i] = square;
            chessBoard.add(squares[i]);

            int row = (i/8)%2;
            if(row == 0)
            {
                if(i%2 == 0)
                {
                    squares[i].setBackground(Color.white);
                }
                else squares[i].setBackground(Color.DARK_GRAY);
            }
            else
            {
                if(i%2 == 0)
                {
                    squares[i].setBackground(Color.DARK_GRAY);
                }
                else squares[i].setBackground(Color.white);
            }
        }
       // JPanel square = squares[2];
        


    }

    public void setSquareColor(int x, Color c)
    {
        squares[x].setBackground(c);
    }
    
    
    public void addPiece(String Image, int location)
    {
        ImageIcon image = new ImageIcon(this.getClass().getResource(Image));
        JLabel picLabel = new JLabel(image);
        squares[location].add(picLabel);
    }
    
    public void removePiece(int location)
    {
        JLabel picLabel = new JLabel();
        squares[location].add(picLabel);

    }
}

