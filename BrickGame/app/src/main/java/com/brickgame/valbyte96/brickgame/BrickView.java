package com.brickgame.valbyte96.brickgame;

import android.annotation.TargetApi;
import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by demouser on 1/17/17.
 */

public class BrickView extends View {


    private Paint bgPaint;
    private Paddle mPaddle;
    protected Canvas canvas;

    public BrickView(Context context) {
        super(context);
        init();
    }

    public BrickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public BrickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BrickView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        bgPaint = new Paint();
        bgPaint.setColor(Color.rgb(0,0,0));
        mPaddle = new Paddle(200,650);

       setOnTouchListener(new OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent motionEvent) {
               if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
                   return true;
               }
               if (motionEvent.getActionMasked() == MotionEvent.ACTION_MOVE) {
                   Log.d("test", "x: " + motionEvent.getX() + ", y: " + motionEvent.getY());
                   mPaddle.move(motionEvent.getX());
                   return true;
               }
               return false;
           }
         }
       );
   }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawRect(mPaddle.getX(),mPaddle.getY(),mPaddle.getX()+100,mPaddle.getY()+50,bgPaint);
        postInvalidateOnAnimation();

    }
}