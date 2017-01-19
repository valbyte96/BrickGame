package com.brickgame.valbyte96.brickgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by demouser on 1/17/17.
 */

public class Paddle {
    //coordinates of first corner of rectangle
    private float x;
    private float y;

    //constructor
    public Paddle(float x, float y){
        this.x=x;
        this.y=y;
    }

    //moves the paddle
    public void move(float x){
        this.x=x;
    }

    //accessor methods
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }

    public void draw(Canvas canvas, Paint paint){
        canvas.drawRect(x,y,x+100,y+50,paint);

    }

    public boolean reflect(float bX, float bY){

        if (bX>=x&&bX<=x+100&& bY>=y&&bY<=y+50){
            return true;
        }
        return false;
    }


}
