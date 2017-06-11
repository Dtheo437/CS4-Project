package Pieces;
import android.graphics.Canvas;

import com.example.aj.chessapp.*;
/**
 * Created by AJ on 6/5/2017.
 */

public class Knight extends Piece
{
    Type type;
    public Knight(int x, int y, int color)
    {
        super(x,y,color);
        type = Type.KNIGHT;
    }
    public Type getType()
    {
        return Type.KNIGHT;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    public boolean isValidPath(int finalX, int finalY)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if((xdif == 2 && ydif==1) || (xdif == 1 && ydif==2))
            return true;
        return false;
    }
}
