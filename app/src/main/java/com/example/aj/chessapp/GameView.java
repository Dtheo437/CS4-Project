package com.example.aj.chessapp;

import android.graphics.*;
import android.graphics.Color;
import android.view.View;
import android.content.Context;
/**
 * Created by AJ on 6/7/2017.
 */

public class GameView extends View
{
    public GameView(Context context)
    {
        super(context);

    }
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Rect Rect1 = new Rect();
        Rect1.set(0, 0, canvas.getWidth()/8,canvas.getHeight()/8);
        Rect Rect2 = new Rect();
        Rect2.set(canvas.getWidth()/8, 0, canvas.getWidth()/4,canvas.getHeight()/8);
        Rect Rect3 = new Rect();
        Rect3.set(canvas.getWidth()/4, 0, (canvas.getWidth()/8) * 3, canvas.getHeight()/8);
        Rect Rect4 = new Rect();
        Rect4.set(canvas.getWidth()/8 * 3, 0, canvas.getWidth()/2,canvas.getHeight()/8);
        Rect Rect5 = new Rect();
        Rect5.set(canvas.getWidth()/2, 0, canvas.getWidth()/8 *5,canvas.getHeight()/8);
        Rect Rect6 = new Rect();
        Rect6.set(canvas.getWidth()/8 * 5, 0, canvas.getWidth()/8 *6,canvas.getHeight()/8);
        Rect Rect7 = new Rect();
        Rect7.set(canvas.getWidth()/8 * 6, 0, canvas.getWidth()/8*7,canvas.getHeight()/8);
        Rect Rect8 = new Rect();
        Rect8.set(canvas.getWidth()/8 * 7, 0, canvas.getWidth(),canvas.getHeight()/8);

        Rect Rect9 = new Rect();
        Rect9.set(0, canvas.getHeight()/8, canvas.getWidth()/8,canvas.getHeight()/4);
        Rect Rect10 = new Rect();
        Rect10.set(canvas.getWidth()/8, canvas.getHeight()/8, canvas.getWidth()/4,canvas.getHeight()/4);
        Rect Rect11 = new Rect();
        Rect11.set(canvas.getWidth()/4, canvas.getHeight()/8, canvas.getWidth()/8*3,canvas.getHeight()/4);
        Rect Rect12 = new Rect();
        Rect12.set(canvas.getWidth()/8*3, canvas.getHeight()/8, canvas.getWidth()/2,canvas.getHeight()/4);
        Rect Rect13 = new Rect();
        Rect13.set(canvas.getWidth()/2, canvas.getHeight()/8, canvas.getWidth()/8*5,canvas.getHeight()/4);
        Rect Rect14 = new Rect();
        Rect14.set(canvas.getWidth()/8*5, canvas.getHeight()/8, canvas.getWidth()/8*6,canvas.getHeight()/4);
        Rect Rect15 = new Rect();
        Rect15.set(canvas.getWidth()/8*6, canvas.getHeight()/8, canvas.getWidth()/8*7,canvas.getHeight()/4);
        Rect Rect16 = new Rect();
        Rect16.set(canvas.getWidth()/8*7, canvas.getHeight()/8, canvas.getWidth(),canvas.getHeight()/4);

        Rect Rect17 = new Rect();
        Rect17.set(0, canvas.getHeight()/4, canvas.getWidth()/8,canvas.getHeight()/8*3);
        Rect Rect18 = new Rect();
        Rect18.set(canvas.getWidth()/8, canvas.getHeight()/4, canvas.getWidth()/4,canvas.getHeight()/8*3);
        Rect Rect19 = new Rect();
        Rect19.set(canvas.getWidth()/4, canvas.getHeight()/4, canvas.getWidth()/8*3,canvas.getHeight()/8*3);
        Rect Rect20 = new Rect();
        Rect20.set(canvas.getWidth()/8*3, canvas.getHeight()/4, canvas.getWidth()/2,canvas.getHeight()/8*3);
        Rect Rect21 = new Rect();
        Rect21.set(canvas.getWidth()/2, canvas.getHeight()/4, canvas.getWidth()/8*5,canvas.getHeight()/8*3);
        Rect Rect22 = new Rect();
        Rect22.set(canvas.getWidth()/8*5, canvas.getHeight()/4, canvas.getWidth()/8*6,canvas.getHeight()/8*3);
        Rect Rect23 = new Rect();
        Rect23.set(canvas.getWidth()/8*6, canvas.getHeight()/4, canvas.getWidth()/8*7,canvas.getHeight()/8*3);
        Rect Rect24 = new Rect();
        Rect24.set(canvas.getWidth()/8*7, canvas.getHeight()/4, canvas.getWidth(),canvas.getHeight()/8*3);

