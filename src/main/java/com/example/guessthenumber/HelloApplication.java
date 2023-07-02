package com.example.guessthenumber;
import java.util.Random;
import java.util.Scanner;

public class HelloApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerRange = 1;
        int upperRange = 100;
        int secretNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;

        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number!");

        while (playAgain) {
            System.out.println("I'm thinking of a number between " + lowerRange + " and " + upperRange + ".");
            int guess;

            while (true) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();

                if (guess < lowerRange || guess > upperRange) {
                    System.out.println("Invalid guess! Please enter a number between " + lowerRange + " and " + upperRange + ".");
                } else {
                    break;
                }
            }

            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempt(s).");
                score++;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();

            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over. Your final score is " + score + ".");

        scanner.close();
    }
}
