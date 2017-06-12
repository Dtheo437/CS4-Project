//Seems FIXed
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

import java.io.PipedReader;

/**
 * Created by AJ on 6/5/2017.
 */

public class Rook extends Piece
{
    private Bitmap br;
    private Bitmap wr;
    Type type;
    public Rook(int x, int y, int color, Resources res)
    {
        super(x,y,color);
        type = Type.ROOK;
        br = BitmapFactory.decodeResource(res,R.drawable.br);
        wr = BitmapFactory.decodeResource(res, R.drawable.wr);
    }
    public Type getType()
    {
        return Type.ROOK;
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
            Rect src = new Rect(0, 0, wr.getWidth(), wr.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Rect dst = new Rect(ySpot, xSpot, (int)GameView.squareSize + ySpot, (int)GameView.squareSize + xSpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(wr, src, dst, p);
        }
        else {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, br.getWidth(), br.getHeight());
            int xSpot = x * (int) GameView.squareSize;
            int ySpot = y * (int) GameView.squareSize;
            Rect dst = new Rect(ySpot, xSpot, (int) GameView.squareSize + ySpot, (int) GameView.squareSize + xSpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(br, src, dst, p);
        }
    }
    public boolean isValidPath(int finalX, int finalY, Piece [][] board)
    {
        int tempx;
        int tempy;
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if(xdif<=7 && ydif ==0){
            if (finalX > this.x) {
                tempx=this.x; tempy=this.y;
                while (finalX != tempx) {
                    if (board[tempx + 1][tempy] != null) {
                        if (this.color == board[tempx + 1][tempy].color) {
                            return false;
                        }
                        else
                            finalX = tempx+1;
                    }
                    tempx++;
                }
                return true;
            }
            else if (finalX < this.x) {
                tempx=this.x; tempy=this.y;
                while (finalX != tempx) {
                    if (board[tempx - 1][tempy] != null) {
                        if (this.color == board[tempx - 1][tempy].color) {
                            return false;
                        }
                        else
                            finalX = tempx-1;
                    }
                    tempx--;
                }
                return true;
            }
        }
        else if (xdif==0 && ydif<=7){
            if (finalY > this.y) {
                tempx=this.x; tempy=this.y;
                while (finalY != tempy) {
                    if (board[tempx][tempy+1] != null) {
                        if (this.color == board[tempx][tempy + 1].color) {
                            return false;
                        } else
                            finalY = tempy+1;
                    }
                    tempy++;
                }
                return true;
            }
            else if (finalY < this.y) {
                tempx=this.x; tempy=this.y;
                while (finalY != tempy) {
                    if (board[tempx][tempy - 1] != null) {
                        if (this.color == board[tempx][tempy - 1].color) {
                            return false;
                        }
                        else
                            finalY = tempy-1;
                    }
                    tempy--;
                }
                return true;
            }
        }
        return false;
    }
}
