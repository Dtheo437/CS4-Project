package com.example.aj.chessapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChessApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_app);
        Button rules = (Button) findViewById(R.id.rules);
        Button game = (Button) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ChessApp.this, Game.class);
                startActivity(intent);
            }
        });
        rules.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.chessusa.com/chess-rules.html"));
                startActivity(url);
            }

        });
    }
}
