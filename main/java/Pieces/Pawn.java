package Pieces;
import com.example.aj.chessapp.*;
/**
 * Created by AJ on 6/5/2017.
 */

public class Pawn extends Piece
{
    Type type;
    public Pawn(int x, int y, Color color, Boolean firstMove)
    {
        super(x,y,color);
        type = Type.PAWN;
        firstMove=true;
    }
    public Type getType()
    {
        return Type.PAWN;
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