        Rect Rect25 = new Rect();
        Rect25.set(0, canvas.getHeight()/8*3, canvas.getWidth()/8,canvas.getHeight()/2);
        Rect Rect26 = new Rect();
        Rect26.set(canvas.getWidth()/8, canvas.getHeight()/8*3, canvas.getWidth()/4,canvas.getHeight()/2);
        Rect Rect27 = new Rect();
        Rect27.set(canvas.getWidth()/4, canvas.getHeight()/8*3, canvas.getWidth()/8*3,canvas.getHeight()/2);
        Rect Rect28 = new Rect();
        Rect28.set(canvas.getWidth()/8*3, canvas.getHeight()/8*3, canvas.getWidth()/2,canvas.getHeight()/2);
        Rect Rect29 = new Rect();
        Rect29.set(canvas.getWidth()/2, canvas.getHeight()/8*3, canvas.getWidth()/8*5,canvas.getHeight()/2);
        Rect Rect30 = new Rect();
        Rect30.set(canvas.getWidth()/8*5, canvas.getHeight()/8*3, canvas.getWidth()/8*6,canvas.getHeight()/2);
        Rect Rect31 = new Rect();
        Rect31.set(canvas.getWidth()/8*6, canvas.getHeight()/8*3, canvas.getWidth()/8*7,canvas.getHeight()/2);
        Rect Rect32 = new Rect();
        Rect32.set(canvas.getWidth()/8*7, canvas.getHeight()/8*3, canvas.getWidth(),canvas.getHeight()/2);

        Rect Rect33 = new Rect();
        Rect33.set(0, canvas.getHeight()/2, canvas.getWidth()/8,canvas.getHeight()/8*5);
        Rect Rect34 = new Rect();
        Rect34.set(canvas.getWidth()/8, canvas.getHeight()/2, canvas.getWidth()/4,canvas.getHeight()/8*5);
        Rect Rect35 = new Rect();
        Rect35.set(canvas.getWidth()/4, canvas.getHeight()/2, canvas.getWidth()/8*3,canvas.getHeight()/8*5);
        Rect Rect36 = new Rect();
        Rect36.set(canvas.getWidth()/8*3, canvas.getHeight()/2, canvas.getWidth()/2,canvas.getHeight()/8*5);
        Rect Rect37 = new Rect();
        Rect37.set(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/8*5,canvas.getHeight()/8*5);
        Rect Rect38 = new Rect();
        Rect38.set(canvas.getWidth()/8*5, canvas.getHeight()/2, canvas.getWidth()/8*6,canvas.getHeight()/8*5);
        Rect Rect39 = new Rect();
        Rect39.set(canvas.getWidth()/8*6, canvas.getHeight()/2, canvas.getWidth()/8*7,canvas.getHeight()/8*5);
        Rect Rect40 = new Rect();
        Rect40.set(canvas.getWidth()/8*7, canvas.getHeight()/2, canvas.getWidth(),canvas.getHeight()/8*5);

        Rect Rect41 = new Rect();
        Rect41.set(0, canvas.getHeight()/8*5, canvas.getWidth()/8,canvas.getHeight()/8*6);
        Rect Rect42 = new Rect();
        Rect42.set(canvas.getWidth()/8, canvas.getHeight()/8*5, canvas.getWidth()/4,canvas.getHeight()/8*6);
        Rect Rect43 = new Rect();
        Rect43.set(canvas.getWidth()/4, canvas.getHeight()/8*5, canvas.getWidth()/8*3,canvas.getHeight()/8*6);
        Rect Rect44 = new Rect();
        Rect44.set(canvas.getWidth()/8*3, canvas.getHeight()/8*5, canvas.getWidth()/2,canvas.getHeight()/8*6);
        Rect Rect45 = new Rect();
        Rect45.set(canvas.getWidth()/2, canvas.getHeight()/8*5, canvas.getWidth()/8*5,canvas.getHeight()/8*6);
        Rect Rect46 = new Rect();
        Rect46.set(canvas.getWidth()/8*5, canvas.getHeight()/8*5, canvas.getWidth()/8*6,canvas.getHeight()/8*6);
        Rect Rect47 = new Rect();
        Rect47.set(canvas.getWidth()/8*6, canvas.getHeight()/8*5, canvas.getWidth()/8*7,canvas.getHeight()/8*6);
        Rect Rect48 = new Rect();
        Rect48.set(canvas.getWidth()/8*7, canvas.getHeight()/8*5, canvas.getWidth(),canvas.getHeight()/8*6);

        Rect Rect49 = new Rect();
        Rect49.set(0, canvas.getHeight()/8*6, canvas.getWidth()/8,canvas.getHeight()/8*7);
        Rect Rect50 = new Rect();
        Rect50.set(canvas.getWidth()/8, canvas.getHeight()/8*6, canvas.getWidth()/4,canvas.getHeight()/8*7);
        Rect Rect51 = new Rect();
        Rect51.set(canvas.getWidth()/4, canvas.getHeight()/8*6, canvas.getWidth()/8*3,canvas.getHeight()/8*7);
        Rect Rect52 = new Rect();
        Rect52.set(canvas.getWidth()/8*3, canvas.getHeight()/8*6, canvas.getWidth()/2,canvas.getHeight()/8*7);
        Rect Rect53 = new Rect();
        Rect53.set(canvas.getWidth()/2, canvas.getHeight()/8*6, canvas.getWidth()/8*5,canvas.getHeight()/8*7);
        Rect Rect54 = new Rect();
        Rect54.set(canvas.getWidth()/8*5, canvas.getHeight()/8*6, canvas.getWidth()/8*6,canvas.getHeight()/8*7);
        Rect Rect55 = new Rect();
        Rect55.set(canvas.getWidth()/8*6, canvas.getHeight()/8*6, canvas.getWidth()/8*7,canvas.getHeight()/8*7);
        Rect Rect56 = new Rect();
        Rect56.set(canvas.getWidth()/8*7, canvas.getHeight()/8*6, canvas.getWidth(),canvas.getHeight()/8*7);


