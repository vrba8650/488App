package com.example.tapsquare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class score {

    private int score;

    score() {
        BufferedReader reader;
        //import the score
            try

        {
            reader = new BufferedReader(new FileReader("score.txt"));
            String input = reader.readLine();

            int scoreFile = Integer.parseInt(input);
            this.score=500;

        } catch(
        IOException e)

        {
            e.printStackTrace();
        }

}

    public int getScore()
    {
        return this.score;
    }

    public void setScore(int score_)
    {
        this.score= this.score + score_;
    }

}
