package Pieces;
import android.graphics.Canvas;

import com.example.aj.chessapp.*;
/**
 * Created by AJ on 6/5/2017.
 */

public class Queen extends Piece
{
    Type type;
    public Queen(int x, int y, int color)
    {
        super(x,y,color);
        type = Type.QUEEN;
    }
    public Type getType()
    {
        return Type.QUEEN;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    public boolean isValidPath(int finalX, int finalY)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if((xdif<=7 && ydif ==0) || (xdif==0 && ydif<=7) || xdif == ydif)
            return true;
        return false;
    }
}
