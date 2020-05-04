package com.example.tapsquare;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;



public class score {

    private static int score;
    private static int speed=20;

    public static int getScore()
    {
        return score;
    }

    public static void setScore(int score_) {

        score = score + score_;
    }

    public static int getSpeed()
    {
        return speed;
    }

    public static void setSpeed(int speed_) {

        speed = speed + speed_;
    }

    public int getHighscore()
    {
        int highscore=0;
       // File sdcard = Environment.getExternalStorageDirectory();
       // File file = new File(sdcard,"score.txt");
        String line ="";

        StringBuilder text = new StringBuilder();

        try {
            Scanner in = new Scanner(new File("score.txt"));

            while(in.hasNextLine()) {
                // Process the line
                line=in.nextLine();
            }


            highscore=Integer.parseInt(line);
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
            highscore=37707;
        }
        return highscore;
    }

}
