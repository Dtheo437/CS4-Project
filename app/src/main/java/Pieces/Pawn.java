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
    Type type;
    Boolean firstMove;
    public Pawn(int x, int y, int color, Resources res)
    {
        super(x,y,color);
        type = Type.PAWN;
        firstMove=true;
        bp = BitmapFactory.decodeResource(res,R.drawable.bp);
        wp = BitmapFactory.decodeResource(res, R.drawable.wp);
    }
    public Type getType()
    {
        return Type.PAWN;
    }

    @Override
    public void draw(Canvas canvas) {
        if(color == 0)
        {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, wp.getWidth(), wp.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Log.i("DEBUG", String.valueOf(xSpot) + " " + String.valueOf(ySpot));
            Rect dst = new Rect(xSpot, ySpot, (int)GameView.squareSize + xSpot, (int)GameView.squareSize + ySpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(wp, src, dst, p);
        }
        else {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, bp.getWidth(), bp.getHeight());
            int xSpot = x * (int) GameView.squareSize;
            int ySpot = y * (int) GameView.squareSize;
            Log.i("DEBUG", String.valueOf(xSpot) + " " + String.valueOf(ySpot));
            Rect dst = new Rect(xSpot, ySpot, (int) GameView.squareSize + xSpot, (int) GameView.squareSize + ySpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(bp, src, dst, p);
        }
    }

    public boolean isValidPath(int finalX, int finalY, Piece [][] board)
    {
        int ydif = Math.abs(finalY - this.y);
        int xdif = Math.abs(finalX - this.x);
        if(xdif == 1 && ydif != 1){
            return false;
        }
        else if(xdif == 1 && ydif == 1){
            if (board[finalX][finalY].color == this.color){
                return false;
            }
            else
                return true;
        }
        else if(this.firstMove && ydif == 2 && xdif == 0){
            if(finalY > this.y){
                while(this.y != finalY) {
                    if(board[this.x][this.y+1] != null){
                        return false;
                    }
                    this.y++;
                }
                return true;
            }
            if(finalY < this.y){
                while(this.y != finalY) {
                    if(board[this.x][this.y-1] != null){
                        return false;
                    }
                    this.y--;
                }
                return true;
            }
        }
        if((ydif == 1 && xdif == 0)) {
            if (board[finalX][finalY] != null) {
                return false;
            }
            return true;
        }
        else
            return false;
    }
}
