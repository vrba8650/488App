package com.example.tapsquare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class score {

    private int score;

    score(){

        try
        {
            File inputFile = new File("score.txt");
            Scanner inputScanner = new Scanner(inputFile);

            String line = inputScanner.nextLine();
            this.score = Integer.parseInt(line);

        }

        catch (FileNotFoundException e){ }

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
