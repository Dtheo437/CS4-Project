//FUCKED UP
//SET FIRST MOVE TO FALSE IN ISVALIDPATH METHOD
//Somewhere in the isvalidpath it changes the values of x and y - Should be fixed -created temp value
//4 outside pawns wont move
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
        Log.i("DEBUG", "Pawn , this.x: " + this.x + " this.y: " + this.y);
        Log.i("DEBUG", "Pawn , finalX: " + finalX + " finalY: " + finalY);
        int ydif = Math.abs(finalY - this.y);
        int xdif = Math.abs(finalX - this.x);
        int tempx;
        int tempy;
        if(ydif == 1 && xdif != 1){
            return false;
        }
        else if(ydif == 1 && xdif == 1 && this.color == Piece.WHITE){
            tempx = this.x;
            if (board[finalX][finalY].color == this.color){
                return false;
            }
            else if(finalX > tempx)
                return false;
            else
                return true;
        }
        else if(ydif == 1 && xdif == 1 && this.color == Piece.BLACK){
            tempx = this.x;
            if (board[finalX][finalY].color == this.color){
                return false;
            }
            else if(finalX < tempx)
                return false;
            else
                return true;
        }
        else if(this.firstMove && xdif == 2 && ydif == 0 && this.color == Piece.WHITE){
            //Move White Pawn forward 2
            tempx = this.x;
            tempy = this.y;
            if(finalX < tempx){
                while(tempx != finalX) {
                    if(board[tempx-1][tempy] != null){
                        return false;
                    }
                    tempx--;
                }
                firstMove = false;
                return true;
            }
        }
        else if(this.firstMove && xdif == 2 && ydif == 0 && this.color == Piece.BLACK){
            //Move Black Pawn forward 2
            tempx = this.x;
            tempy = this.y;
            if(finalX > tempx){
                while(tempx != finalX) {
                    if(board[tempx+1][tempy] != null){
                        return false;
                    }
                    tempx++;
                }
                firstMove = false;
                return true;
            }
        }
        if((xdif == 1 && ydif == 0) && this.color == Piece.WHITE) {
            //White Forward 1
            if(finalX<this.x) {
                if (board[finalX][finalY] != null) {
                    return false;
                }
                firstMove = false;
                return true;
            }
            return false;
        }
        if((xdif == 1 && ydif == 0) && this.color == Piece.BLACK) {
            //Black Forward 1
            if(finalX>this.x) {
                if (board[finalX][finalY] != null) {
                    return false;
                }
                firstMove = false;
                return true;
            }
            return false;
        }
        else
            return false;
    }
}
