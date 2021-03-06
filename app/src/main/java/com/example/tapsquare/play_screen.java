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

        //Spawn the red Square
        redSquare();

        //set the score
        successorfail = (TextView)findViewById(R.id.txtSuccessorFail);
        score score = new score();
        successorfail.setText("Score: "+score.getScore());


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

    public void redSquare()
    {
        redSquare.setY(597.5f);
        //set random float for red square start
        Random rd = new Random();
        float positionRed = rd.nextFloat() * (screenWidth - 100) - 20;
        redSquare.setX(positionRed);
        redSquareLeftBound=redSquare.getLeft();
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
            int speed=score.getSpeed()*3/10;
            score.setSpeed(speed);
            successorfail.setText("Score: "+score.getScore());
            blueSquareX = blueSquareX +20;
            redSquare(); //respawn red square


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
        int speed =score.getSpeed();
        if(this.movingRight==true)
        {
            blueSquareX +=speed;
            blueSquare.setX(blueSquareX);
        }
        else if(this.movingLeft==true)
        {
            blueSquareX -=speed;
            blueSquare.setX(blueSquareX);
        }
        else
        {
            blueSquareX -=speed;
            blueSquare.setX(blueSquareX);
        }


        //Turns the square to the right or left
        if(blueSquare.getX() + blueSquare.getHeight() < 100){
            //blueSquareX = (float)Math.floor(Math.random() * (screenWidth - blueSquare.getWidth()));
            blueSquareX +=speed;
            this.movingLeft=false;
            this.movingRight=true;
            blueSquare.setX(blueSquareX);
        }
        else if((blueSquare.getX() + blueSquare.getHeight() > screenWidth)) {
            blueSquareX -= speed;
            this.movingRight = false;
            this.movingLeft = true;
            blueSquare.setX(blueSquareX);
        }
        blueSquareRightBound = blueSquare.getRight();
        blueSquareLeftBound = blueSquare.getLeft();

    }


}
