package com.guessgame;

import java.util.Random;
public class GuessGame {
    private int secretNumber;
    private int maxRange;
    private boolean isRunning;

    private InputHandler inputHandler;
    private ScoreManager scoreManager;

    public GuessGame(){
        inputHandler = new InputHandler();
        scoreManager = new ScoreManager();
    }

    public void start(){
        System.out.println("Welcome to Guess the Number!");
        System.out.println("----------------------------");

        do { 
            selectDifficulty();
            generateSecretNumber();
            scoreManager.resetAttempts();
            playRound();
            isRunning = askReplay();
        } while (isRunning);

        System.out.println("Thanks for enjoying!");
    }

    public void selectDifficulty(){
        System.out.println("\nSelect the Difficulty:");
        System.out.println("1. Easy (1-50)");
        System.out.println("2. Medium (1-100)");
        System.out.println("3. Hard (1-500)");
        System.out.println("4. God (1-1000)");

        int choice = inputHandler.getIntegerInput();

        switch (choice) {
            case 1:
                maxRange =50;
                break;
            case 2:
                maxRange = 100;
                break;
            case 3:
                maxRange = 500;
                break;
            case 4:
                maxRange = 1000;
                break;
            default:
                System.out.println("Invalid choice. defaulting to medium difficulty.");
                maxRange = 100;
        }
    }

    private void generateSecretNumber(){
        Random rand = new Random();
        secretNumber = rand.nextInt(maxRange)+ 1;
    }

    private void playRound(){
        System.out.println("\nGuess the number between 1 and " + maxRange);

        while(true){
            System.out.println("Your Guess: ");
            int guess = inputHandler.getIntegerInput();

            if(guess == 9999){
                System.out.println("Cheat Activated! Secret number: " + secretNumber);
                continue;
            }

            if(!inputHandler.isWithinRange(guess,1,maxRange)){
                System.out.println("Enter number between 1 - " + maxRange);
                continue;
            }

            if(guess == secretNumber){
                handleWin();
                break;
            }

            scoreManager.incrementAttempts();

            String tempHint = HintProvider.getTemperatureHint(secretNumber, guess);
            System.out.println(tempHint);

            String directionHint = HintProvider.getDirectionHint(secretNumber,guess);
            System.out.println(directionHint);
        }
    }

    private void handleWin(){
        int attempts = scoreManager.getAttempts();

        System.out.println("Correct! You guessed it!");
        System.out.println("Attempts taken "+ attempts);

        System.out.println("Rank: " + scoreManager.calculateRank());
        scoreManager.updateHighScore();
    }

    private boolean askReplay() {

        System.out.print("\nDo you want to play again? (y/n): ");
        String choice = inputHandler.getStringInput();

        return choice.equalsIgnoreCase("y");
    }
}
