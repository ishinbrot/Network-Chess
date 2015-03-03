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
    private JLayeredPane layeredPane;
    public JPanel chessBoard;
    public ChessPiece highlightedPiece;
    public int[] highlightedPosition;
    boolean PieceSelected = false;
    public Square[] squares = new Square[64];
    private JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    int player1 = 0;
    int player2 = 1;
    int nextPlayer = player1;

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
            //JPanel square = new JPanel(new BorderLayout());
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

    public void setSquareColor(int x, Color c) {
        squares[x].setBackground(c);
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


    public void removePiece(int location) {
        squares[location].setCurrentPiece(null);
      //  ImageIcon image = new ImageIcon(null);
     //   JLabel picLabel = new JLabel(image);
        squares[location].removeAll();
        squares[location].add(new JLabel());
      //  System.out.println(picLabel.getText());
      //  squares[location].add(picLabel);
        chessBoard.repaint();
        chessBoard.revalidate();
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

    }

    public int nextPlayer(int player) {
        if (player == player1) return player2;
        return player1;
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
    public void deselectCurrentSquare()
    {
        PieceSelected=false;
        Square originalSquare = squares[highlightedPosition[1] * 8 + highlightedPosition[0]];
        originalSquare.setBackground(originalSquare.defaultColor);
        
    }


    public void mouseClicked(MouseEvent e)

    {
        if (!PieceSelected) {
            Component c = chessBoard.findComponentAt(e.getX(), e.getY());
            Square s = (Square) c.getParent();
            if (s.getCurrentPiece() == null) {
                System.out.println("Not valid piece");
                return;
            }
            highlightedPiece = s.getCurrentPiece();
            highlightedPosition = s.getCoord();
            PieceSelected = true;
            s.setBackground(Color.ORANGE);
        } else {
            Component c = chessBoard.findComponentAt(e.getX(), e.getY());
            Square s = (Square) c.getParent();
            int[] newPosition = s.getCoord();
            if (newPosition==highlightedPosition)
            {
                this.deselectCurrentSquare();
                this.Error_Message("Please select a valid square");
                return;
            }
            if (highlightedPiece.validMove(highlightedPosition, newPosition, squares)) {
                this.removePiece(newPosition[1] * 8 + newPosition[0]);
                this.addPiece(highlightedPiece, newPosition[1] * 8 + newPosition[0]);
                this.removePiece(highlightedPosition[1] * 8 + highlightedPosition[0]);
                this.deselectCurrentSquare();

               // do networking here

            } else {
                Error_Message("Not valid move");
                this.deselectCurrentSquare();
            }
          
        }
    }
    public void mousePressed(MouseEvent e) {}


    public void mouseEntered(MouseEvent e) {}
    
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public void Error_Message(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }
    public void Information_Message(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void Won(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.YES_OPTION);
    }
}

