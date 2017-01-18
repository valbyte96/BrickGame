package com.brickgame.valbyte96.brickgame;

import android.graphics.Color;

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
}
