import javax.swing.*;
import java.util.Arrays;

/**
 * Created by Buzz on 2/19/2015.
 */
public class ChessGame {//extends ChessRules{
    private ChessBoard board;
    private ChessPiece currentPiece;
    public static final int player1 = 0;
    public static final int player2 = 1;
    int playerToMove = player1;

    public boolean test(){

        return true;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }
    public void addPiece(ChessPiece chessPiece, int location)
    {
        board.squares[location].setCurrentPiece(chessPiece);
        chessPiece.setPosition(location);
        ImageIcon image = new ImageIcon(this.getClass().getResource(chessPiece.getImage()));
        JLabel picLabel = new JLabel(image);
        //System.out.println(chessPiece.image);
        //System.out.println(picLabel.getIcon().toString());
        board.squares[location].add(picLabel);
    }
    public void removePiece(int location)
    {
        board.squares[location].setCurrentPiece(null);
        JLabel picLabel = new JLabel();
        System.out.println(picLabel.getText());
        board.squares[location].add(picLabel);
    }

    public void startPlayer2()
    {
        String color = "black";

        addPiece(new Rook(color), 0);
        addPiece(new Knight(color), 1);
        addPiece(new Bishop(color), 2);
        addPiece(new King(color), 3);
        addPiece(new Queen(color), 4);
        addPiece(new Bishop(color), 5);
        addPiece(new Knight(color), 6);
        addPiece(new Rook(color), 7);
        addPiece(new Pawn(color), 8);
        addPiece(new Pawn(color), 9);
        addPiece(new Pawn(color), 10);
        addPiece(new Pawn(color), 11);
        addPiece(new Pawn(color), 12);
        addPiece(new Pawn(color), 13);
        addPiece(new Pawn(color), 14);
        addPiece(new Pawn(color), 15);

    }

    public void startPlayer1()
    {
        // place black pieces
        String color="white";
        addPiece(new Rook(color), 63);
        addPiece(new Knight(color), 62);
        addPiece(new Bishop(color), 61);
        addPiece(new Queen(color), 60);
        addPiece(new King(color), 59);
        addPiece(new Bishop(color), 58);
        addPiece(new Knight(color), 57);
        addPiece(new Rook(color), 56);
        addPiece(new Pawn(color), 55);
        addPiece(new Pawn(color), 54);
        addPiece(new Pawn(color), 53);
        addPiece(new Pawn(color), 52);
        addPiece(new Pawn(color), 51);
        addPiece(new Pawn(color), 50);
        addPiece(new Pawn(color), 49);
        addPiece(new Pawn(color), 48);

    }
   public int nextPlayer(int player) {
        if (player==player1) return player2;
        return player1;
    }
    public boolean horizontal(int[] initialPosition, int[] finalPosition)
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
    public boolean vertical(int[] initialPosition, int[] finalPosition){
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
    public boolean diagonal(int[] initialPosition, int[] finalPosition){
        int[] test=new int[2];
        int max;
        if (initialPosition[0]<finalPosition[0]){
            test[0]=initialPosition[0];
            test[1]=initialPosition[1];
        }
        else{
            test[0]=finalPosition[0];
            test[1]=finalPosition[1];
        }
        if (Arrays.equals(initialPosition, finalPosition)){return false;}
        if (Math.abs(initialPosition[0] - finalPosition[0])==Math.abs(initialPosition[1]-finalPosition[1])){
            if ((initialPosition[0]<finalPosition[0]&&initialPosition[1]<finalPosition[1])||
                    (initialPosition[0]>finalPosition[0]&&initialPosition[1]>finalPosition[1])){
                //test[0]=Math.min(initialPosition[0], finalPosition[0]);
                //test[1]=Math.min(initialPosition[1], finalPosition[1]);
                max=Math.abs(initialPosition[0] - finalPosition[0]);
                for(int i=0;i<max;i++){
                    test[0]+=i;
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
    public boolean L_shape(int[] initialPosition, int[] finalPosition){
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
