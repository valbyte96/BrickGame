package com.brickgame.valbyte96.brickgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by demouser on 1/18/17.
 */

public class Brick {
    private float x;
    private float y;
    private int color;

    public Brick(float x, float y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public int getColor(){
        return this.color;
    }

    public void draw(Canvas canvas, Paint paint){
        canvas.drawRect(x,y,x+30,y+20,paint);
    }
}
