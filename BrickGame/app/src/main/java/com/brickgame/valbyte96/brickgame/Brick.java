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
    private boolean drawn;

    public Brick(float x, float y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.drawn=true;
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

    public boolean isTouched(float bX, float bY){
        if (this.drawn==false){
            return false;
        }
        if (bX>=x&&bX<=x+60&& bY>=y&&bY<=y+40){
            this.drawn=false;
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas, Paint paint){
        if(drawn) {
            canvas.drawRect(x, y, x + 60, y + 40, paint);
        }
    }
    public void resetDraw(){
        this.drawn=true;
    }
}
