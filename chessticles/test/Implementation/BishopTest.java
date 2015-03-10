package Implementation;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BishopTest extends TestCase {

    Bishop b = new Bishop(Color.white);
    ChessBoard cb = new ChessBoard();

    @Test
    public void testValidMove() throws Exception {

        int[] initPos = {2,0};

        //Finals positions of True
        int[] finalPos1 = {0,2};
        int[] finalPos2 = {4,2};


        //Final Positions of False
        int[] finalPos3 = {2,1};
        int[] finalPos4 = {3,0};
        int[] finalPos5 = {1,0};
        int[] finalPos6 = {2,0};


        ArrayList<int[]> fPositions = new ArrayList();

        fPositions.add(finalPos1);
        fPositions.add(finalPos2);
        fPositions.add(finalPos3);
        fPositions.add(finalPos4);
        fPositions.add(finalPos5);
        fPositions.add(finalPos6);


        //Setting piece on board
        int boardSize = 64;
        cb.addPiece(b,2);

        for(int i=0; i<6; i++) {
            if(i<2) {
                assertTrue(b.validMove(initPos, fPositions.get(i), cb.squares));
            }
            else assertFalse(b.validMove(initPos, fPositions.get(i), cb.squares));
        }

    }
}