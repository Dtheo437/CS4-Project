package Pieces;
import android.graphics.Canvas;

import com.example.aj.chessapp.*;
/**
 * Created by AJ on 6/5/2017.
 */

public class King extends Piece
{
    Type type;
    public King(int x, int y, int color)
    {
        super(x,y,color);
        type = Type.KING;
    }
    public Type getType()
    {
        return Type.KING;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    public boolean isValidPath(int finalX, int finalY)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if(xdif<=1 && ydif <= 1)
            return true;
        return false;
    }

}
