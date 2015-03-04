package Implementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class MainMenu extends JFrame implements ActionListener {

    public boolean blackPlayer;
    public boolean whitePlayer;
    public int moveResult;
    private ChessBoard board;
    private JButton quit = new JButton("Quit");
    private JButton newGame = new JButton("New Game");
    private JButton testMoves = new JButton("test Moves");
    private JButton networkGame = new JButton("Network Game");
    private JPanel panel1 = new JPanel();

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
        System.out.println("Starting Chess Program");
        
        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);
        game.getBoard().currentPlayer=1;
        String IP_Address = this.IP_prompt();
        game.getBoard().connection(IP_Address);
        game.getBoard().startPlayer1();
        game.getBoard().startPlayer2();

    }

    public void testMoves() {
        System.out.println("Starting Chess Program");

        board = new ChessBoard();
        ChessGame game = new ChessGame();
        board.currentPlayer=2;

        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);
        int startPos = 19;
        game.addPiece(new Pawn(Color.black), 0);
        game.addPiece(new Pawn(Color.black), 1);
        game.addPiece(new Pawn(Color.black), 2);
        game.addPiece(new Pawn(Color.black), 6);
        game.addPiece(new Pawn(Color.black), 7);
        game.addPiece(new Pawn(Color.black), 8);
        game.addPiece(new Pawn(Color.black), 16);
        game.addPiece(new Pawn(Color.black), 24);
        game.addPiece(new Pawn(Color.black), 32);
        game.addPiece(new Pawn(Color.black), 40);
        game.addPiece(new Pawn(Color.black), 48);
        game.addPiece(new Pawn(Color.black), 56);
        game.addPiece(new Pawn(Color.black), 15);
        game.addPiece(new Pawn(Color.black), 23);
        game.addPiece(new Pawn(Color.black), 39);
        game.addPiece(new Pawn(Color.black), 47);
        game.addPiece(new Pawn(Color.black), 55);
        game.addPiece(new Pawn(Color.black), 56);
        game.addPiece(new Pawn(Color.black), 63);
        game.addPiece(new Pawn(Color.black), 57);
        game.addPiece(new Pawn(Color.black), 58);
        game.addPiece(new Pawn(Color.black), 59);
        game.addPiece(new Pawn(Color.black), 60);
        game.addPiece(new Pawn(Color.black), 61);
        game.addPiece(new Pawn(Color.black), 62);
        game.addPiece(new Pawn(Color.black), 31);


        game.addPiece(new Pawn(Color.black), 37);
        game.addPiece(new Pawn(Color.black), 10);
        game.addPiece(new Pawn(Color.black), 26);
        game.addPiece(new Pawn(Color.black), 12);
        game.addPiece(new Pawn(Color.black), 9);
        game.addPiece(new Pawn(Color.black), 36);
        game.addPiece(new Pawn(Color.black), 14);
        game.addPiece(new Pawn(Color.white), 4);
        game.addPiece(new Pawn(Color.black), 33);
        game.addPiece(new Pawn(Color.black), 39);
        game.addPiece(new Pawn(Color.black), 3);
        game.addPiece(new Pawn(Color.black), 5);
        game.addPiece(new Pawn(Color.black), 30);
        game.addPiece(new Pawn(Color.black), startPos);


        int[] start = new int[]{startPos % 8, startPos / 8};
        int[] test = new int[2];
        for (int i = 0; i < 64; i++) {
            int row, col;
            row = i / 8;
            col = i % 8;
            test[0] = col;
            test[1] = row;
            if (game.getBoard().squares[startPos].getCurrentPiece().validMove(start, test, game.getBoard().squares)) {
                game.getBoard().getSquare(i).setBackground(Color.green);

            }
        }
    }
    
    
    public void network() {

        board = new ChessBoard();
        ChessGame game=new ChessGame();
        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println("Starting Chess Program");

        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);
        game.getBoard().currentPlayer=2;
        String IP_Address = this.IP_prompt();
        game.getBoard().connection(IP_Address);
        game.getBoard().startPlayer1();
        game.getBoard().startPlayer2();

    }

   public String IP_prompt() {

       JFrame frame = new JFrame("Network Connection");
       String ip="";
       String IP_Address;
        try {
            ip = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(new JFrame(), "your ip address is: " + ip,
                "Dialog",
                JOptionPane.INFORMATION_MESSAGE);

        IP_Address = JOptionPane.showInputDialog(frame, "Please type in the IP Address");
       return IP_Address;
    }
    public void quit() {
        
        System.exit(2);
    }


}
