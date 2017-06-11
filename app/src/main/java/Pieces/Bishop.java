package Pieces;
import com.example.aj.chessapp.*;
/**
 * Created by AJ on 6/5/2017.
 */

public class Bishop extends Piece
{
    Type type;
    public Bishop(int x, int y, Color color)
    {
        super(x,y,color);
        type = Type.BISHOP;
    }
    public Type getType()
    {
        return Type.BISHOP;
    }
    public boolean isValidPath(int finalX, int finalY)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        return xdif == ydif;
    }
    /*
    public int [][] move(int startX, int startY, int finalX, int finalY)
    {
        int pairs = Math.abs(finalX - startX); //length of path

        int xdir=1,ydir=1; //direction of move
        if(finalX-startX <0)
            xdir=-1;
        if(finalY-startY<0)
            ydir=-1;
        int [][] path = new int[2][pairs-1];
        if(pairs -1>0)
        {
            for(int i=0;i<pairs-1;i++)
            {
                path[0][i] = startX + xdir*1;
                path[1][i] = startY + ydir*1;
            }
        }
        return path;
    }
    */
}
