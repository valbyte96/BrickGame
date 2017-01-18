package com.brickgame.valbyte96.brickgame;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by demouser on 1/18/17.
 */

public class ScoreBoard {

    public float leftX;
    public float leftY;
    public int score;

    public ScoreBoard(float x, float y){
        this.leftX=x;
        this.leftY=y;
        this.score=0;
    }

    public void update(int score){
        this.score=score;
    }

    public void draw(Canvas canvas,Paint paint){
        //canvas.drawRect(leftX,leftY,leftX+200,leftY+100,paint);
        canvas.drawText("Score: "+Integer.toString(score),leftX,leftY,paint);


    }


}
