package Implementation;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PawnTest extends TestCase {

    Pawn p = new Pawn(Color.white);
    ChessBoard cb = new ChessBoard();

    @Test
    public void testValidMove() throws Exception {

        int[] initPos = {0,1};

        //Finals positions of True
        int[] finalPos1 = {0,2};
        int[] finalPos2 = {0,3};

        //Final Positions of False
        int[] finalPos4 = {0,7};
        int[] finalPos5 = {6,6};
        int[] finalPos3 = {1,0};


        ArrayList<int[]> fPositions = new ArrayList();

        fPositions.add(finalPos1);
        fPositions.add(finalPos2);
        fPositions.add(finalPos3);
        fPositions.add(finalPos4);
        fPositions.add(finalPos5);

        //Setting piece on board
        int boardSize = 64;
        cb.addPiece(p,8);

        for(int i=0; i<5; i++) {
            if(i<2) {
                assertTrue(p.validMove(initPos, fPositions.get(i), cb.squares));
            }
            else assertFalse(p.validMove(initPos, fPositions.get(i), cb.squares));
        }
    }
}