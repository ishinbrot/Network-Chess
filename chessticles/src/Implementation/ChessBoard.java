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
public class ChessBoard extends JFrame implements MouseListener {

    private Dimension boardSize;
    private NetworkChess networkChess;
    private JLayeredPane layeredPane;
    private JPanel chessBoard;
    private ChessPiece highlightedPiece;
    private int[] highlightedPosition;
    private boolean PieceSelected = false;
    public Square[] squares = new Square[64];
    public int currentPlayer;
    public boolean castle = false;
    public boolean gameOver = false;

    public ChessBoard() {
        //Initialize Board and it's components
        setTitle("Chess Tickles");
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
        if (currentPlayer==1)
        {
            this.information_Message("Is is now your move");
        }

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
        if (currentPlayer == 2)
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


    public Square[] deepCopy(Square[] board) {
        Square[] copy = new Square[board.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = new Square(new BorderLayout());
            copy[i].setCurrentPiece(board[i].getCurrentPiece());
            copy[i].setCoord(board[i].getCoord());
        }
        return copy;
    }
    public boolean check(Color c){
        int[] myKing=new int[2];
        for (int i=0;i<this.squares.length;i++) {
            if (this.squares[i].getCurrentPiece() != null) {
                if (this.squares[i].getCurrentPiece().getName().equalsIgnoreCase("king")) {
                    if (this.squares[i].getCurrentPiece().getColor() == c) {
                        myKing = this.squares[i].getCoord();
                        break;
                    }
                }
            }
        }

        for (int i=0;i<this.squares.length;i++){
            if (this.squares[i].getCurrentPiece()!=null){
                ChessPiece testPiece=this.squares[i].getCurrentPiece();
                if (testPiece.getColor()!=c){
                    if(testPiece.validMove(this.squares[i].getCoord(),myKing, deepCopy(this.squares), false)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean Moves(Color c){
        for (int i=0;i<this.squares.length;i++){
            if (this.squares[i].getCurrentPiece()!=null) {
                ChessPiece testPiece = this.squares[i].getCurrentPiece();
                if (testPiece.getColor() == c) {
                    int[] test = new int[2];
                    int[] start={testPiece.getPosition()%8, testPiece.getPosition()/8};
                    for (int j = 0; j < 64; j++) {
                        int row, col;
                        row = j / 8;
                        col = j % 8;
                        test[0] = col;
                        test[1] = row;

                        if (testPiece.validMove(start, test,deepCopy(this.squares), true)) {
                            return true;

                        }
                    }
                }
            }
        }

        return false;
    }

    public void connection(String IP_Address, Boolean black) {
        try {
            networkChess = new NetworkChess(IP_Address);
            if (black) {
                //networkChess.blackfirstSend();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.error_Message("Network Game could not be established. Aborting now");
        }

    }

    public void deselectCurrentSquare() {
        PieceSelected = false;
        Square originalSquare = squares[highlightedPosition[1] * 8 + highlightedPosition[0]];
        originalSquare.setBackground(originalSquare.getDefaultColor());

    }

    public Square findSquareatLocation(MouseEvent e) {
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());
        return (Square) c.getParent();

    }

    public void selectPiece(Square s) {
        highlightedPiece = s.getCurrentPiece();
        highlightedPosition = s.getCoord();
        PieceSelected = true;
        s.setBackground(Color.ORANGE);

    }

    public void blackFirst() {

        String theirMove = networkChess.sendAndWait("black");

        this.backGroundChange(theirMove, "");
    }

    public String makeMove(int[] newPosition, String pieceName, ChessPiece piece) {
        this.removePiece(newPosition[1] * 8 + newPosition[0]);

        String extraMove = "";
        if (pieceName.equalsIgnoreCase("King") && (Math.abs(piece.getPosition() - (newPosition[1] * 8 + newPosition[0])) == 2)) {
            if ((newPosition[1] * 8 + newPosition[0]) > piece.getPosition()) {
                Square s = squares[newPosition[1] * 8 + 7];

                this.addPiece(s.getCurrentPiece(), newPosition[1] * 8 + newPosition[0] - 1);
                this.removePiece(newPosition[1] * 8 + 7);
                extraMove = Integer.toString(newPosition[1] * 8 + 7) + ";" + Integer.toString(newPosition[1] * 8 + newPosition[0] - 1) + ";" + "Rook";
            } else if ((newPosition[1] * 8 + newPosition[0]) < piece.getPosition()) {
                Square s = squares[newPosition[1] * 8];

                this.addPiece(s.getCurrentPiece(), newPosition[1] * 8 + newPosition[0] + 1);
                this.removePiece(newPosition[1] * 8);
                extraMove = Integer.toString(newPosition[1] * 8) + ";" + Integer.toString(newPosition[1] * 8 + newPosition[0] + 1) + ";" + "Rook";
            }
            this.castle = true;
        }

        this.addPiece(highlightedPiece, newPosition[1] * 8 + newPosition[0]);

        this.removePiece(highlightedPosition[1] * 8 + highlightedPosition[0]);

        this.deselectCurrentSquare();
        this.castle = false;
        return extraMove;
    }

    public String upgradablePawn(Square s) {


        if ((s.getCoord()[1] == 0 && s.getCurrentPiece().getColor() == Color.black) || s.getCoord()[1] == 7 && s.getCurrentPiece().getColor() == Color.white) {
            ChessPiece piece;
            do {
                piece = this.upgradePawn(s.getCurrentPiece());
            } while (piece == null);
            this.removePiece(s.getCoord()[1] * 8 + s.getCoord()[0]);
            this.addPiece(piece, s.getCoord()[1] * 8 + s.getCoord()[0]);

            return piece.getName();
        }
        return "";
    }

    public void mouseClicked(MouseEvent e)

    {
        String networkString = "";
        if (this.gameOver == true) {
            networkString = "TERMINATE";
        } else {
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
                if (newPosition == highlightedPosition) {
                    this.deselectCurrentSquare();
                    this.error_Message("Please select a valid square");
                    return;
                }
                if (highlightedPiece.validMove(highlightedPosition, newPosition, deepCopy(squares), true)) {

                    String pieceName = highlightedPiece.getName();

                    String castleMove = this.makeMove(newPosition, pieceName, highlightedPiece);
                    highlightedPiece.setMoved(true);

                    if (highlightedPiece.getName().equals("Pawn")) {
                        pieceName = this.upgradablePawn(s);
                    }
                    if (pieceName.equals("")) {
                        pieceName = highlightedPiece.getName();
                    }
                    String oldPosition = Integer.toString(newPosition[1] * 8 + newPosition[0]);
                    String newPos = Integer.toString(highlightedPosition[1] * 8 + highlightedPosition[0]);


                    // Logic for Checkmate goes here

                    // if (checkmate)
                    {
                        //theirMove = networkChess.sendAndWait("Winner")
                       /* if (theirMove.equals("Winner")) {
                            String message = "Congrats on Winning";

                            this.Message(message);
                            this.gameOver = true;
                            try {
                                Thread.sleep(50000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        } else if (theirMove.equals("Lost")) {
                            String message = "Sorry you lost";
                            this.gameOver = true;
                            this.Message(message);
                            try {
                                Thread.sleep(50000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                            this.gameOver=true;
                            */
                    }
                    //else
                    //{
                    networkString = castleMove +"!" + newPos + ";" + oldPosition + ";" + pieceName + "!";

                    repaint();
                    revalidate();
                    String theirMove = networkChess.sendAndWait(networkString);

                    this.backGroundChange(theirMove, pieceName);
                    this.information_Message("Is is now your move");
                    //}
                } else {
                    if (highlightedPiece.isCheck())
                    {
                        this.error_Message("Can't move piece since you are in check");
                    }
                    else
                    error_Message("Not valid move");
                    this.deselectCurrentSquare();
                }
            }
        }
    }
    public void backGroundChange(String theirMove, String pieceName)
    {
        String moves[];
        moves = theirMove.split("!");
        for (int i=0; i<moves.length; i++)
        {
            String oldPosition = moves[i].substring(0, moves[i].indexOf(';'));

            String newPosition = moves[i].substring(moves[i].indexOf(';') +1,moves[i].lastIndexOf(';'));
            if (newPosition.equals("-1"))
            {
                this.removePiece(Integer.parseInt(oldPosition));
            }
            else {
                pieceName = moves[i].substring(moves[i].lastIndexOf(';') + 1, moves[i].length());
                ChessPiece piece = this.removePiece(Integer.parseInt(oldPosition));
                if (pieceName.equals("Queen")) {
                    piece = new Queen(piece.getColor());
                }
               else if (pieceName.equals("Rook")) {
                    piece = new Rook(piece.getColor());
                }
                else if (pieceName.equals("Knight")) {
                    piece = new Knight(piece.getColor());
                }
                else if (pieceName.equals("Bishop")) {
                    piece = new Bishop(piece.getColor());
                } 
                else if (pieceName.equals("King")) {
                    piece = new King(piece.getColor());
                }
                else if (pieceName.equals("Pawn")) {
                    piece = new Pawn(piece.getColor());
                }else if (pieceName.equals("")) {
                    // do nothing
                }


                this.addPiece(piece, Integer.parseInt(newPosition));
            }
        }
    
        
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
                    "Please upgrade your piece.", JOptionPane.QUESTION_MESSAGE, null, // Use
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
    public void Message(String message)
    {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
        
    }
    public void Error_Message(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }
}

