package Implementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.net.*;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class MainMenu extends JFrame implements ActionListener {

    public boolean blackPlayer;
    public boolean whitePlayer;
    public int moveResult;
    public ChessBoard board;
    private JButton quit = new JButton("Quit");
    private JButton newGame = new JButton("New Game");
    private JButton testMoves = new JButton("test Moves");
    private JButton networkGame = new JButton("Network Game");
    JPanel panel1 = new JPanel();

    public MainMenu() {
        JFrame frame = new JFrame("Start");
        
        // Adding New Game Button
       
        newGame.setVerticalTextPosition(AbstractButton.CENTER);
        newGame.setHorizontalTextPosition(AbstractButton.LEADING);
        newGame.setToolTipText("New Game");
        newGame.addActionListener(this);
        
        testMoves.setToolTipText("test Moves");
        testMoves.setVerticalTextPosition(AbstractButton.CENTER);
        testMoves.addActionListener(this);
        networkGame.setToolTipText("Network Game");
        networkGame.addActionListener(this);
        quit.setToolTipText("Quit");
        quit.addActionListener(this);
        quit.setVerticalTextPosition(AbstractButton.CENTER);
        quit.setHorizontalTextPosition(AbstractButton.LEADING);
        panel1.add(newGame);
        panel1.add(testMoves);
        panel1.add(networkGame);
        panel1.add(quit);
        frame.add(panel1);


        frame.setSize(300, 100);
        frame.setVisible(true);
        
        System.out.println("Starting Chess Program");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            start();
        }
        if (e.getSource() == networkGame) {
            network();
        }
        if (e.getSource() == quit) {

            quit();
        }
        if (e.getSource() == testMoves) {

            testMoves();
        }
    }

    public void start() {
        board = new ChessBoard();

        ChessGame game=new ChessGame();

        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);
        game.getBoard().currentPlayer=1;
        game.getBoard().startPlayer1();
        game.getBoard().startPlayer2();

    }

    public void testMoves()
    {
        System.out.println("Starting Chess Program");

        board = new ChessBoard();
        ChessGame game=new ChessGame();

        board.currentPlayer=2;
        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);
        int startPos=12;
        game.getBoard().addPiece(new Pawn(Color.black), 0);
        game.getBoard().addPiece(new Pawn(Color.black), 1);
        game.getBoard().addPiece(new Pawn(Color.black), 2);
        game.getBoard().addPiece(new Pawn(Color.black), 6);
        game.getBoard().addPiece(new Pawn(Color.black), 7);
        game.getBoard().addPiece(new Pawn(Color.black), 8);
        game.getBoard().addPiece(new Pawn(Color.black), 16);
        game.getBoard().addPiece(new Pawn(Color.black), 24);
        game.getBoard().addPiece(new Pawn(Color.black), 32);
        game.getBoard().addPiece(new Pawn(Color.black), 40);
        game.getBoard().addPiece(new Pawn(Color.black), 48);
        game.getBoard().addPiece(new Pawn(Color.black), 56);
        game.getBoard().addPiece(new Pawn(Color.black), 15);
        game.getBoard().addPiece(new Pawn(Color.black), 23);
        game.getBoard().addPiece(new Pawn(Color.black), 39);
        game.getBoard().addPiece(new Pawn(Color.black), 47);
        game.getBoard().addPiece(new Pawn(Color.black), 55);
        game.getBoard().addPiece(new Pawn(Color.black), 56);
        game.getBoard().addPiece(new Pawn(Color.black), 63);
        game.getBoard().addPiece(new Pawn(Color.black), 57);
        game.getBoard().addPiece(new Pawn(Color.black), 58);
        game.getBoard().addPiece(new Pawn(Color.black), 59);
        game.getBoard().addPiece(new Pawn(Color.black), 60);
        game.getBoard().addPiece(new Pawn(Color.black), 61);
        game.getBoard().addPiece(new Pawn(Color.black), 62);
        game.getBoard().addPiece(new Pawn(Color.black), 31);




        game.getBoard().addPiece(new Pawn(Color.black), 9);
        game.getBoard().addPiece(new Pawn(Color.black), 36);
        game.getBoard().addPiece(new Pawn(Color.black), 14);
        game.getBoard().addPiece(new Pawn(Color.white), 4);
        game.getBoard().addPiece(new Pawn(Color.black), 33);
        game.getBoard().addPiece(new Pawn(Color.black), 39);
        game.getBoard().addPiece(new Pawn(Color.black), 3);
        game.getBoard().addPiece(new Pawn(Color.black), 5);
        game.getBoard().addPiece(new Knight(Color.white), startPos);




        int [] start=new int[]{startPos%8,startPos/8};
        int [] test=new int[2];
        for (int i =0; i<64;i++) {
            int row, col;
            row = i / 8;
            col = i % 8;
            test[0] = col;
            test[1] = row;
            if (game.getBoard().squares[startPos].getCurrentPiece().validMove(start, test, game.getBoard().squares)) {
                game.getBoard().setSquareColor(i, Color.green);
            }


        }

    }
    
    
    public void network() {
        

        JFrame frame = new JFrame("Upgrade Piece");
        String ip = "";
        try {
             ip = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // prompt the user to enter their name
        String IP_Address = "";
        do {
            JOptionPane.showMessageDialog(new JFrame(), "your ip address is:" + ip, "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
            IP_Address = JOptionPane.showInputDialog(frame, "Please type in the IP Address");

        } while (IP_Address == "");

        ChessGame game=new ChessGame();
       
        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        game.getBoard().currentPlayer=2;
        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);

        game.getBoard().connection(IP_Address);
        game.getBoard().startPlayer1();
        game.getBoard().startPlayer2();

    }


    public void quit() {
        
        System.exit(2);
    }


}
