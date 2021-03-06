package Pieces;
import android.graphics.Canvas;

import com.example.aj.chessapp.*;
/**
 * Created by AJ on 5/31/2017.
 */

public abstract class Piece
{
    public static final int WHITE = 0;
    public static final int BLACK = 1;

    // parameters for the x and y coordinates on the board and the color of the piece.
    public int x;
    public int y;
    public int color;
    public Piece(int x, int y, int color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public abstract boolean isValidPath(int finalX, int finalY, Piece[][] board);
    //Checks if the path is valid
    //public abstract int[][] move(int startX, int startY, int finalX, int finalY);
    //Provides a set of movement commands for the piece
    public abstract Type getType();
    public abstract int getColor();
    public abstract void draw(Canvas canvas);
}
