//Should Work now
//Error - Parameters FinalX and FinalY were switched - Unknown Wont move right now - Should be fixed
//Error in movement checking - Fixed
//Somewhere in the isvalidpath it changes the values of x and y - Should be fixed -created temp value
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
    public String toString() {
        return type.name() + ": " + this.x + ", " + this.y;
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
        int tempx;
        int tempy;
        Log.i("DEBUG","KING CLASS: FinalX : " + finalX + " this.x : " + this.x);
        Log.i("DEBUG","KING CLASS: FinalY : " + finalY + " this.y : " + this.y);
        int xdif = Math.abs(this.x - finalX);
        int ydif = Math.abs(this.y - finalY);
//        Log.i("DEBUG","KING CLASS: xdif: " + xdif);
//        Log.i("DEBUG","KING CLASS: ydif: " + ydif);
        if(ydif<=1 && xdif <= 1){
//            Log.i("DEBUG","KING CLASS: Test Entry");
            if (finalY > this.y && finalX > this.x){
                tempx=this.x+1; tempy=this.y+1;
                if(board[tempx][tempy] != null && board[tempx][tempy].color == this.color){
                    return false;
                }
                Log.i("DEBUG","KING CLASS: Down, Right");//-Definitely Works
                return true;
            }
            else if (finalY < this.y && finalX < this.x){
                tempx=this.x-1; tempy=this.y-1;
                if(board[tempx][tempy] != null && board[tempx][tempy].color == this.color){
                    return false;
                }
                Log.i("DEBUG","KING CLASS: Up, Left"); //- Definitely Works
                return true;
            }
            else if (finalY > this.y && finalX < this.x){
                tempx=this.x-1; tempy=this.y+1;
                if(board[tempx][tempy] != null && board[tempx][tempy].color == this.color){
                    return false;
                }
                Log.i("DEBUG","KING CLASS: Up, Right"); //- Definitely Works
                return true;
            }
            else if (finalY < this.y && finalX > this.x){
                tempx=this.x+1; tempy=this.y-1;
                if(board[tempx][tempy] != null && board[tempx][tempy].color == this.color){
                    return false;
                }
                Log.i("DEBUG","KING CLASS: Down, Left");//-Definitely Works
                return true;
            }
            else if (finalY == this.y && finalX > this.x){
                tempx=this.x+1; tempy=this.y;
                if(board[tempy][tempx] != null && board[tempy][tempx].color == this.color){
                    return false;
                }
                Log.i("DEBUG","KING CLASS: Down");
                return true;
            }
            else if (finalY == this.y && finalX < this.x){
                tempx=this.x-1; tempy=this.y;
                if(board[tempy][tempx] != null && board[tempy][tempx].color == this.color){
                    return false;
                }
                Log.i("DEBUG","KING CLASS: Up");
                return true;
            }
            else if (finalY > this.y && finalX == this.x){
                tempx=this.x; tempy=this.y+1;
                if(board[tempy][tempx] != null && board[tempy][tempx].color == this.color){
                    return false;
                }
                Log.i("DEBUG","KING CLASS: Right");
                return true;
            }
            else if (finalY < this.y && finalX == this.x){
                tempx=this.x; tempy=this.y-1;
                if(board[tempy][tempx] != null && board[tempy][tempx].color == this.color){
                    return false;
                }
                Log.i("DEBUG","KING CLASS: Left");
                return true;
            }
        }
        return false;
    }

}
