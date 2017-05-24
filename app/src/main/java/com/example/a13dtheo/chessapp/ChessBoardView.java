package com.example.a13dtheo.chessapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 13dth on 5/24/2017.
 */

public class ChessBoardView extends View {
    private Paint paint;

    public ChessBoardView(Context context, AttributeSet attrs) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0, 0, 100, 100, paint);
    }
}
