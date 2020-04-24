package com.example.tapsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class fail extends AppCompatActivity {
    private ImageButton settings;
    private Button quit;
    private Button again;
    private TextView txtYourScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);

        txtYourScore= (TextView)findViewById(R.id.txtYourScore);

        score score = new score();
        txtYourScore.setText("Your score:"+score.getScore());

        //setting button
        settings = (ImageButton) findViewById(R.id.btnSettings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity();
            }
        });

        //quit button
        quit = (Button) findViewById(R.id.quitButton);
        quit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });

        //Try Again button
        again = (Button) findViewById(R.id.TryAgainButton);
        again.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPlayActivity();
            }
        });

    }

    //restart game with score = 0
    //reinitalize play state here (play = true)
    public void openPlayActivity(){
        Intent intent = new Intent(this, play_screen.class);
        startActivity(intent);

    }

    //launch home screen
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    //launch settings
    public void openSettingsActivity() {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }
}
