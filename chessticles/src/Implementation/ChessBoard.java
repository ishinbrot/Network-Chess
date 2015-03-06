package Implementation;

import Implementation.Bishop;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.*;

/**
 * Created by mike on 1/13/2015.
 */
public class ChessBoard extends JFrame implements MouseListener{

    private Dimension boardSize;
    private  NetworkChess networkChess;
    private JLayeredPane layeredPane;
    private JPanel chessBoard;
    private ChessPiece highlightedPiece;
    private int[] highlightedPosition;
    private boolean PieceSelected = false;
    public Square[] squares = new Square[64];
    public int currentPlayer;

    public ChessBoard() {
        //Initialize Board and it's components

        boardSize = new Dimension(600, 600);
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);

        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);

        //Add the Board to the Pane

        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        //Add Squares and Color them

        for (int i = 0; i < 64; i++) {

            Square s = new Square(new BorderLayout());
            s.add(new JLabel());


            s.setCoord(new int[]
                            {
                                    (i % 8), (i / 8)
                            }

            );
            squares[i] = s;
            chessBoard.add(squares[i]);

            int row = (i / 8) % 2;
            if (row == 0)

            {
                if (i % 2 == 0) {
                    squares[i].setBackground(Color.white);
                    squares[i].setDefaultColor(Color.white);
                } else {
                    squares[i].setBackground(Color.DARK_GRAY);
                    squares[i].setDefaultColor(Color.DARK_GRAY);
                }
            } else
            
            {
                if (i % 2 == 0) {
                    squares[i].setBackground(Color.DARK_GRAY);
                    squares[i].setDefaultColor(Color.DARK_GRAY);
                } else {
                    squares[i].setBackground(Color.white);
                    squares[i].setDefaultColor(Color.white);
                }
            }
        }

    }
    public Square getSquare(int i) {
        return squares[i];

    }



    public void addPiece(ChessPiece chessPiece, int location) {
        squares[location].setCurrentPiece(chessPiece);
        chessPiece.setPosition(location);
        ImageIcon image = new ImageIcon(this.getClass().getResource(chessPiece.getImage()));
        JLabel picLabel = new JLabel(image);
        squares[location].add(picLabel);
        chessBoard.repaint();
        chessBoard.revalidate();
    }


    public ChessPiece removePiece(int location) {
        ChessPiece piece = squares[location].getCurrentPiece();
        squares[location].setCurrentPiece(null);
        squares[location].removeAll();
        squares[location].add(new JLabel());
        chessBoard.repaint();
        chessBoard.revalidate();
        return piece;
    }

    public void startPlayer1() {
        Color color = Color.white;

        addPiece(new Rook(color), 0);
        addPiece(new Knight(color), 1);
        addPiece(new Bishop(color), 2);
        addPiece(new King(color), 3);
        addPiece(new Queen(color), 4);
        addPiece(new Bishop(color), 5);
        addPiece(new Knight(color), 6);
        addPiece(new Rook(color), 7);
        addPiece(new Pawn(color), 8);
        addPiece(new Pawn(color), 9);
        addPiece(new Pawn(color), 10);
        addPiece(new Pawn(color), 11);
        addPiece(new Pawn(color), 12);
        addPiece(new Pawn(color), 13);
        addPiece(new Pawn(color), 14);
        addPiece(new Pawn(color), 15);

    }

    public void startPlayer2() {
        // place black pieces
        Color color = Color.black;
        addPiece(new Rook(color), 63);
        addPiece(new Knight(color), 62);
        addPiece(new Bishop(color), 61);
        addPiece(new Queen(color), 60);
        addPiece(new King(color), 59);
        addPiece(new Bishop(color), 58);
        addPiece(new Knight(color), 57);
        addPiece(new Rook(color), 56);
        addPiece(new Pawn(color), 55);
        addPiece(new Pawn(color), 54);
        addPiece(new Pawn(color), 53);
        addPiece(new Pawn(color), 52);
        addPiece(new Pawn(color), 51);
        addPiece(new Pawn(color), 50);
        addPiece(new Pawn(color), 49);
        addPiece(new Pawn(color), 48);
        if (currentPlayer==2)
            blackFirst();

    }


    public boolean horizontal(int[] initialPosition, int[] finalPosition) {
        int test;
        if (Arrays.equals(initialPosition, finalPosition)) {
            return false;
        }
        if (initialPosition[1] == finalPosition[1]) {

            int min = Math.min(initialPosition[0], finalPosition[0]);
            int max = Math.max(initialPosition[0], finalPosition[0]);
            for (int i = min++; i <= max; i++) {
                test = (initialPosition[1] * 8) + i;
                if (test % 8 == initialPosition[0]) {
                    continue;
                }
                if (squares[test].getCurrentPiece() != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean vertical(int[] initialPosition, int[] finalPosition) {
        int test;
        if (Arrays.equals(initialPosition, finalPosition)) {
            return false;
        }
        if (initialPosition[0] == finalPosition[0]) {

            int min = Math.min(initialPosition[1], finalPosition[1]);
            int max = Math.max(initialPosition[1], finalPosition[1]);
            for (int i = min++; i <= max; i++) {
                test = (i * 8) + initialPosition[0];
                if (test / 8 == initialPosition[1]) {
                    continue;
                }
                if (squares[test].getCurrentPiece() != null) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public boolean diagonal(int[] initialPosition, int[] finalPosition) {
        int[] test = new int[2];
        int max;
        if (initialPosition[0] < finalPosition[0]) {
            test[0] = initialPosition[0];
            test[1] = initialPosition[1];
        } else {
            test[0] = finalPosition[0];
            test[1] = finalPosition[1];
        }
        if (Arrays.equals(initialPosition, finalPosition)) {
            return false;
        }
        if (Math.abs(initialPosition[0] - finalPosition[0]) == Math.abs(initialPosition[1] - finalPosition[1])) {
            if ((initialPosition[0] < finalPosition[0] && initialPosition[1] < finalPosition[1]) ||
                    (initialPosition[0] > finalPosition[0] && initialPosition[1] > finalPosition[1])) {
                //test[0]=Math.min(initialPosition[0], finalPosition[0]);
                //test[1]=Math.min(initialPosition[1], finalPosition[1]);
                max = Math.abs(initialPosition[0] - finalPosition[0]);
                for (int i = 0; i < max; i++) {
                    test[0] += i;
                    test[1] += i;
                    if (Arrays.equals(test, initialPosition)) {
                        continue;
                    }
                    if (squares[(test[1] * 8) + test[0]].getCurrentPiece() != null) {
                        System.out.println(((test[1] * 8) + test[0]));
                        return false;
                    }
                }
            } else {

                max = Math.abs(initialPosition[0] - finalPosition[0]);
                for (int i = 0; i <= max; i++) {
                    test[0] += i;
                    test[1] -= i;
                    if (Arrays.equals(test, initialPosition)) {
                        continue;
                    }
                    //System.out.println(((test[1]*8)+test[0]));
                    if (squares[((test[1] * 8) + test[0])].getCurrentPiece() != null) {
                        //System.out.println(((test[1]*8)+test[0]));
                        return false;
                    }
                }
            }

            return true;
        }
        return false;
    }

    public boolean L_shape(int[] initialPosition, int[] finalPosition) {
        if (Arrays.equals(initialPosition, finalPosition)) {
            return false;
        }
        if (Math.abs(initialPosition[0] - finalPosition[0]) == 2 && Math.abs(initialPosition[1] - finalPosition[1]) == 1) {
            return true;
        }
        if (Math.abs(initialPosition[0] - finalPosition[0]) == 1 && Math.abs(initialPosition[1] - finalPosition[1]) == 2) {
            return true;
        }
        return false;
    }
    public void connection(String IP_Address,Boolean black)
    {
        try {
            networkChess = new NetworkChess(IP_Address);
            if(black){
                //networkChess.blackfirstSend();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.error_Message("Network Game could not be established. Aborting now");
        }

    }
    public void deselectCurrentSquare()
    {
        PieceSelected=false;
        Square originalSquare = squares[highlightedPosition[1] * 8 + highlightedPosition[0]];
        originalSquare.setBackground(originalSquare.getDefaultColor());
        
    }
    
    public Square findSquareatLocation(MouseEvent e) {
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());
         return(Square) c.getParent();
        
    }
   public void selectPiece(Square s)
   {
       highlightedPiece = s.getCurrentPiece();
       highlightedPosition = s.getCoord();
       PieceSelected = true;
       s.setBackground(Color.ORANGE);
       
   }
    
    public void blackFirst()
    {

        String theirMove = networkChess.sendAndWait("black");

        this.backGroundChange(theirMove, "");
    }
    public void makeMove(int[] newPosition, String pieceName)
    {
        this.removePiece(newPosition[1] * 8 + newPosition[0]);


      
      

        this.addPiece(highlightedPiece, newPosition[1] * 8 + newPosition[0]);
        
        this.removePiece(highlightedPosition[1] * 8 + highlightedPosition[0]);
        this.deselectCurrentSquare();
    }
    public String upgradablePawn(Square s){

        
        if ((s.getCoord()[1]==0 && s.getCurrentPiece().getColor()==Color.black) || s.getCoord()[1]==7 && s.getCurrentPiece().getColor()==Color.white) {
            ChessPiece piece;
            do {
                 piece = this.upgradePawn(s.getCurrentPiece());
            } while (piece==null);
            this.removePiece(s.getCoord()[1]*8 + s.getCoord()[0]);
            this.addPiece(piece, s.getCoord()[1]*8 + s.getCoord()[0]);
            
            return piece.getName();
        }
        return "";
    }
    public void mouseClicked(MouseEvent e)

    {
        if (!PieceSelected) {
            Square s = this.findSquareatLocation(e);
            if (s.getCurrentPiece() == null) {
                this.selectPiece(s);
                return;
            } else if ((s.getCurrentPiece().getPlayer() == currentPlayer)) {
                this.selectPiece(s);

            } else {
                this.error_Message("Please select the other color");
            }
        } else {
            Square s = this.findSquareatLocation(e);
            int[] newPosition = s.getCoord();
            if (newPosition==highlightedPosition)
            {
                this.deselectCurrentSquare();
                this.error_Message("Please select a valid square");
                return;
            }
            if (highlightedPiece.validMove(highlightedPosition, newPosition, squares)) {

                 String pieceName = highlightedPiece.getName();

                this.makeMove(newPosition, pieceName);
                highlightedPiece.setMoved(true);

                if (highlightedPiece.getName().equals( "Pawn")) {
                    pieceName = this.upgradablePawn(s);
                }
                if (pieceName.equals(""))
                {
                    pieceName = highlightedPiece.getName();
                }
                String oldPosition = Integer.toString(newPosition[1] *8 + newPosition[0]);
                String newPos = Integer.toString(highlightedPosition[1] * 8 + highlightedPosition[0]);
                String theirMove = networkChess.sendAndWait(newPos + ";" + oldPosition + ";" + pieceName);

                this.backGroundChange(theirMove, pieceName);
           

            } else {
                error_Message("Not valid move");
                this.deselectCurrentSquare();
            }
          
        }
    }
    public void backGroundChange(String theirMove, String pieceName)
    {
        String oldPosition = theirMove.substring(0, theirMove.indexOf(';'));
        String newPosition = theirMove.substring(theirMove.indexOf(';')+1,theirMove.lastIndexOf(';'));
        pieceName = theirMove.substring(theirMove.lastIndexOf(';')+1, theirMove.length());
        ChessPiece piece = this.removePiece(Integer.parseInt(oldPosition));
        if (pieceName.equals("Queen"))
        {
            piece = new Queen(piece.getColor());
        }
        if (pieceName.equals("Rook"))
        {
            piece = new Rook(piece.getColor());
        }
        if (pieceName.equals("Knight"))
        {
            piece = new Knight(piece.getColor());
        }
        if (pieceName.equals("Bishop"))
        {
            piece = new Bishop(piece.getColor());
        }
        else if (pieceName.equals(""))
        {
            // do nothing
        }
        

        this.addPiece(piece, Integer.parseInt(newPosition));
        
        
    }
    public void mousePressed(MouseEvent e) {}


    public void mouseEntered(MouseEvent e) {}
    
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public void error_Message(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }
    public void information_Message(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void won(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.YES_OPTION);
    }
    public ChessPiece upgradePawn(ChessPiece pawn)
    {
        String input="";
            String[] choices = {"Queen", "Bishop", "Rook", "Knight"};
            input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                    "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                    // default
                    // icon
                    choices, // Array of choices
                    choices[1]); // Initial choice

        if (input.equals("Queen"))
        {
            return new Queen(pawn.getColor());
        }
        else if (input.equals("Rook"))
        {
            return new Rook(pawn.getColor());
        }
        else if (input.equals("Knight")) {
            return new Knight(pawn.getColor());
        }
        else if (input.equals("Bishop")) {
            return new Bishop(pawn.getColor());
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

