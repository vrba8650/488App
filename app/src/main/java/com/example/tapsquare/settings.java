package com.example.tapsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {
    private Button returnButton;
    private Button quit;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //return to current game button
        returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openReturnActivity();
            }
        });

        //return to home screen button
        quit = (Button) findViewById(R.id.quitButton);
        quit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });

        //reset current game
        reset = (Button) findViewById(R.id.resetScoreButton);
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ResetPlayScreen();
            }
        });
    }

    //return to currently loaded game
    public void openReturnActivity(){
        Intent intent = new Intent(this, play_screen.class);
        startActivity(intent);
    }

    //return to home screen
    public void openMainActivity(){
        score.setScore(-score.getScore()); //reset score
        score.setSpeed(-score.getSpeed() + 20); //reset speed
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void ResetPlayScreen(){
        score.setScore(-score.getScore()); //reset score
        score.setSpeed(-score.getSpeed() + 20); //reset speed
        Intent intent = new Intent(this, play_screen.class);
        startActivity(intent);

    }
}
