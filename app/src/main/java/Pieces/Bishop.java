//UNKNOWN ERROR
package Pieces;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.example.aj.chessapp.*;

import static com.example.aj.chessapp.R.drawable.abc_text_select_handle_left_mtrl_dark;
import static com.example.aj.chessapp.R.drawable.bb;

/**
 * Created by AJ on 6/5/2017.
 */

public class Bishop extends Piece
{
    private Bitmap bb;
    private Bitmap wb;
    Type type;
    public Bishop(int x, int y, int color, Resources res)
    {
        super(x,y,color);
        type = Type.BISHOP;
        bb = BitmapFactory.decodeResource(res, R.drawable.bb);
        wb = BitmapFactory.decodeResource(res, R.drawable.wb);
    }
    public Type getType()
    {
        return Type.BISHOP;
    }
    public int getColor()
    {
        return this.color;
    }
    public String toString() {
        return type.name() + ": " + this.x + ", " + this.y;
    }
    public boolean isValidPath(int finalX, int finalY, Piece[][] board)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if (finalY > this.y && finalX > this.x){
            while (this.y != finalY && this.x != finalX){
                if (board[this.y+1][this.x+1] != null){
                    if (this.color == board[this.y+1][this.x+1].color){
                        return false;
                    }
                    else {
                        finalY = this.y+1;
                        finalX = this.x+1;
                    }
                }
                this.y++;
                this.x++;
            }
            return true;
        }
        else if(finalY < this.y && finalX < this.x){
            while (this.y != finalY && this.x != finalX){
                if (board[this.y-1][this.x-1] != null){
                    if (this.color == board[this.y-1][this.x-1].color){
                        return false;
                    }
                    else {
                        finalY = this.y-1;
                        finalX = this.x-1;
                    }
                }
                this.y--;
                this.x--;
            }
            return true;
        }
        else if(finalY > this.y && finalX < this.x){
            while (this.y != finalY && this.x != finalX){
                if (board[this.y+1][this.x-1] != null){
                    if (this.color == board[this.y+1][this.x-1].color){
                        return false;
                    }
                    else {
                        finalY = this.y+1;
                        finalX = this.x-1;
                    }
                }
                this.y++;
                this.x--;
            }
            return true;
        }
        else if(finalY < this.y && finalX > this.x){
            while (this.y != finalY && this.x != finalX){
                if (board[this.y-1][this.x+1] != null){
                    if (this.color == board[this.y-1][this.x+1].color){
                        return false;
                    }
                    else {
                        finalX = this.y-1;
                        finalY = this.x+1;
                    }
                }
                this.y--;
                this.x++;
            }
            return true;
        }
        else
            return false;
    }

    public void draw(Canvas canvas) {
        if(color == 0)
        {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, wb.getWidth(), wb.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Rect dst = new Rect(ySpot, xSpot, (int)GameView.squareSize + ySpot, (int)GameView.squareSize + xSpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(wb, src, dst, p);
        }
        else
        {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, bb.getWidth(), bb.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Rect dst = new Rect(ySpot, xSpot, (int)GameView.squareSize + ySpot, (int)GameView.squareSize + xSpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(bb, src, dst, p);
        }

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
    //probably something to do with rect constructor ok the constructor is left top right bottom right? maybe
}
