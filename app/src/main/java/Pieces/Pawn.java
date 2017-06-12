//FUCKED UP
package Pieces;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.example.aj.chessapp.*;
/**
 * Created by AJ on 6/5/2017.
 */

public class Pawn extends Piece
{
    private Bitmap bp;
    private Bitmap wp;
    private boolean firstMove;
    Type type;
    public Pawn(int x, int y, int color, Resources res)
    {
        super(x,y,color);
        type = Type.PAWN;
        firstMove = true;
        bp = BitmapFactory.decodeResource(res,R.drawable.bp);
        wp = BitmapFactory.decodeResource(res, R.drawable.wp);
    }
    public Type getType()
    {
        return Type.PAWN;
    }
    public int getColor()
    {
        return this.color;
    }
    public String toString() {
        return type.name() + ": " + this.x + ", " + this.y;
    }
    @Override
    public void draw(Canvas canvas) {
        if(color == 0)
        {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, wp.getWidth(), wp.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Rect dst = new Rect(ySpot, xSpot, (int)GameView.squareSize + ySpot, (int)GameView.squareSize + xSpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(wp, src, dst, p);
        }
        else {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, bp.getWidth(), bp.getHeight());
            int xSpot = x * (int) GameView.squareSize;
            int ySpot = y * (int) GameView.squareSize;
            Rect dst = new Rect(ySpot, xSpot, (int) GameView.squareSize + ySpot, (int) GameView.squareSize + xSpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(bp, src, dst, p);
        }
    }
    public boolean isValidPath(int finalX, int finalY, Piece [][] board)
    {
        int ydif = Math.abs(finalY - this.y);
        int xdif = Math.abs(finalX - this.x);
        if(ydif == 1 && xdif != 1){
            return false;
        }
        else if(ydif == 1 && xdif == 1){
            if (board[finalY][finalX].color == this.color){
                return false;
            }
            else
                return true;
        }
        else if(this.firstMove && xdif == 2 && ydif == 0){
            if(finalX > this.x){
                while(this.x != finalX) {
                    if(board[this.y][this.x+1] != null){
                        return false;
                    }
                    this.x++;
                }
                return true;
            }
            if(finalX < this.x){
                while(this.x != finalX) {
                    if(board[this.y][this.x-1] != null){
                        return false;
                    }
                    this.x--;
                }
                return true;
            }
        }
        if((xdif == 1 && ydif == 0)) {
            if (board[finalY][finalX] != null) {
                return false;
            }
            return true;
        }
        else
            return false;
    }
}
