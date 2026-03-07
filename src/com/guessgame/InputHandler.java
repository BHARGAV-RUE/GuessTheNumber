package com.guessgame;

import java.util.*;

public class InputHandler {

    private Scanner sc;

    public InputHandler() {
        sc = new Scanner(System.in);
    }
    public int getIntegerInput() {
        while (true) {
            try {
                int num = sc.nextInt();
                sc.nextLine();
                return num;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input: Enter valid Integer.");
                sc.next();
            
            }
        
        }
    }

    public String getStringInput(){
        return sc.nextLine();
    }

    public boolean isWithinRange(int value, int min, int max){
        return value >= min && value <= max;
    }

    public void closeScanner(){
        sc.close();
    }
}
