package Implementation;

/**
 * Created by ianshinbrot on 3/6/15.
 */


import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * This class generates the about window for the chess game
 */
public class AboutScreen extends JFrame {
    JFrame frame = new JFrame();

    public AboutScreen() {

        frame.setTitle("Chess Tickles");
        
        String text = this.buildText(1.0);
        javax.swing.JOptionPane.showMessageDialog((java.awt.Component)
                null, text, "About", JOptionPane.DEFAULT_OPTION);

    }


    public String buildText(double number) {
        String beg = "<html><body width='";
        String info =
                "'><h1>Welcome!</h1>" +
                        "<p>Welcome to Chess Tickles <br> "+
                        " Player 1 is white and Player 2 is black. <br> " +
                        " The local board does not get updated until the other player makes a move <br>" +
                        " This follows the same rules as regular Chess. <br>" +
                        " Good Luck and Have Fun!" +
                        "<p>" +
                        "";
        String build =
                "<br>  Build: " +
                        "<b>" +number + "<b>";
        
        return beg+info+build;

    }
}