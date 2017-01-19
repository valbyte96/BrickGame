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

import java.util.Random;

/**
 * Created by demouser on 1/17/17.
 */

public class BrickView extends View {


    private Paint mPaint;
    private Paddle mPaddle;
    private Ball mBall;
    private ScoreBoard mBoard;
    private float dx;
    private float dy;
    private int score =0;
    private int nRows=5;
    private int nCols=6;
    private int level =1;
    private Brick[][] brickArray=new Brick[nRows][nCols];
    private int[] colorArray={Color.rgb(200,0,0),Color.rgb(0,200,0),Color.rgb(0,0,200),Color.rgb(255,222,0)};
    private Random ran = new Random();
    private int undrawn=0;





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

        mPaint = new Paint();
        mPaddle = new Paddle(200,650);
        mBall = new Ball(270,380);
        mBoard=new ScoreBoard(300,30);



        for(int i =0; i<nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                Brick brick = new Brick(j * 90 + 15, i * 60+50, ran.nextInt(4));
                brickArray[i][j] = brick;
            }
        }


        dx=ran.nextInt(2)+1;
        dy=ran.nextInt(4)+2;


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
        //draw circle and rectangle
        mPaint.setColor(colorArray[2]);
        mPaddle.draw(canvas,mPaint);
        mPaint.setColor(colorArray[3]);
        mBall.draw(canvas, mPaint);
        mPaint.setColor(Color.rgb(0,0,0));
        mBoard.draw(canvas,mPaint,score);

        for (int i=0;i<nRows;i++){
            for(int j=0;j<nCols; j++) {
                mPaint.setColor(colorArray[brickArray[i][j].getColor()]);
                brickArray[i][j].draw(canvas, mPaint);
            }
        }


        mBall.move(dx,dy);//move ball

        //conditions for reflecting
        //checks to see if it has hit the paddle
        if (mPaddle.reflect(mBall.getX(),mBall.getY())){
            dy=-dy;
            score+=100;
        }
        //too far left or right
        if (mBall.getX()<=0||mBall.getX()>=getWidth()){
            dx=-dx;

        }
        //too far up or down
        if (mBall.getY()<=0||mBall.getY()>=getHeight()){
            dy=-dy;
        }
        for (int i=0;i<nRows;i++){
            for(int j=0;j<nCols; j++) {
                if(brickArray[i][j].isTouched(mBall.getX(),mBall.getY())){
                    score+=200;
                    undrawn+=1;
                }
            }
        }

        postInvalidateOnAnimation();

    }
}