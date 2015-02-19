package Implementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

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

        game.startPlayer1();
        game.startPlayer2();
        //Implementation.ChessPiece knight = new Implementation.Knight("black");

        //board.addPiece(knight.image,2);
    }

    public void testMoves()
    {
        System.out.println("Starting Chess Program");

         board = new ChessBoard();
        ChessGame game=new ChessGame();

        board.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        board.pack();
        board.setResizable(true);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        game.setBoard(board);
        int startPos=12;
        game.addPiece(new Pawn("black"), 0);
        game.addPiece(new Pawn("black"), 1);
        game.addPiece(new Pawn("black"), 2);
        game.addPiece(new Pawn("black"), 6);
        game.addPiece(new Pawn("black"), 7);
        game.addPiece(new Pawn("black"), 8);
        game.addPiece(new Pawn("black"), 16);
        game.addPiece(new Pawn("black"), 24);
        game.addPiece(new Pawn("black"), 32);
        game.addPiece(new Pawn("black"), 40);
        game.addPiece(new Pawn("black"), 48);
        game.addPiece(new Pawn("black"), 56);
        game.addPiece(new Pawn("black"), 15);
        game.addPiece(new Pawn("black"), 23);
        game.addPiece(new Pawn("black"), 39);
        game.addPiece(new Pawn("black"), 47);
        game.addPiece(new Pawn("black"), 55);
        game.addPiece(new Pawn("black"), 56);
        game.addPiece(new Pawn("black"), 63);
        game.addPiece(new Pawn("black"), 57);
        game.addPiece(new Pawn("black"), 58);
        game.addPiece(new Pawn("black"), 59);
        game.addPiece(new Pawn("black"), 60);
        game.addPiece(new Pawn("black"), 61);
        game.addPiece(new Pawn("black"), 62);
        game.addPiece(new Pawn("black"), 31);




        game.addPiece(new Pawn("black"), 9);
        game.addPiece(new Pawn("black"), 36);
        game.addPiece(new Pawn("black"), 14);
        game.addPiece(new Pawn("black"), 4);
        game.addPiece(new Pawn("black"), 33);
        game.addPiece(new Pawn("black"), 39);
        game.addPiece(new Pawn("black"), 3);
        game.addPiece(new Pawn("black"), 5);
        game.addPiece(new Knight("white"), startPos);




        int [] start=new int[]{startPos%8,startPos/8};
        int [] test=new int[2];
        for (int i =0; i<64;i++){
            int row, col;
            row =i/8;
            col = i%8;
            test[0]=col;
            test[1]=row;
            if (game.getBoard().squares[startPos].getCurrentPiece().validMove(start, test, game.getBoard())){
                game.getBoard().setSquareColor(i, Color.green);
            }


        }
        /*
        test[0]=7;
        test[1]=4;

        System.out.println(game.getBoard().squares[12].getCurrentPiece().validMove(start, test, game.getBoard()));
        System.out.println();*/
        //game.setSquareColor(startPos, Color.red);

    }
    
    
    public void network() {
    }
    

    
    
    public void quit() {
        
        System.exit(2);
    }
}
