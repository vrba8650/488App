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
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class play_screen extends AppCompatActivity {
    private ImageButton settings;
    private Button fail;
    private int screenWidth;
    private int screenHeight;
    private boolean movingRight=false;
    private boolean movingLeft=false;

    private float blueSquareLeftBound;
    private float blueSquareRightBound;

    private float redSquareLeftBound;



    //image
    private ImageView blueSquare;
    private ImageView redSquare;

    //objects
    private TextView successorfail;


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
        redSquare = (ImageView)findViewById(R.id.redsquareobject);

        //get screen size
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //move out of screen
        blueSquare.setX(-80.0f);
        blueSquare.setY(600.0f);

        redSquare.setY(597.5f);

        //set random float for red square start
        Random rd = new Random();
        float positionRed = rd.nextFloat() * (screenWidth - 120) + 60;
        redSquare.setX(positionRed);
        redSquareLeftBound=redSquare.getLeft();

        //set the score
        successorfail = (TextView)findViewById(R.id.txtSuccessorFail);
        score score = new score();
        successorfail.setText("Score: test2"+score.getScore());

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

        successorfail = (TextView)findViewById(R.id.txtSuccessorFail);

        //red square hitbox
        if(blueSquare.getX() > redSquare.getX() -100 && blueSquare.getX() < redSquare.getX() + 100)
        {
            score score = new score();
            score.setScore(10);
            successorfail.setText("Score: "+score.getScore());
            blueSquareX = blueSquareX +20;
            //incriment score here
            //respawn red square here
            //increase blue square speed (difficulty) here
        }

        else
        {
            Intent intent = new Intent(this, fail.class);
            startActivity(intent);
        }
    }


    //object movement
    public void changePos(){
        //Set Movements
        if(this.movingRight==true)
        {
            blueSquareX +=20;
            blueSquare.setX(blueSquareX);
        }
        else if(this.movingLeft==true)
        {
            blueSquareX -=20;
            blueSquare.setX(blueSquareX);
        }
        else
        {
            blueSquareX -=20;
            blueSquare.setX(blueSquareX);
        }


        //Turns the square to the right or left
        if(blueSquare.getX() + blueSquare.getHeight() < 60){
            //blueSquareX = (float)Math.floor(Math.random() * (screenWidth - blueSquare.getWidth()));
            blueSquareX +=20;
            this.movingLeft=false;
            this.movingRight=true;
            blueSquare.setX(blueSquareX);
        }
        else if((blueSquare.getX() + blueSquare.getHeight() > screenWidth)) {
            blueSquareX -= 20;
            this.movingRight = false;
            this.movingLeft = true;
            blueSquare.setX(blueSquareX);
        }
        blueSquareRightBound = blueSquare.getRight();
        blueSquareLeftBound = blueSquare.getLeft();

    }


}
