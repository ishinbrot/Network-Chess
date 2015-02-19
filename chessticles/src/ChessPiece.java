/**
 * Created by ianshinbrot on 1/14/15.
 */
public class ChessPiece {
    
    public String color;
    public int position;
    public String image;
    public int value;
    public boolean moved =false;

    
    
    public ChessPiece() {}
    public ChessPiece(String color)
    {
        this.color=color;

        
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



    
    
}
