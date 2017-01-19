package com.brickgame.valbyte96.brickgame;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by demouser on 1/17/17.
 */

public class Ball {
    private float x;
    private float y;

    public Ball(float x, float y){
        this.x=x;
        this.y=y;
    }

    public void move(float dx, float dy){
        this.x+=dx;
        this.y+=dy;
    }
    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }
    public void draw(Canvas canvas, Paint paint){
        canvas.drawCircle(x,y,15,paint);

    }
    public void setLocation(float x, float y){
        this.x=x;
        this.y=y;
    }

}
