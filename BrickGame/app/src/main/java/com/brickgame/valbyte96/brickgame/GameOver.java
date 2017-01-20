package com.brickgame.valbyte96.brickgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    String username;
    int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        ((Button) findViewById(R.id.restartButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

        // get username
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        totalScore = intent.getIntExtra("totalScore",0);

        TextView textView1 = (TextView) findViewById(R.id.userName);
        if(username.length() == 0){
            textView1.setText("Your score is : " + totalScore + "");
        } else {
            textView1.setText(username + " your score is : " + totalScore + "");
        }
    }

    private void start(){
        Intent newIntent = new Intent(this, MainActivity.class);
        startActivity(newIntent);
    }



}
