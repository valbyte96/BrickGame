package com.brickgame.valbyte96.brickgame;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by demouser on 1/17/17.
 */

public class BrickView extends View {

    BrickView(Context context){
        super(context);
       // init();

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