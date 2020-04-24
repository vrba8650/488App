package com.example.tapsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageButton settings;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //import the score
        try {
            Scanner input = new Scanner(new File("score.txt"));
            int score = input.nextInt();

            score classScore = new score();
            classScore.setScore(score);


        } catch (IOException e) {
            e.printStackTrace();
        }




        //play button
        button = (Button) findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPlayActivity();
            }
        });

        //settings button
        settings = (ImageButton) findViewById(R.id.btnSettings);
        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSettingsActivity();
            }
        });
    }

    //launch play
    public void openPlayActivity(){
        Intent intent = new Intent(this, play_screen.class);
        startActivity(intent);
    }

    //open settings
    public void openSettingsActivity(){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }
}
