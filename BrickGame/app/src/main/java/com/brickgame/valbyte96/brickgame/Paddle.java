package com.brickgame.valbyte96.brickgame;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by demouser on 1/17/17.
 */

public class Paddle {
    public Paddle(int x, int y, Canvas canvas){
        Rect body = new Rect(x,y,x+100,y+50);
    }
}
