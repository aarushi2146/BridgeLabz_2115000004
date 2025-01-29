import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static int generateGuess(int lowerBound, int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
    public static String getFeedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 'high', 'low', or 'correct': ");
        return scanner.nextLine().toLowerCase();
    }
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        int guess;
        String feedback;
        System.out.println("Think of a number between 1 and 100, and I will try to guess it.");
        System.out.println("After each guess, tell me if it is 'high', 'low', or 'correct'.");
        while (true) {
            guess = generateGuess(lowerBound, upperBound);
            System.out.println("My guess is: " + guess);
            feedback = getFeedback();            
            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number!");
                break;
            } else if (feedback.equals("high")) {
                upperBound = guess - 1;
            } else if (feedback.equals("low")) {
                lowerBound = guess + 1;
            } else {
                System.out.println("Invalid feedback. Please enter 'high', 'low', or 'correct'.");
            }
            if (lowerBound > upperBound) {
                System.out.println("Oops! It seems there is a mistake in the feedback. Try again.");
                break;
            }
        }
    }
    public static void main(String[] args) {
        startGame();
    }
}

