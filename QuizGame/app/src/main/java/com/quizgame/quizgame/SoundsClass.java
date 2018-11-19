package com.quizgame.quizgame;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundsClass {
    private static MediaPlayer bgSoundTrack;



    public static void startBgSound(Context context){
        bgSoundTrack = MediaPlayer.create(context,R.raw.song);
        bgSoundTrack.setLooping(true);
        bgSoundTrack.start();

    }
    public static void stopBgSound(Context context){
        bgSoundTrack.stop();

    }
    public static void startCoinSound(Context context){
        MediaPlayer coinSound = MediaPlayer.create(context,R.raw.coin);
        coinSound.start();
    }
    public static void startWrongAnswerSound(Context context){
        MediaPlayer wrongAnswer = MediaPlayer.create(context,R.raw.wrong_answer);
        wrongAnswer.start();
    }
    public static void startGameOverSound(Context context){
        MediaPlayer gameOver = MediaPlayer.create(context,R.raw.game_over);
        gameOver.start();
    }


}
