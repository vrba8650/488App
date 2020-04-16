package com.example.tapsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class play_screen extends AppCompatActivity {
    private ImageButton settings;
    private Button fail;
    private int screenWidth;
    private int screenHeight;

    //image
    private ImageView blueSquare;

    //objects



    //position
    private float blueSquareX;


    //initalize
    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        //blue square
        blueSquare = (ImageView)findViewById(R.id.bluesquareobject);

        //get screen size
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //move out of screen
        blueSquare.setX(-80.0f);


        //start timer
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 100);




        //settings button
        settings = (ImageButton) findViewById(R.id.btnSettings);
        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSettingsActivity();
            }
        });

        //fail test
        //temporary button used to test fail trigger
        fail = (Button) findViewById(R.id.FailButton);
        fail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openFailActivity();
            }
        });

    }



    //launch settings
    public void openSettingsActivity(){
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    //trigger for failure
    //this will be changed later on to activate when play == false
    public void openFailActivity(){
        Intent intent = new Intent(this, fail.class);
        startActivity(intent);
    }


    //object movement
    public void changePos(){
        blueSquareX -=20;
        if(blueSquare.getX() + blueSquare.getHeight() < 0){
            blueSquareX = (float)Math.floor(Math.random() * (screenWidth - blueSquare.getWidth()));

        }
        blueSquare.setX(blueSquareX);
    }


}
