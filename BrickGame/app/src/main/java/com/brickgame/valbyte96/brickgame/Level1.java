package com.brickgame.valbyte96.brickgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

public class Level1 extends View {
    // array of bricks that make up the level view
    private Brick[] bricksArr = new Brick[5];
    Paint bgPaint;

    public Level1(Context context) {
        super(context);
        init();
    }

    public Level1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Level1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Level1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        bgPaint = new Paint();
        bgPaint.setColor(Color.rgb(0,0,0));
        for(int i = 0; i <250;i+=50 ){
            bricksArr[i/50] = new Brick((20+i),(20+i), Color.BLUE);
        }
    }

    protected void onDraw(Canvas canvas){


        for(Brick brick: bricksArr){
            bgPaint.setColor(brick.getColor());
            canvas.drawRect(brick.getX(),brick.getY(),brick.getX()+50,brick.getY()+50,bgPaint);
        }

        postInvalidateOnAnimation();
    }
}
