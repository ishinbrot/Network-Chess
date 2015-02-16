import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class MainMenu extends JFrame implements ActionListener {

    public boolean blackPlayer;
    public boolean whitePlayer;
    public int moveResult;
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
        ChessBoard game = new ChessBoard();

        game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        game.pack();
        game.setResizable(true);
        game.setLocationRelativeTo(null);
        game.setVisible(true);


        game.startPlayer1();
        game.startPlayer2();
        //ChessPiece knight = new Knight("black");

        //game.addPiece(knight.image,2);
    }

    public void testMoves()
    {
        System.out.println("Starting Chess Program");

        ChessBoard game = new ChessBoard();

        game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        game.pack();
        game.setResizable(true);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        int startPos=12;
        int [] start=new int[]{startPos%8,startPos/8};
        int [] test=new int[2];
        for (int i =0; i<64;i++){
            int row, col;
            row =i/8;
            col = i%8;
            test[0]=col;
            test[1]=row;
            if (MoveValidation.horizontal(start, test)||MoveValidation.vertical(start, test)||MoveValidation.diagonal(start, test)){
                game.setSquareColor(i, Color.green);
            }

        }
        game.setSquareColor(startPos, Color.red);

    }
    
    
    public void network() {
    }
    

    
    
    public void quit() {
        
        System.exit(2);
    }
}
