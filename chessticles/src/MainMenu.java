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
    private JMenuItem quit = new JMenuItem("Quit");
    private JMenuItem newGame = new JMenuItem("New Game");
    private JMenuItem testMoves = new JMenuItem("test Moves");

    public MainMenu() {
        JFrame f = new JFrame("Start");

        JMenuBar menubar = new JMenuBar();

        JMenu menu1 = new JMenu("Options");

        newGame.addActionListener(this);
        quit.addActionListener(this);
        testMoves.addActionListener(this);
        menu1.add(newGame);
        menu1.add(testMoves);
        menu1.add(quit);
        menubar.add(menu1);

        f.setJMenuBar(menubar);
        f.setSize(300, 100);
        f.setVisible(true);
        System.out.println("Starting Chess Program");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            start();
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


        game.addPiece("Chess_Pictures/black/bishop.png",2);


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
    
    public void load() {
        
        
    }
    
    
    public void quit() {
        
        System.exit(2);
    }
}
