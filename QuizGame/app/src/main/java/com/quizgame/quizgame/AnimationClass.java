
package com.quizgame.quizgame;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.RelativeLayout;

public class AnimationClass {

    private RelativeLayout myLayout;
    AnimationDrawable animationDrawable;

    public AnimationClass(RelativeLayout myLayout,int enterFadeDuration, int exitFadeDuration) {
        this.myLayout = myLayout;
        this.animationDrawable = (AnimationDrawable) myLayout.getBackground();
        this.animationDrawable.setEnterFadeDuration(enterFadeDuration);
        this.animationDrawable.setExitFadeDuration(exitFadeDuration);
        this.animationDrawable.start();
    }

    public void startColorAnimation(View view, int colorStart, int colorEnd,int duration){
                ValueAnimator colorAnim = ObjectAnimator.ofInt(view,"backgroundColor",
                colorStart,colorEnd);
        colorAnim.setDuration(duration);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(0);
        colorAnim.setRepeatMode(ValueAnimator.RESTART);
        colorAnim.start();
    }
}