        Rect Rect57 = new Rect();
        Rect57.set(0, canvas.getHeight()/8*7, canvas.getWidth()/8,canvas.getHeight());
        Rect Rect58 = new Rect();
        Rect58.set(canvas.getWidth()/8, canvas.getHeight()/8*7, canvas.getWidth()/4,canvas.getHeight());
        Rect Rect59 = new Rect();
        Rect59.set(canvas.getWidth()/4, canvas.getHeight()/8*7, canvas.getWidth()/8*3,canvas.getHeight());
        Rect Rect60 = new Rect();
        Rect60.set(canvas.getWidth()/8*3, canvas.getHeight()/8*7, canvas.getWidth()/2,canvas.getHeight());
        Rect Rect61 = new Rect();
        Rect61.set(canvas.getWidth()/2, canvas.getHeight()/8*7, canvas.getWidth()/8*5,canvas.getHeight());
        Rect Rect62 = new Rect();
        Rect62.set(canvas.getWidth()/8*5, canvas.getHeight()/8*7, canvas.getWidth()/8*6,canvas.getHeight());
        Rect Rect63 = new Rect();
        Rect63.set(canvas.getWidth()/8*6, canvas.getHeight()/8*7, canvas.getWidth()/8*7,canvas.getHeight());
        Rect Rect64 = new Rect();
        Rect64.set(canvas.getWidth()/8*7, canvas.getHeight()/8*7, canvas.getWidth(),canvas.getHeight());

        Paint blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.FILL);
        Paint black = new Paint();
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL);

        canvas.drawRect(Rect1, blue);
        canvas.drawRect(Rect2, black);
        canvas.drawRect(Rect3, blue);
        canvas.drawRect(Rect4, black);
        canvas.drawRect(Rect5, blue);
        canvas.drawRect(Rect6, black);
        canvas.drawRect(Rect7, blue);
        canvas.drawRect(Rect8, black);

        canvas.drawRect(Rect9, black);
        canvas.drawRect(Rect10, blue);
        canvas.drawRect(Rect11, black);
        canvas.drawRect(Rect12, blue);
        canvas.drawRect(Rect13, black);
        canvas.drawRect(Rect14, blue);
        canvas.drawRect(Rect15, black);
        canvas.drawRect(Rect16, blue);

        canvas.drawRect(Rect17, blue);
        canvas.drawRect(Rect18, black);
        canvas.drawRect(Rect19, blue);
        canvas.drawRect(Rect20, black);
        canvas.drawRect(Rect21, blue);
        canvas.drawRect(Rect22, black);
        canvas.drawRect(Rect23, blue);
        canvas.drawRect(Rect24, black);

        canvas.drawRect(Rect25, black);
        canvas.drawRect(Rect26, blue);
        canvas.drawRect(Rect27, black);
        canvas.drawRect(Rect28, blue);
        canvas.drawRect(Rect29, black);
        canvas.drawRect(Rect30, blue);
        canvas.drawRect(Rect31, black);
        canvas.drawRect(Rect32, blue);

        canvas.drawRect(Rect33, blue);
        canvas.drawRect(Rect34, black);
        canvas.drawRect(Rect35, blue);
        canvas.drawRect(Rect36, black);
        canvas.drawRect(Rect37, blue);
        canvas.drawRect(Rect38, black);
        canvas.drawRect(Rect39, blue);
        canvas.drawRect(Rect40, black);

        canvas.drawRect(Rect41, black);
        canvas.drawRect(Rect42, blue);
        canvas.drawRect(Rect43, black);
        canvas.drawRect(Rect44, blue);
        canvas.drawRect(Rect45, black);
        canvas.drawRect(Rect46, blue);
        canvas.drawRect(Rect47, black);
        canvas.drawRect(Rect48, blue);

        canvas.drawRect(Rect49, blue);
        canvas.drawRect(Rect50, black);
        canvas.drawRect(Rect51, blue);
        canvas.drawRect(Rect52, black);
        canvas.drawRect(Rect53, blue);
        canvas.drawRect(Rect54, black);
        canvas.drawRect(Rect55, blue);
        canvas.drawRect(Rect56, black);

        canvas.drawRect(Rect57, black);
        canvas.drawRect(Rect58, blue);
        canvas.drawRect(Rect59, black);
        canvas.drawRect(Rect60, blue);
        canvas.drawRect(Rect61, black);
        canvas.drawRect(Rect62, blue);
        canvas.drawRect(Rect63, black);
        canvas.drawRect(Rect64, blue);
    }
}
