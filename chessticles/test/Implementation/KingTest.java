package Implementation;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class KingTest extends TestCase {

    King k = new King(Color.white);
    ChessBoard cb = new ChessBoard();

    @Test
    public void testValidMove() throws Exception {

        int[] initPos = {3,0};

        //Finals positions of True
        int[] finalPos1 = {4,0};
        int[] finalPos2 = {2,0};
        int[] finalPos3 = {3,1};
        int[] finalPos4 = {2,1};
        int[] finalPos5 = {4,1};

        //Final Positions of False
        int[] finalPos6 = {3,0};
        int[] finalPos7 = {2,5};
        int[] finalPos8 = {4,5};


        ArrayList<int[]> fPositions = new ArrayList();

        fPositions.add(finalPos1);
        fPositions.add(finalPos2);
        fPositions.add(finalPos3);
        fPositions.add(finalPos4);
        fPositions.add(finalPos5);
        fPositions.add(finalPos6);
        fPositions.add(finalPos7);
        fPositions.add(finalPos8);

        //Setting piece on board
        int boardSize = 64;
        cb.addPiece(k,3);

        for(int i=0; i<8; i++) {
            if (i < 5) {
                assertTrue(k.validMove(initPos, fPositions.get(i), cb.squares));
            } else assertFalse(k.validMove(initPos, fPositions.get(i), cb.squares));
        }

    }
}