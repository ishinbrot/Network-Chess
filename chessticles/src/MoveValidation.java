/**
 * Created by Buzz on 1/14/2015.
 */
public class MoveValidation {



    public static boolean horizontal(int[] initialPosition, int[] finalPosition){

        if (initialPosition[1]==finalPosition[1]){

            return true;
        }
        return false;
    }
    public static boolean vertical(int[] initialPosition, int[] finalPosition){
        if (initialPosition[0]==finalPosition[0]){
            return true;
        }

        return false;
    }
    public static boolean diagonal(int[] initialPosition, int[] finalPosition){
        if (Math.abs(initialPosition[0] - finalPosition[0])==Math.abs(initialPosition[1]-finalPosition[1])){
            return true;
        }
        return false;
    }
    public static boolean L_shape(int[] initialPosition, int[] finalPosition){
        if (Math.abs(initialPosition[0]-finalPosition[0])==2 && Math.abs(initialPosition[1]-finalPosition[1])==1){
            return true;
        }
        if (Math.abs(initialPosition[0]-finalPosition[0])==1 && Math.abs(initialPosition[1]-finalPosition[1])==2){
            return true;
        }
        return false;
    }
    /*public static void main (String [] args){
        int[] start = new int[]{1,2};
        int[] end=new int[2];
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                end[0]=i;
                end[1]=j;
                System.out.println("(" + i+ ", "+j+"): "+(diagonal(start, end)));
            }
        }
        //System.out.println(vertical(new int[]{0, 0},new int[]{0, 7}));
        //System.out.println();
    }*/

}
