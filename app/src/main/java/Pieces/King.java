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

public class King extends Piece
{
    private Bitmap bk;
    private Bitmap wk;
    Type type;
    public King(int x, int y, int color, Resources res)
    {
        super(x,y,color);
        type = Type.KING;
        bk = BitmapFactory.decodeResource(res, R.drawable.bk);
        wk = BitmapFactory.decodeResource(res, R.drawable.wk);
    }
    public Type getType()
    {
        return Type.KING;
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
            Rect src = new Rect(0, 0, wk.getWidth(), wk.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Rect dst = new Rect(ySpot, xSpot, (int)GameView.squareSize + ySpot, (int)GameView.squareSize + xSpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(wk, src, dst, p);
        }
        else
        {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, bk.getWidth(), bk.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Rect dst = new Rect(ySpot, xSpot, (int)GameView.squareSize + ySpot, (int)GameView.squareSize + xSpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(bk, src, dst, p);
        }
    }
    public boolean isValidPath(int finalX, int finalY, Piece [][] board)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if(xdif<=1 && ydif <= 1){
            if (finalX > this.x && finalY > this.y){
                if(board[this.x+1][this.y+1] != null && board[this.x+1][this.y+1].color == this.color){
                    return false;
                }
                return true;
            }
            else if (finalX < this.x && finalY < this.y){
                if(board[this.x-1][this.y-1] != null && board[this.x-1][this.y-1].color == this.color){
                    return false;
                }
                return true;
            }
            else if (finalX > this.x && finalY < this.y){
                if(board[this.x+1][this.y-1] != null && board[this.x+1][this.y-1].color == this.color){
                    return false;
                }
                return true;
            }
            else if (finalX < this.x && finalY > this.y){
                if(board[this.x-1][this.y+1] != null && board[this.x-1][this.y+1].color == this.color){
                    return false;
                }
                return true;
            }
            else if (finalX == this.x && finalY > this.y){
                if(board[this.x][this.y+1] != null && board[this.x][this.y+1].color == this.color){
                    return false;
                }
                return true;
            }
            else if (finalX == this.x && finalY < this.y){
                if(board[this.x][this.y-1] != null && board[this.x][this.y-1].color == this.color){
                    return false;
                }
                return true;
            }
            else if (finalX > this.x && finalY == this.y){
                if(board[this.x+1][this.y] != null && board[this.x+1][this.y].color == this.color){
                    return false;
                }
                return true;
            }
            else if (finalX < this.x && finalY == this.y){
                if(board[this.x-1][this.y] != null && board[this.x-1][this.y].color == this.color){
                    return false;
                }
                return true;
            }
        }
        return false;
    }

}
