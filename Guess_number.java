
import java.util.*;

public class Guess_number {

    public static int getRandom() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    public static String hintProvider(int number, int guess) {
        int diff = Math.abs(number - guess);

        if (diff == 0) {
            return "right";
        } else if (diff >= 80) {
            return "❄ Freezing!";
        } else if (diff >= 50) {
            return "🧊 Very Cold!";
        } else if (diff >= 30) {
            return "🌬 Cold!";
        } else if (diff >= 20) {
            return "🌡 Warm!";
        } else {
            return "🔥 Hot!";
        }
    }

    public static void runnGuess() {
        int secretNumber = getRandom();
        int userGuess;
        String hint;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number between 1 to 100: ");
            System.out.println("The hotter you go, the closer you get");
            String input = sc.nextLine();
            try {
                userGuess = Integer.parseInt(input.trim());

                if (userGuess == 6708) {
                    System.out.println("Cheat Activated!");
                    System.out.println(secretNumber);
                    continue;
                }

                if(userGuess < 1 || userGuess > 100){
                    System.out.println("Enter number within range.");
                    continue;
                }
                
                hint = hintProvider(secretNumber, userGuess);

                if (hint.equals("right")) {
                    System.out.println("⚡ That’s how it’s done!");
                    break;
                } else {
                    System.out.println(hint);
                }
            }catch(InputMismatchException e){
                System.out.println("Entered input is invalid, please enter integer only!");
                sc.next();
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        runnGuess();
    }
}
