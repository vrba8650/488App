package com.example.tapsquare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class score {

    private int score;
    BufferedReader reader;
    BufferedWriter writer;

    score(){

        try {
            //import the score
            BufferedReader br = new BufferedReader(new FileReader("character.txt"));
            String line = br.readLine();

            String input = reader.readLine();

            int scoreFile = Integer.parseInt(input);
            this.score = scoreFile;
            reader.close();
        }
        catch(Exception e){}

    }

    public int getScore()
    {
        return this.score;
    }

    public void setScore(int score_) {

        try {
            this.score = this.score + score_;
            PrintWriter outputFile = new PrintWriter("score.txt");
            outputFile.println(this.score);
            outputFile.close();
        }
        catch(Exception e){}

    }

}
