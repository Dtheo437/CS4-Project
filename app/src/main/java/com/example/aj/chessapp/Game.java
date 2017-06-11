package com.example.aj.chessapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Pieces.*;
public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}