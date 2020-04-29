package com.example.tapsquare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class score {

    private int score;
    BufferedReader reader;
    BufferedWriter writer;

    score() throws IOException {

        //import the score

        reader = new BufferedReader(new FileReader("score.txt"));
        String input = reader.readLine();

        int scoreFile = Integer.parseInt(input);
        reader.close();

    }

    public int getScore()
    {
        return this.score;
    }

    public void setScore(int score_) throws IOException {

        this.score= this.score + score_;
        writer = new BufferedWriter(new FileWriter("score.txt"));
        writer .write(this.score);

        writer.close();

    }

}
