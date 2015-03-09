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
 * This represents the main menu of the game
 * Buttons are represented for each choice, Player 1, Player 2, About, and Quit *
 */
public class MainMenu extends JFrame implements ActionListener {

    private ChessBoard board;
    private JButton quit = new JButton("Quit");
    private JButton white = new JButton("Player 1: White");
    private JButton testMoves = new JButton("test Moves");
    private JButton black = new JButton("Player 2: Black");
    private JButton About = new JButton("About");
    private JPanel panel1 = new JPanel();

    public MainMenu() {
        JFrame frame = new JFrame("Start");

        // Adding Player 1 Button

        white.setVerticalTextPosition(AbstractButton.CENTER);
        white.setHorizontalTextPosition(AbstractButton.LEADING);
        white.setToolTipText("Player 1: White");
        white.addActionListener(this);

        testMoves.setToolTipText("test Moves");
        testMoves.setVerticalTextPosition(AbstractButton.CENTER);
        testMoves.addActionListener(this);
        // Adding Player 2 Button

        black.setToolTipText("Player 2: Black");
        black.addActionListener(this);

        // Adding About option
        About.setToolTipText("About");
        white.setVerticalTextPosition(AbstractButton.CENTER);
        white.setHorizontalTextPosition(AbstractButton.LEADING);
        About.addActionListener(this);

        // Adding Quit option
        quit.setToolTipText("Quit");
        quit.addActionListener(this);
        quit.setVerticalTextPosition(AbstractButton.CENTER);
        quit.setHorizontalTextPosition(AbstractButton.LEADING);
        panel1.add(white);
        panel1.add(testMoves);
        panel1.add(black);
        panel1.add(About);
        panel1.add(quit);
        frame.add(panel1);


        frame.setSize(350, 100);
        frame.setVisible(true);
    }
/*
This registered the action performed in the menu
 */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == white) {
            try {
                startGame(1,false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == black) {
            try {
                startGame(2, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == About) {

            about();
        }
        if (e.getSource() == quit) {

            quit();
        }
        if (e.getSource() == testMoves) {
                testMoves();

        }
    }
        public void about() {
        AboutScreen aboutScreen = new AboutScreen();

        }
    public void player1() throws IOException {
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
        board.addPiece(new King(Color.black), 7);
        board.addPiece(new King(Color.white), 13);
        board.addPiece(new Pawn(Color.black), 2);
      //  board.addPiece(new Pawn(Color.black), 6);
       // board.addPiece(new Pawn(Color.black), 7);
      //  board.addPiece(new Pawn(Color.black), 8);
        board.addPiece(new Pawn(Color.black), 16);
        board.addPiece(new Pawn(Color.black), 24);
        board.addPiece(new Pawn(Color.black), 32);
        board.addPiece(new Pawn(Color.black), 40);
       // board.addPiece(new Pawn(Color.black), 48);
        board.addPiece(new Bishop(Color.black), 48);
        board.addPiece(new Pawn(Color.black), 15);
        board.addPiece(new Pawn(Color.black), 23);
        board.addPiece(new Pawn(Color.black), 39);
        board.addPiece(new Pawn(Color.black), 47);
        board.addPiece(new Pawn(Color.black), 55);
     //   board.addPiece(new Pawn(Color.black), 56);
        board.addPiece(new Pawn(Color.black), 63);
        board.addPiece(new Pawn(Color.black), 57);
        board.addPiece(new Pawn(Color.black), 58);
        board.addPiece(new Pawn(Color.black), 59);
        board.addPiece(new Pawn(Color.black), 60);
        board.addPiece(new Pawn(Color.black), 61);
        board.addPiece(new Pawn(Color.black), 62);
        board.addPiece(new Pawn(Color.black), 31);


      //  board.addPiece(new Pawn(Color.black), 27);
       // board.addPiece(new Pawn(Color.black), 10);
        board.addPiece(new Pawn(Color.black), 26);
        board.addPiece(new Pawn(Color.black), 12);
        board.addPiece(new Pawn(Color.black), 9);
        board.addPiece(new Pawn(Color.black), 36);
        board.addPiece(new Pawn(Color.black), 14);
        board.addPiece(new Pawn(Color.white), 4);
        board.addPiece(new Pawn(Color.black), 33);
        board.addPiece(new Pawn(Color.black), 39);
        board.addPiece(new Pawn(Color.black), 3);
        board.addPiece(new Pawn(Color.black), 5);
        board.addPiece(new Pawn(Color.black), 30);

        board.addPiece(new Rook(Color.white), startPos);
        board.getSquare(startPos).setBackground(Color.orange);

        int[] start = new int[]{startPos % 8, startPos / 8};
        int[] test = new int[2];
        for (int i = 0; i < 64; i++) {
            int row, col;
            row = i / 8;
            col = i % 8;
            test[0] = col;
            test[1] = row;
            board.deepCopy(board.squares);
            if (board.squares[startPos].getCurrentPiece().validMove(start, test,   board.deepCopy(board.squares), true)) {
                board.getSquare(i).setBackground(Color.green);

            }
        }
    }


    public void player2() throws IOException{

        board = new ChessBoard();
        ChessGame game=new ChessGame();
        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println("Starting Chess Program");

        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);
        board.currentPlayer=2;
        String IP_Address = this.IP_prompt();
        board.connection(IP_Address,true);
        board.startPlayer1();
        board.startPlayer2();

    }
    public void startGame(int playerNum, boolean black) throws IOException {
        board = new ChessBoard();
        ChessGame game=new ChessGame();

        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println("Starting Chess Program");

        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);
        board.currentPlayer=playerNum;
        board.setTitle("Player: " + playerNum);
        String IP_Address = this.IP_prompt();
        board.connection(IP_Address,black);
        board.startPlayer1();
        board.startPlayer2();

    }
/*/
This brings up the prompt for the IP Address
The IP address for the current user is displayed, and you are asked to type in your IP address
 */
   public String IP_prompt() throws IOException {

       JFrame frame = new JFrame("Network Connection");
       String ip="";
       String IP_Address;
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));

             ip = in.readLine(); //you get the IP as a String


        JOptionPane.showMessageDialog(new JFrame(), "your IP address is: " + ip,
                "Dialog",
                JOptionPane.INFORMATION_MESSAGE);

        IP_Address = JOptionPane.showInputDialog(frame, "Please type in the IP Address");
       return IP_Address;
    }
    public void quit() {

        System.exit(2);
    }


}
