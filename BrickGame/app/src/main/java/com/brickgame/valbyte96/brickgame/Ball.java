package com.brickgame.valbyte96.brickgame;

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

}
