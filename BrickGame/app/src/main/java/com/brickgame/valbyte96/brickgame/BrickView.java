package com.brickgame.valbyte96.brickgame;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by demouser on 1/17/17.
 */

public class BrickView extends View {


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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BrickView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){
       setOnTouchListener(new OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               Log.d("test",Float.toString(event.getX()));
               return false;
           }
         }
       );
   }
}