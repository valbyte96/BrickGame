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


}
