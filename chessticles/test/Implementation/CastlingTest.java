package Implementation;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;


/**
 * Created by mike on 3/10/2015.
 */
public class CastlingTest extends TestCase {

    King k = new King(Color.white);
    Rook r = new Rook(Color.white);
    ChessBoard cb = new ChessBoard();

    @Test
    public void testValidMove() throws Exception {

        String test;

        int[] initPosK = {3,0};
        int[] initPokR = {0,0};

        //Final position of King
        int[] finalPosK = {1,0};

        //Final position of Rook
        int[] finalPosR = {2,0};

        cb.addPiece(k,3);
        cb.addPiece(r,0);

        cb.selectPiece(cb.getSquare(0));
        test = cb.makeMove(finalPosK,"King",k);

        assertTrue(("0;2;Rook!").equalsIgnoreCase(test));

    }
}
