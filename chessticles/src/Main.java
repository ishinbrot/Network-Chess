import javax.swing.*;

/**
 * Created by Mike on 1/13/2015.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");

        ChessBoard game = new ChessBoard();

        game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        game.pack();
        game.setResizable(true);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        /*
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
        */




    }
}
