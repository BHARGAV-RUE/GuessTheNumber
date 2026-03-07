package com.guessgame;

public class HintProvider {
    public static String getTemperatureHint(int secretNumber, int guess) {
        int diff = Math.abs(secretNumber - guess);

        if (diff == 0) {
            return "Perfect";
        } else if (diff >= 80) {
            return "Freezing";
        } else if (diff >= 50) {
            return "Very Cold";
        } else if (diff >= 30) {
            return "Cold";
        } else if (diff >= 20) {
            return "Warm";
        } else {
            return "Hot";
        }
    }

    public static String getDirectionHint(int secretNumber, int guess) {

        if (guess < secretNumber) {
            return "Try Higher!";
        } else if (guess > secretNumber) {
            return "Try Lower!";
        } else {
            return "You got it right!";
        }
    }
}
