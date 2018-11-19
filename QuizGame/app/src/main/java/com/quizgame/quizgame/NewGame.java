package com.quizgame.quizgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NewGame extends AppCompatActivity {

    RelativeLayout myLayout;
    AnimationDrawable animationDrawable;
    AnimationClass animationClass;
    GameEngine engine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

//        myLayout = (RelativeLayout) findViewById(R.id.new_game_layout);
        this.animationClass = new AnimationClass((RelativeLayout) findViewById(R.id.new_game_layout),
                500,4500);


        engine = new GameEngine((ImageView) findViewById(R.id.flag),
                (TextView) findViewById(R.id.country_name),(ImageButton) findViewById(R.id.array_left),
                (ImageButton) findViewById(R.id.array_right),(TextView) findViewById(R.id.char_view),
                (TextView)findViewById(R.id.num_of_tries),this);


    }

    public void leftButton(View view) {
        engine.letter("left");
    }

    public void rightButton(View view) {
        engine.letter("right");
    }

    public void checkButton(View view) {
        this.animationClass.startColorAnimation(((TextView)findViewById(R.id.char_view)),0x76ffff00,0x76ffffff,
                1500);
        boolean soundMode=engine.letter("check");
        if(soundMode) SoundsClass.startCoinSound(this);
        else SoundsClass.startWrongAnswerSound(this);
    }
    public void gameOver(final int score){
        SoundsClass.stopBgSound(this);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            {

            }
            @Override
            public void run() {
                Intent intent = new Intent(NewGame.this,Scores.class);
                SoundsClass.startGameOverSound(getApplicationContext());
                intent.putExtra("SCORE",score);
                startActivity(intent);
            }
        }, 2000);




    }
}
