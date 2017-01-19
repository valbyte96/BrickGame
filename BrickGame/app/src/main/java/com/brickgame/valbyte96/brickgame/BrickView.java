package com.brickgame.valbyte96.brickgame;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by demouser on 1/17/17.
 */

public class BrickView extends View {
    private String username;
    private Paint mPaint;
    private Paddle mPaddle;
    private Ball mBall;
    private ScoreBoard mBoard;
    private float dx;
    private float dy;
    private int score = 0;
    private int nRows = 5;
    private int nCols = 6;
    private int level = 1;
    private Brick[][] brickArray = new Brick[nRows][nCols];
    private Brick[] levelTwoArray = new Brick[42];
    private Brick[] levelThreeArray = new Brick[1];//GOHERE
    private int[] colorArray={Color.rgb(200,0,0),Color.rgb(0,200,0),Color.rgb(0,0,200),Color.rgb(255,222,0)};
    private Random ran = new Random();
    private int undrawn=0;
    private int lives=1;
    private Vibrator vib;



    //<---CONSTRUCTORS-->
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

    //<---INITIALIZER--->
    private void init(){

        //initialize objects
        mPaint = new Paint();
        mPaddle = new Paddle(200,650,getContext());
        mBall = new Ball(250,630);
        mBoard=new ScoreBoard(75,30);
        vib=(Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);


        //SET UP LEVEL 1
        levelOneSetUp();

        //SET UP LEVEL 2
        levelTwoSetUp();

        levelThreeSetUp();

        //initialize speeds
        dx=randomX();
        dy=randomY();

        //SET UP TOUCH LISTENER
        setOnTouchListener(new OnTouchListener() {
            @Override
           public boolean onTouch(View v, MotionEvent motionEvent) {
               if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
                   return true;
               }
               if (motionEvent.getActionMasked() == MotionEvent.ACTION_MOVE) {
                   mPaddle.move(motionEvent.getX());
                   return true;
               }
               return false;
           }
       }
        );
    }

    //<--LEVEL SET UP-->
    //sets up level 1
    public void levelOneSetUp(){
        for(int i =0; i<nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                Brick brick = new Brick(j * 90 + 15, i * 60+50, ran.nextInt(4));
                brickArray[i][j] = brick;
            }
        }
    }

    //sets up level 2
    public void levelTwoSetUp(){
        Brick brick0 = new Brick(2 * 72 + 52, 50, 0);
        levelTwoArray[0]=brick0;
        Brick brick1 = new Brick(3 * 72 + 52, 50, 0);
        levelTwoArray[1]=brick1;

        for(int i=0;i<4;i++){
            Brick brick = new Brick(i * 72 + 122, 100, 0);
            levelTwoArray[i+2]=brick;
        }
        for(int i=0;i<4;i++){
            Brick brick = new Brick(i * 72 + 122, 150, 0);
            levelTwoArray[i+6]=brick;
        }
        for(int i=0;i<4;i++){
            Brick brick = new Brick(i * 72 + 122, 200, 0);
            levelTwoArray[i+10]=brick;
        }
        for(int i=0;i<4;i++){
            Brick brick = new Brick(i * 72 + 122, 250, 0);
            levelTwoArray[i+14]=brick;
        }
        for(int i=0;i<4;i++){
            Brick brick = new Brick(i * 72 + 122, 300, 0);
            levelTwoArray[i+18]=brick;
        }
        for(int i=0;i<4;i++){
            Brick brick = new Brick(i * 72 + 122, 350, 0);
            levelTwoArray[i+22]=brick;
        }
        for(int i=0;i<4;i++){
            Brick brick = new Brick(i * 72 + 122, 400, 0);
            levelTwoArray[i+26]=brick;
        }

        //legs
        Brick brick2 = new Brick(2 * 100 - 22, 450, 0);
        levelTwoArray[30]=brick2;
        Brick brick3 = new Brick(3 * 100 - 22, 450, 0);
        levelTwoArray[31]=brick3;

        Brick brick4 = new Brick(2 * 100 - 22, 500, 0);
        levelTwoArray[32]=brick4;
        Brick brick5 = new Brick(3 * 100 - 22, 500, 0);
        levelTwoArray[33]=brick5;
        //arms
        for(int i=0;i<4;i++){
            Brick brick = new Brick(40, 175+50*i, 0);
            levelTwoArray[i+34]=brick;
        }
        for(int i=0;i<4;i++){
            Brick brick = new Brick(53+3*122, 175+50*i, 0);
            levelTwoArray[i+38]=brick;
        }
    }
    //level three setup
    public void levelThreeSetUp(){//goh
        Brick brick0 = new Brick(3 * 72 + 52, 50, 0);
        levelThreeArray[0]=brick0;

    }

    //<--PLAYS GAME-->
    @Override
    protected void onDraw(Canvas canvas) { //GOHERE
        //increments levels and resets ball
        if (undrawn == 2 && level == 1 || undrawn == 2 && level == 2) {
            dx += 1;
            dy += 1;
            undrawn = 0;
            level += 1;
            mBall.setLocation(mPaddle.getX() + 50, mPaddle.getY());

        }
        if(level==3){ //check to see if user has won
            gameWon();//@TODO change this to user wins
        }
        else if(lives<0){//check to see if user has lost
            gameOver();
        }
        else {//play the game
            //draw paddle, ball, and board
            mPaint.setColor(colorArray[2]);
            mPaddle.draw(canvas, mPaint);
            mPaint.setColor(colorArray[3]);
            mBall.draw(canvas, mPaint);
            mPaint.setColor(Color.rgb(0, 0, 0));
            mBoard.draw(canvas, mPaint, score, level, lives);


            //DRAW THE BOARD
            if (level == 1) {
                //draw the object
                for (int i = 0; i < nRows; i++) {
                    for (int j = 0; j < nCols; j++) {
                        mPaint.setColor(colorArray[brickArray[i][j].getColor()]);
                        brickArray[i][j].draw(canvas, mPaint);
                    }
                }

            } else if (level == 2) {
                for (int i = 0; i < levelTwoArray.length; i++) {
                    mPaint.setColor(Color.rgb(191, 239, 0));
                    levelTwoArray[i].draw(canvas, mPaint);
                }
            }
            else if(level==3){
                for (int i = 0; i < levelThreeArray.length; i++) {
                    mPaint.setColor(Color.rgb(191, 239, 0));
                    levelTwoArray[i].draw(canvas, mPaint);
                }

            }


            mBall.move(dx, dy);//move ball

            //REFLECTING CONDITIONS
            //checks to see if it has hit the paddle
            if (mPaddle.reflect(mBall.getX(), mBall.getY())) {
                dy = -randomY();
                score += 100;
            }
            //too far left or right
            if (mBall.getX() <= 0 || mBall.getX() >= getWidth()) {
                dx = -dx;

            }
            //too far up or down
            if (mBall.getY() <= 0) {
                dy = -dy;
            }
            if (mBall.getY() >= getHeight()) {
                mBall.setLocation(mPaddle.getX() + 50, mPaddle.getY());
                lives = lives - 1;
                dy = -dy;
                vib.vibrate(200);
            }

            //BRICK CONDITIONS
            if (level == 1) {
                for (int i = 0; i < nRows; i++) {
                    for (int j = 0; j < nCols; j++) {
                        if (brickArray[i][j].isTouched(mBall.getX(), mBall.getY())) {
                            score += 200;
                            undrawn += 1;
                            if(dx<0){
                                dx = randomX();
                            }
                            else if(dx>0){
                                dx = -randomX();
                            }
                            if (dy<0){
                                dy = randomX();
                            }
                            else if(dy>0){
                                dy = -randomY();
                            }


                        }
                    }
                }
            } else if (level == 2) {
                for (int i = 0; i < levelTwoArray.length; i++) {
                    if (levelTwoArray[i].isTouched(mBall.getX(), mBall.getY())) {
                        score += 200;
                        undrawn += 1;
                        if(dx<0){
                            dx = randomX();
                        }
                        else if(dx>0){
                            dx = -randomX();
                        }
                        if (dy<0){
                            dy = randomX();
                        }
                        else if(dy>0){
                            dy = -randomY();
                        }

                    }
                }
            }
            postInvalidateOnAnimation();
        }
    }

    private void gameOver(){
        Intent newIntent = new Intent(this.getContext(), GameOver.class);
        // to pass username on to gameOver layout
        newIntent.putExtra("username",username);
        newIntent.putExtra("totalScore", score);
        this.getContext().startActivity(newIntent);
    }

    private void gameWon(){
        Intent newIntent = new Intent(this.getContext(), WinActivity.class);
        this.getContext().startActivity(newIntent);
    }

    public void setUserName(String name){
        username = name;
    }

    public int randomX(){
        Random ran = new Random();
        return ran.nextInt(2)+2+level;


    }
    public int randomY(){
        Random ran = new Random();
        return ran.nextInt(3)+4+level;
    }



}