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

}
