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

    @Override
    public void draw(Canvas canvas) {
        if(color == 0)
        {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, wr.getWidth(), wr.getHeight());
            int xSpot = x * (int)GameView.squareSize;
            int ySpot = y * (int)GameView.squareSize;
            Log.i("DEBUG", String.valueOf(xSpot) + " " + String.valueOf(ySpot));
            Rect dst = new Rect(xSpot, ySpot, (int)GameView.squareSize + xSpot, (int)GameView.squareSize + ySpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(wr, src, dst, p);
        }
        else {
            Paint p = new Paint();
            Rect src = new Rect(0, 0, br.getWidth(), br.getHeight());
            int xSpot = x * (int) GameView.squareSize;
            int ySpot = y * (int) GameView.squareSize;
            Log.i("DEBUG", String.valueOf(xSpot) + " " + String.valueOf(ySpot));
            Rect dst = new Rect(xSpot, ySpot, (int) GameView.squareSize + xSpot, (int) GameView.squareSize + ySpot);
//        Rect trial = new Rect(40, 0, (int)GameView.squareSize + 40, (int)GameView.squareSize);
            canvas.drawBitmap(br, src, dst, p);
        }
    }

    public boolean isValidPath(int finalX, int finalY, Piece [][] board)
    {
        int xdif = Math.abs(finalX - this.x);
        int ydif = Math.abs(finalY - this.y);
        if(xdif<=7 && ydif ==0){
            if (finalX > this.x) {
                while (finalX != this.x) {
                    if (board[this.x + 1][this.y] != null) {
                        if (this.color == board[this.x + 1][this.y].color) {
                            return false;
                        }
                        else
                            finalX = this.x+1;
                    }
                    this.x++;
                }
                return true;
            }
            else if (finalX < this.x) {
                while (finalX != this.x) {
                    if (board[this.x - 1][this.y] != null) {
                        if (this.color == board[this.x - 1][this.y].color) {
                            return false;
                        }
                        else
                            finalX = this.x-1;
                    }
                    this.x--;
                }
                return true;
            }
        }
        else if (xdif==0 && ydif<=7){
            if (finalY > this.y) {
                while (finalY != this.y) {
                    if (board[this.x][this.y+1] != null) {
                        if (this.color == board[this.x][this.y + 1].color) {
                            return false;
                        } else
                            finalY = this.y+1;
                    }
                    this.y++;
                }
                return true;
            }
            else if (finalY < this.y) {
                while (finalY != this.y) {
                    if (board[this.x][this.y - 1] != null) {
                        if (this.color == board[this.x][this.y - 1].color) {
                            return false;
                        }
                        else
                            finalY = this.y-1;
                    }
                    this.y--;
                }
                return true;
            }
        }
        return false;
    }
}
