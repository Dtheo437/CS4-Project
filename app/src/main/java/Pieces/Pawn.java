package Pieces;
import android.graphics.Canvas;

import com.example.aj.chessapp.*;
/**
 * Created by AJ on 6/5/2017.
 */

public class Pawn extends Piece
{
    Type type;
    public Pawn(int x, int y, int color, Boolean firstMove)
    {
        super(x,y,color);
        type = Type.PAWN;
        firstMove=true;
    }
    public Type getType()
    {
        return Type.PAWN;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    public boolean isValidPath(int finalX, int finalY)
    {
        int ydif = (finalY - this.y);
        //if(this.firstMove && ydif==2)
         //   return true;
        if((ydif==1))
            return true;
        return false;
    }
}
