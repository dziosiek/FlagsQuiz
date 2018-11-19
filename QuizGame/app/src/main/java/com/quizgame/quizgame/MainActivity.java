package com.quizgame.quizgame;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout myLayout;
    AnimationClass animationClass;
    Button button;
//    MediaPlayer bgSoundTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.animationClass = new AnimationClass((RelativeLayout) findViewById(R.id.myLayout),500,4500);
//        bgSoundTrack = MediaPlayer.create(getApplicationContext(),R.raw.song);
        SoundsClass.startBgSound(getApplicationContext());


        button = (Button) findViewById(R.id.new_game);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                bgSoundTrack.start();
                MainActivity.this.animationClass.startColorAnimation(button,0x76ffff00,0x76ffffff,
                        1500);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,NewGame.class);
                        startActivity(intent);
                    }
                }, 1500);


            }
        });


    }

}
