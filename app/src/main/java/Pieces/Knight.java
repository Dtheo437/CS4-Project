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

public class Knight extends Piece
{
    private Bitmap bkn;
    private Bitmap wkn;
    Type type;
    public Knight(int x, int y, int color, Resources res)
    {
        super(x,y,color);
        type = Type.KNIGHT;
        bkn = BitmapFactory.decodeResource(res, R.drawable.bkn);
        wkn = BitmapFactory.decodeResource(res, R.drawable.wkn);
    }
    public Type getType()
    {
        return Type.KNIGHT;
    }
    public int getColor()
    {
        return this.color;
    }
    @Override
    public void draw(Canvas canvas) {
        if(color == 0)
        {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, wkn.getWidth(), wkn.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Log.i("DEBUG", String.valueOf(xSpot) + " " + String.valueOf(ySpot));
            Rect dst = new Rect(xSpot, ySpot, (int)GameView.squareSize + xSpot, (int)GameView.squareSize + ySpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(wkn, src, dst, p);
        }
        else {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, bkn.getWidth(), bkn.getHeight());
            int xSpot = x * (int) GameView.squareSize;
            int ySpot = y * (int) GameView.squareSize;
            Log.i("DEBUG", String.valueOf(xSpot) + " " + String.valueOf(ySpot));
            Rect dst = new Rect(xSpot, ySpot, (int) GameView.squareSize + xSpot, (int) GameView.squareSize + ySpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(bkn, src, dst, p);
        }
    }
    public boolean isValidPath(int finalX, int finalY, Piece [][] board)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if (board[finalX][finalY] != null){
            if (this.color == board[finalX][finalY].color){
                return false;
            }
        }
        if((xdif == 2 && ydif==1) || (xdif == 1 && ydif==2))
            return true;
        return false;
    }
}
