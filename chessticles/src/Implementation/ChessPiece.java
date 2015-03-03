package Implementation;

import Implementation.ChessBoard;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class ChessPiece {//extends ChessRules{
    
    private Color color;
    private int position;
    private int player;
    private String image;
    private int value;
    private boolean moved =false;
    private int moveLimit;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Name;
    
    
    public ChessPiece() {}
    public ChessPiece(Color color)
    {
        this.color=color;

        
    }
    public int getMoveLimit() {
        return moveLimit;
    }

    public void setMoveLimit(int moveLimit) {
        this.moveLimit = moveLimit;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public void setPlayer(Color color) {
        if (this.color == Color.white)
            player = 1;
        if (this.color == color.black)
            player = 2;
    }
    public int getPlayer()
    {
        return this.player;
        
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;

    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, Square[] board){

        return this.validMove(initialPosition,finalPosition, board);
    }
    public boolean horizontal(int[] initialPosition, int[] finalPosition, Square[] board)
    {
        int test;
        if (Arrays.equals(initialPosition, finalPosition)){return false;}
        if (initialPosition[1]==finalPosition[1]){

            int min= Math.min(initialPosition[0], finalPosition[0]);
            int max=Math.max(initialPosition[0], finalPosition[0]);
            int ip=(initialPosition[1]*8)+initialPosition[0];
            int fp=(finalPosition[1]*8)+finalPosition[0];
            for (int i=min++;i<=max;i++){
                test=(initialPosition[1]*8)+i;
                if (test%8==initialPosition[0]){continue;}
                if (board[test].getCurrentPiece()!=null){
                    if (test==fp){
                        if (board[ip].getCurrentPiece().getColor()!=
                                board[fp].getCurrentPiece().getColor()){
                            continue;
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean vertical(int[] initialPosition, int[] finalPosition, Square[] board){
        int test;
        if (Arrays.equals(initialPosition, finalPosition)){return false;}
        if (initialPosition[0]==finalPosition[0]){
            int ip=(initialPosition[1]*8)+initialPosition[0];
            int fp=(finalPosition[1]*8)+finalPosition[0];
            int min= Math.min(initialPosition[1], finalPosition[1]);
            int max=Math.max(initialPosition[1], finalPosition[1]);
            for (int i=min++;i<=max;i++){
                test=(i*8)+initialPosition[0];
                if (test/8==initialPosition[1]){continue;}
                if (board[test].getCurrentPiece()!=null){
                    if (test==fp){
                        if (board[ip].getCurrentPiece().getColor()!=
                                board[fp].getCurrentPiece().getColor()){
                            continue;
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        return false;
    }
    public boolean diagonal(int[] initialPosition, int[] finalPosition, Square[] board){
        int[] test=new int[2];
        int max;
        int ip=(initialPosition[1]*8)+initialPosition[0];
        int fp=(finalPosition[1]*8)+finalPosition[0];

        if (Arrays.equals(initialPosition, finalPosition)){return false;}
        if (Math.abs(initialPosition[0] - finalPosition[0])==Math.abs(initialPosition[1]-finalPosition[1])){
            if (initialPosition[0]<finalPosition[0]){
            test[0]=initialPosition[0];
            test[1]=initialPosition[1];
        }
        else{
            test[0]=finalPosition[0];
            test[1]=finalPosition[1];
        }
            if ((initialPosition[0]<finalPosition[0]&&initialPosition[1]<finalPosition[1])||
                    (initialPosition[0]>finalPosition[0]&&initialPosition[1]>finalPosition[1])){

                max=Math.abs(initialPosition[0] - finalPosition[0]);
                for(int i=0;i<=max;i++){

                    if (Arrays.equals(test, initialPosition)){
                        test[0]+=1;
                        test[1]+=1;
                        continue;}

                    if (board[(test[1]*8)+test[0]].getCurrentPiece()!=null){

                        if (Arrays.equals(test, finalPosition)){
                            if (board[ip].getCurrentPiece().getColor()!=
                                    board[fp].getCurrentPiece().getColor()){
                                test[0]+=1;
                                test[1]+=1;
                                continue;
                            }

                        }
                        return false;
                    }
                    test[0]+=1;
                    test[1]+=1;
                }
            }
            else{

                max=Math.abs(initialPosition[0] - finalPosition[0]);
                for(int i=0;i<=max;i++){

                    if (Arrays.equals(test, initialPosition)){
                        test[0]+=1;
                        test[1]-=1;
                        continue;}

                    if (board[((test[1]*8)+test[0])].getCurrentPiece()!=null){
                        if (Arrays.equals(test, finalPosition)){
                            if (board[ip].getCurrentPiece().getColor()!=
                                    board[fp].getCurrentPiece().getColor()){
                                test[0]+=1;
                                test[1]-=1;
                                continue;
                            }
                        }

                        return false;
                    }
                    test[0]+=1;
                    test[1]-=1;
                }
            }

            return true;
        }
        return false;
    }
    public boolean L_shape(int[] initialPosition, int[] finalPosition, Square[] board){
        int ip=(initialPosition[1]*8)+initialPosition[0];
        int fp=(finalPosition[1]*8)+finalPosition[0];
        if (Arrays.equals(initialPosition, finalPosition)){return false;}
        if ((Math.abs(initialPosition[0]-finalPosition[0])==2 && Math.abs(initialPosition[1]-finalPosition[1])==1)||
                (Math.abs(initialPosition[0]-finalPosition[0])==1 && Math.abs(initialPosition[1]-finalPosition[1])==2)){
            if (board[((finalPosition[1]*8)+finalPosition[0])].getCurrentPiece()!=null){
                    if (board[ip].getCurrentPiece().getColor()!=
                            board[fp].getCurrentPiece().getColor()){
                        return true;
                    }
                return false;
            }
            return true;
        }

        return false;
    }

}
