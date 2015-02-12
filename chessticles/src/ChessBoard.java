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
            //JPanel square = new JPanel(new BorderLayout());
            JPanel s=new Square(new BorderLayout());
            squares[i] = s;
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

    }

    public void setSquareColor(int x, Color c)
    {
        squares[x].setBackground(c);
    }
    
    
    public void addPiece(ChessPiece chessPiece, int location)
    {
        ImageIcon image = new ImageIcon(this.getClass().getResource(chessPiece.image));
        JLabel picLabel = new JLabel(image);
        System.out.println(picLabel.getIcon().toString());
        squares[location].add(picLabel);
    }
    
    public void removePiece(int location)
    {
        JLabel picLabel = new JLabel();
        System.out.println(picLabel.getText());
        squares[location].add(picLabel);
    }
    
    public void startPlayer1()
    {
        String color = "white";
        ChessPiece rook1 = new Rook(color);
                ChessPiece rook2 = new Rook(color);
        ChessPiece knight1 = new Knight(color);
        ChessPiece knight2 = new Knight(color);
        ChessPiece bishop1 = new Bishop(color);
        ChessPiece bishop2 = new Bishop(color);
        ChessPiece queen = new Queen(color);
        ChessPiece king = new King(color);
        ChessPiece pawn1 = new Pawn(color);
        ChessPiece pawn2 = new Pawn(color);
        ChessPiece pawn3 = new Pawn(color);
        ChessPiece pawn4 = new Pawn(color);
        ChessPiece pawn5 = new Pawn(color);
        ChessPiece pawn6 = new Pawn(color);
        ChessPiece pawn7 = new Pawn(color);
        ChessPiece pawn8 = new Pawn(color);
        
        // place white pieces
        
        for (int i=0; i<16; i++)
        {
            if (i%1 ==0 || i % 8 == 0)
            {
                addPiece(rook1, i);
            }
        }
        
    }
    
    public void startPlayer2()
    {
        // place black pieces
        
    }
}

