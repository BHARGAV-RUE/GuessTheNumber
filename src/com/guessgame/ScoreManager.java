package com.guessgame;

import java.io.*;
public class ScoreManager {
    private int attempts;
    private int bestScore;

    private final String file_name = "HighScore.txt";

    public ScoreManager(){
        attempts = 0;
        bestScore = loadHighScore();
    }

    public void resetAttempts(){
        attempts = 0;
    }
    
    public void incrementAttempts(){
        attempts++;
    }

    public int getAttempts(){
        return attempts;
    }

    public String calculateRank(){
        if(attempts <= 3){
            return "Mind Reader";
        }
        else if(attempts <= 6){
            return "Sharp Shooter";
        }
        else if(attempts <= 10){
            return "Skilled Guesser";
        }
        else {
            return "Beginner";
        }
    }

    private int loadHighScore(){

        try {
            File file = new File(file_name);

            if(!file.exists()){
                return Integer.MAX_VALUE;
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int score = Integer.parseInt(reader.readLine());
            reader.close();

            return score;
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }

    private void saveHighScore(int score){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file_name));
            writer.write(String.valueOf(score));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving high score.");
        }
    }

    public void updateHighScore(){

        if(attempts < bestScore){
            System.out.println("New High Score.");
            bestScore = attempts;
            saveHighScore(bestScore);
        }
        else{
            System.out.println("Best Score: " + bestScore + " | Attempts: " + attempts);
        }
    }
}
