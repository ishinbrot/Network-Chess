package Implementation;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class KnightTest extends TestCase {

    Knight k = new Knight(Color.white);
    ChessBoard cb = new ChessBoard();

    @Test
    public void testValidMove() throws Exception {

        int[] initPos = {1,0};

        //Finals positions of True
        int[] finalPos1 = {3,1};
        int[] finalPos2 = {2,2};
        int[] finalPos3 = {0,2};


        //Final Positions of False
        int[] finalPos4 = {2,1};
        int[] finalPos5 = {4,1};
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
        cb.addPiece(k,1);

        for(int i=0; i<8; i++) {
            if (i < 3) {
                assertTrue(k.validMove(initPos, fPositions.get(i), cb.squares));
            } else assertFalse(k.validMove(initPos, fPositions.get(i), cb.squares));
        }

    }
}