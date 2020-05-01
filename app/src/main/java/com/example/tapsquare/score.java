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

    private static int score;

    public static int getScore()
    {
        return score;
    }

    public void setScore(int score_) {

        score = score + score_;

    }

}
