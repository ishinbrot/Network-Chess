package Implementation;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RookTest extends TestCase {

    Rook r = new Rook(Color.white);
    ChessBoard cb = new ChessBoard();

    @Test
    public void testValidMove() throws Exception {

        int[] initPos = {0,0};

        //Finals positions of True
        int[] finalPos1 = {4,0};
        int[] finalPos2 = {0,5};
        int[] finalPos3 = {7,0};
        int[] finalPos4 = {0,4};


        //Final Positions of False
        int[] finalPos5 = {1,1};
        int[] finalPos6 = {1,7};
        int[] finalPos7 = {2,5};
        int[] finalPos8 = {4,4};


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
        cb.addPiece(r,0);

        for(int i=0; i<8; i++) {
            if(i<4) {
                assertTrue(r.validMove(initPos, fPositions.get(i), cb.deepCopy(cb.squares),true));
            } else assertFalse(r.validMove(initPos, fPositions.get(i), cb.deepCopy(cb.squares),true));
        }

    }
}