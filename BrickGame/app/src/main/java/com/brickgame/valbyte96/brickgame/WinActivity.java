package com.brickgame.valbyte96.brickgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        TextView textView1 = (TextView) findViewById(R.id.userName);
        if(username != null){
            textView1.setText(username);
        }

        ((Button) findViewById(R.id.restartButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });
    }

    private void restart(){
        Intent newIntent = new Intent(this, MainActivity.class);
        startActivity(newIntent);
    }
}
