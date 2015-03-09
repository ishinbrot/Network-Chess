package Implementation;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.net.*;
import java.net.UnknownHostException;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class MainMenu extends JFrame implements ActionListener {

    private ChessBoard board;
    private JButton quit = new JButton("Quit");
    private JButton white = new JButton("Player 1: White");
    private JButton testMoves = new JButton("test Moves");
    private JButton black = new JButton("Player 2: Black");
    private JPanel panel1 = new JPanel();

    public MainMenu() {
        JFrame frame = new JFrame("Start");
        
        // Adding New Game Button

        white.setVerticalTextPosition(AbstractButton.CENTER);
        white.setHorizontalTextPosition(AbstractButton.LEADING);
        white.setToolTipText("Player 1: White");
        white.addActionListener(this);
        
        testMoves.setToolTipText("test Moves");
        testMoves.setVerticalTextPosition(AbstractButton.CENTER);
        testMoves.addActionListener(this);
        black.setToolTipText("Player 2: Black");
        black.addActionListener(this);
        quit.setToolTipText("Quit");
        quit.addActionListener(this);
        quit.setVerticalTextPosition(AbstractButton.CENTER);
        quit.setHorizontalTextPosition(AbstractButton.LEADING);
        panel1.add(white);
        panel1.add(testMoves);
        panel1.add(black);
        panel1.add(quit);
        frame.add(panel1);


        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == white) {
            try {
                start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == black) {
            try {
                network();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == quit) {

            quit();
        }
        if (e.getSource() == testMoves) {
                testMoves();

        }
    }

    public void start() throws IOException {
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
        game.getBoard().connection(IP_Address, false);
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
        int startPos = 20;
        game.addPiece(new King(Color.black), 0);
        game.addPiece(new King(Color.white), 1);
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


        game.addPiece(new Pawn(Color.black), 27);
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

        game.addPiece(new Bishop(Color.white), startPos);


        int[] start = new int[]{startPos % 8, startPos / 8};
        int[] test = new int[2];
        for (int i = 0; i < 64; i++) {
            int row, col;
            row = i / 8;
            col = i % 8;
            test[0] = col;
            test[1] = row;
            if (game.getBoard().squares[startPos].getCurrentPiece().validMove(start, test, game.getBoard().squares, true)) {
                game.getBoard().getSquare(i).setBackground(Color.green);

            }
        }
    }

    
    public void network() throws IOException{

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
        game.getBoard().connection(IP_Address,true);
        game.getBoard().startPlayer1();
        game.getBoard().startPlayer2();

    }

   public String IP_prompt() throws IOException {

       JFrame frame = new JFrame("Network Connection");
       String ip="";
       String IP_Address;
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));

             ip = in.readLine(); //you get the IP as a String


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
