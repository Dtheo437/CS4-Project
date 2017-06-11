package Pieces;
import android.graphics.Canvas;

import com.example.aj.chessapp.*;

/**
 * Created by AJ on 6/5/2017.
 */

public class Rook extends Piece
{
    Type type;
    public Rook(int x, int y, int color)
    {
        super(x,y,color);
        type = Type.ROOK;
    }
    public Type getType()
    {
        return Type.ROOK;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    public boolean isValidPath(int finalX, int finalY)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if((xdif<=7 && ydif ==0) || (xdif==0 && ydif<=7))
            return true;
        return false;
    }
}
