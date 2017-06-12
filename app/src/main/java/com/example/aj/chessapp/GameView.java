//Implement a pawn conversion
package com.example.aj.chessapp;

import android.graphics.*;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

import static com.example.aj.chessapp.R.drawable.bb;

/**
 * Created by AJ on 6/7/2017.
 */

public class GameView extends View
{
    private Piece[][] board;
    public Piece selectedPiece;
    public boolean whiteTurn;
    public static float squareSize;
    public GameView(Context context, AttributeSet attr)
    {
        super(context);
        whiteTurn = true;
        board = new Piece[8][8];

        board[0][0] = new Rook(0, 0, Piece.BLACK, getResources());
        board[0][1] = new Knight(0, 1, Piece.BLACK, getResources());
        board[0][2] = new Bishop(0, 2, Piece.BLACK, getResources());
        board[0][3] = new Queen(0, 3, Piece.BLACK, getResources());
        board[0][4] = new King(0, 4, Piece.BLACK, getResources());
        board[0][5] = new Bishop(0, 5, Piece.BLACK, getResources());
        board[0][6] = new Knight(0, 6, Piece.BLACK, getResources());
        board[0][7] = new Rook(0, 7, Piece.BLACK, getResources());

        board[1][0] = new Pawn(1, 0, Piece.BLACK, getResources());
        board[1][1] = new Pawn(1, 1, Piece.BLACK, getResources());
        board[1][2] = new Pawn(1, 2, Piece.BLACK, getResources());
        board[1][3] = new Pawn(1, 3, Piece.BLACK, getResources());
        board[1][4] = new Pawn(1, 4, Piece.BLACK, getResources());
        board[1][5] = new Pawn(1, 5, Piece.BLACK, getResources());
        board[1][6] = new Pawn(1, 6, Piece.BLACK, getResources());
        board[1][7] = new Pawn(1, 7, Piece.BLACK, getResources());

        board[7][0] = new Rook(7, 0, Piece.WHITE, getResources());
        board[7][1] = new Knight(7, 1, Piece.WHITE, getResources());
        board[7][2] = new Bishop(7, 2, Piece.WHITE, getResources());
        board[7][3] = new Queen(7, 3, Piece.WHITE, getResources());
        board[7][4] = new King(7, 4, Piece.WHITE, getResources());
        board[7][5] = new Bishop(7, 5, Piece.WHITE, getResources());
        board[7][6] = new Knight(7, 6, Piece.WHITE, getResources());
        board[7][7] = new Rook(7, 7, Piece.WHITE, getResources());

        board[6][0] = new Pawn(6, 0, Piece.WHITE, getResources());
        board[6][1] = new Pawn(6, 1, Piece.WHITE, getResources());
        board[6][2] = new Pawn(6, 2, Piece.WHITE, getResources());
        board[6][3] = new Pawn(6, 3, Piece.WHITE, getResources());
        board[6][4] = new Pawn(6, 4, Piece.WHITE, getResources());
        board[6][5] = new Pawn(6, 5, Piece.WHITE, getResources());
        board[6][6] = new Pawn(6, 6, Piece.WHITE, getResources());
        board[6][7] = new Pawn(6, 7, Piece.WHITE, getResources());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float col = event.getX()/squareSize;
        float row = event.getY()/squareSize;
        if(selectedPiece == null)
        {
            if(board[(int)row][(int)col] != null)
            {
                if(board[(int)row][(int)col].getColor()==Piece.WHITE && whiteTurn)
                    selectedPiece = board[(int)row][(int)col];
                else if(board[(int)row][(int)col].getColor()==Piece.BLACK && !whiteTurn)
                    selectedPiece = board[(int)row][(int)col];
                else
                {
                    Log.i("DEBUG","SP NULL: Wrong Turn");
                }
                if(selectedPiece != null)
                    Log.i("DEBUG","SP NULL" + selectedPiece.toString());
            }
        }
        else
        {
            if(board[(int)row][(int)col] == null && selectedPiece.isValidPath((int)row,(int)col,board))
            {
                Log.i("DEBUG", "Valid Path " + selectedPiece.x);
                Log.i("DEBUG", "Valid Path " + selectedPiece.y);
                board[selectedPiece.x][selectedPiece.y] =null;
                if(board[selectedPiece.x][selectedPiece.y] ==null)
                    Log.i("DEBUG", "Null at " + "x: " + selectedPiece.x +" y: " + selectedPiece.y);
                selectedPiece.x = (int)row;
                selectedPiece.y = (int)col;
                board[(int)row][(int)col] = selectedPiece;
                Log.i("DEBUG", selectedPiece.toString());
                selectedPiece = null;
                whiteTurn = !whiteTurn;
            }
            else if(board[(int)row][(int)col] == null && !selectedPiece.isValidPath((int)row,(int)col,board))
            {
                Log.i("DEBUG", "Invalid Path " + selectedPiece.toString());
                selectedPiece =null;
                //((TextView)findViewById(R.id.Location)).setText("Invalid Move"); - doesnt work
            }
            else if(board[(int)row][(int)col].getColor()==selectedPiece.getColor())
            {
                selectedPiece = board[(int)row][(int)col];
                Log.i("DEBUG", "New SelectedPiece " + selectedPiece.toString());
            }
            else if(board[(int)row][(int)col].getColor()!=selectedPiece.getColor())
            {
                if(selectedPiece.isValidPath((int)row,(int)col,board))
                {
                    Log.i("DEBUG", "Take Piece " + selectedPiece.x);
                    Log.i("DEBUG", "Take Piece " + selectedPiece.y);
                    board[selectedPiece.x][selectedPiece.y] =null;
                    selectedPiece.x = (int)row;
                    selectedPiece.y = (int)col;
                    board[(int)row][(int)col] = selectedPiece;
                    Log.i("DEBUG", selectedPiece.toString());
                    selectedPiece = null;
                    whiteTurn = !whiteTurn;
                }
                else
                {
                    Log.i("DEBUG", "Invalid Path - Take" + selectedPiece.toString());
                    selectedPiece = null;
                }
            }
        }
        this.invalidate();
        return super.onTouchEvent(event);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int lightBrown = Color.rgb(214, 201, 154);
        int darkBrown = Color.rgb(94, 86, 58);

        Paint squareColor = new Paint();
        squareColor.setColor(lightBrown);
        squareColor.setStyle(Paint.Style.FILL);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        squareSize = width / 8.0f;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                float left = j * squareSize;
                float top = i * squareSize;
                float right = j * squareSize + squareSize;
                float bottom = i * squareSize + squareSize;
                canvas.drawRect(left, top, right, bottom, squareColor);
                // Alternate colors for squares
                if (squareColor.getColor() == lightBrown) {
                    squareColor.setColor(darkBrown);
                } else {
                    squareColor.setColor(lightBrown);
                }
            }
            if (squareColor.getColor() == lightBrown) {
                squareColor.setColor(darkBrown);
            } else {
                squareColor.setColor(lightBrown);
            }
        }
        for(int i=0;i<8;i++)
        {
            for(int j =0;j<8;j++)
            {
                //Draw pieces
                if (board[i][j] != null) {
                    board[i][j].draw(canvas);
                }
            }
        }
    }
}
