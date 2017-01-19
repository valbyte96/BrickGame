package com.brickgame.valbyte96.brickgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ((Button) findViewById(R.id.startButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

    }

    private void start(){
        EditText field = (EditText) findViewById(R.id.playername);
        String username = field.getText().toString();
        Intent newIntent = new Intent(this, MainActivity.class);
        newIntent.putExtra("username",username);
        startActivity(newIntent);


    }


}
