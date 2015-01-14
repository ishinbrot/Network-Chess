import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Created by Mike on 1/13/2015.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");

        JFrame game = new ChessBoard();

        game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        game.pack();
        game.setResizable(true);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        System.out.println(game.getContentPane().getComponents().length);




    }
}
