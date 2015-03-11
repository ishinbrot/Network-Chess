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
    private JButton black = new JButton("Player 2: Black");
    private JButton About = new JButton("About");
    private JPanel panel1 = new JPanel();

    /**
     * Creates the main menu of the program*
     */
    public MainMenu() {
        JFrame frame = new JFrame("Start");

        // Adding Player 1 Button

        white.setVerticalTextPosition(AbstractButton.CENTER);
        white.setHorizontalTextPosition(AbstractButton.LEADING);
        white.setToolTipText("Player 1: White");
        white.addActionListener(this);

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
    }
        public void about() {
        AboutScreen aboutScreen = new AboutScreen();

        }


    /**
     * this function creates a chessboard game
     * @param playerNum 1 or 2 depending on the player number
     * @param black if the current player is black or white
     * @throws IOException
     */

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

/**
 *
*This brings up the prompt for the IP Address *
*The IP address for the current user is displayed, and you are asked to type in your IP address *
 */
   public String IP_prompt() throws IOException {

       JFrame frame = new JFrame("Network Connection");
       String ip="";
       String IP_Address;
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));

             ip = in.readLine(); //you get the IP as a String


       // JOptionPane.showMessageDialog(new JFrame(), "your IP address is: " + ip,
        //        "Dialog",
        //        JOptionPane.INFORMATION_MESSAGE);

        IP_Address = JOptionPane.showInputDialog(frame, "Your IP Address is: "+ip+" \nPlease type in the IP Address");
       return IP_Address;
    }
    public void quit() {

        System.exit(2);
    }


}
