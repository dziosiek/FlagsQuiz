package com.quizgame.quizgame;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    RelativeLayout myLayout;
    AnimationDrawable animationDrawable;
    AnimationClass animationClass;
    TextView scoreInt,scoreMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        this.animationClass = new AnimationClass((RelativeLayout) findViewById(R.id.scores_layout),
                500,4500);



        scoreMsg = (TextView)findViewById(R.id.score_msg);
        scoreInt = (TextView)findViewById(R.id.score_int);

        scoreMsg.setText("Twój Wynik:\n");
        scoreInt.setText(String.valueOf(getIntent().getExtras().get("SCORE")));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Scores.this,MainActivity.class);
                startActivity(intent);
            }
        }, 5500);
    }
}
