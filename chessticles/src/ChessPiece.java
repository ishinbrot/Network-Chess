import java.util.Arrays;

/**
 * Created by ianshinbrot on 1/14/15.
 */
public class ChessPiece {//extends ChessRules{
    
    private String color;
    private int position;
    private String image;
    private int value;
    private boolean moved =false;
    private int moveLimit;
    
    
    public ChessPiece() {}
    public ChessPiece(String color)
    {
        this.color=color;

        
    }
    public int getMoveLimit() {
        return moveLimit;
    }

    public void setMoveLimit(int moveLimit) {
        this.moveLimit = moveLimit;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;

    }
    public boolean validMove(int[] initialPosition, int[] finalPosition, ChessBoard board){

        return this.validMove(initialPosition,finalPosition, board);
    }
    public boolean horizontal(int[] initialPosition, int[] finalPosition, ChessBoard board)
    {
        int test;
        if (Arrays.equals(initialPosition, finalPosition)){return false;}
        if (initialPosition[1]==finalPosition[1]){

            int min= Math.min(initialPosition[0], finalPosition[0]);
            int max=Math.max(initialPosition[0], finalPosition[0]);
            for (int i=min++;i<=max;i++){
                test=(initialPosition[1]*8)+i;
                if (test%8==initialPosition[0]){continue;}
                if (board.squares[test].getCurrentPiece()!=null){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean vertical(int[] initialPosition, int[] finalPosition, ChessBoard board){
        int test;
        if (Arrays.equals(initialPosition, finalPosition)){return false;}
        if (initialPosition[0]==finalPosition[0]){

            int min= Math.min(initialPosition[1], finalPosition[1]);
            int max=Math.max(initialPosition[1], finalPosition[1]);
            for (int i=min++;i<=max;i++){
                test=(i*8)+initialPosition[0];
                if (test/8==initialPosition[1]){continue;}
                if (board.squares[test].getCurrentPiece()!=null){
                    return false;
                }
            }
            return true;
        }

        return false;
    }
    public boolean diagonal(int[] initialPosition, int[] finalPosition, ChessBoard board){
        int[] test=new int[2];
        int max;

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
                //test[0]=Math.min(initialPosition[0], finalPosition[0]);
                //test[1]=Math.min(initialPosition[1], finalPosition[1]);
                max=Math.abs(initialPosition[0] - finalPosition[0]);
                for(int i=0;i<max;i++){
                    test[0]+=i;
                    System.out.println(test[0]);
                    test[1]+=i;
                    if (Arrays.equals(test, initialPosition)){continue;}
                    if (board.squares[(test[1]*8)+test[0]].getCurrentPiece()!=null){
                        System.out.println(((test[1]*8)+test[0]));
                        return false;
                    }
                }
            }
            else{

                max=Math.abs(initialPosition[0] - finalPosition[0]);
                for(int i=0;i<=max;i++){
                    test[0]+=i;
                    test[1]-=i;
                    if (Arrays.equals(test, initialPosition)){continue;}
                    //System.out.println(((test[1]*8)+test[0]));
                    if (board.squares[((test[1]*8)+test[0])].getCurrentPiece()!=null){
                        //System.out.println(((test[1]*8)+test[0]));
                        return false;
                    }
                }
            }

            return true;
        }
        return false;
    }
    public boolean L_shape(int[] initialPosition, int[] finalPosition, ChessBoard board){
        if (Arrays.equals(initialPosition, finalPosition)){return false;}
        if (Math.abs(initialPosition[0]-finalPosition[0])==2 && Math.abs(initialPosition[1]-finalPosition[1])==1){
            return true;
        }
        if (Math.abs(initialPosition[0]-finalPosition[0])==1 && Math.abs(initialPosition[1]-finalPosition[1])==2){
            return true;
        }
        return false;
    }



    
    
}
