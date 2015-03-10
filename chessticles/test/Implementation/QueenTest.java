package Implementation;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueenTest extends TestCase {

    Queen q = new Queen(Color.white);
    ChessBoard cb = new ChessBoard();

    @Test
    public void testValidMove() throws Exception {

        int[] initPos = {4,0};

        //Finals positions of True
        int[] finalPos1 = {4,1};
        int[] finalPos2 = {2,0};
        int[] finalPos3 = {7,0};
        int[] finalPos4 = {0,4};
        int[] finalPos5 = {7,3};

        //Final Positions of False
        int[] finalPos6 = {1,1};
        int[] finalPos7 = {2,5};
        int[] finalPos8 = {4,0};


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
        cb.addPiece(q,4);

        for(int i=0; i<8; i++) {
            if(i<5) {
                assertTrue(q.validMove(initPos, fPositions.get(i), cb.squares));
            }
            else assertFalse(q.validMove(initPos, fPositions.get(i), cb.squares));
        }

    }
}