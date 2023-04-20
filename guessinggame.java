// Sergio Virgen
// Guessing Game
// In this program, the user is able to play a game
// of guessing random numbers and see their overall
// statistics in the end.

import java.util.*;

public class GuessingGame {
   public static final int MAX_VALUE = 100;
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random(42);
      
      haiku();
      int numTries = singleGame(console, rand);
      int totalGames = 1;
      int totalGuesses = numTries;
      int bestGame = numTries;
      boolean yesAgain = playAgainQuestion(console);
      while (yesAgain) {
         System.out.println();
         numTries = singleGame(console, rand);
         totalGames++;
         totalGuesses += numTries;
         if (numTries < bestGame) {
            bestGame = numTries;
         }
         yesAgain = playAgainQuestion(console);
      }
      System.out.println();
      gameStats(totalGames, totalGuesses, bestGame);
   }
   
   // This method allows me to print out
   // the haiku I created in main.
   public static void haiku() {
      System.out.println("Life and games can be random");
      System.out.println("the choices we make should guide us");
      System.out.println("try this game and put it to the test");
      System.out.println();
   }
   
   // This method allows the user to play a single game
   // It takes user input through Scanner console
   // and generate the random number using Random rand.
   // It also returns the numTries to main as an int.
   public static int singleGame(Scanner console, Random rand) {
      System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
      int randomNumber = rand.nextInt(MAX_VALUE) + 1;
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      int numTries = 1;
      while (guess != randomNumber) {
         if (guess < randomNumber) {
            System.out.println("It's higher.");
         }else {
            System.out.println("It's lower.");
         }
         System.out.print("Your guess? ");
         guess = console.nextInt();
         numTries++;
      }
      if (numTries == 1) {
         System.out.println("You got it right in " + numTries + " guess!");
      }else {
         System.out.println("You got it right in " + numTries + " guesses!");
      }
      return numTries;
   }
   
   // This method is in charge of asking the user wether
   // or not he wants to play again and returns yesAgain
   // as a boolean to main
   public static boolean playAgainQuestion(Scanner console) {
      System.out.print("Do you want to play again? ");
      String playAgain = console.next();
      String firstLetter = playAgain.charAt(0) + "";
      boolean yesAgain = firstLetter.equalsIgnoreCase("y");
      return yesAgain;
   }
   
   // This method helps to print out the overall game statistics
   // after the user is done playing.
   // Parameters:
   //    totalGames - The total number of games the user played
   //    totalGuesses - the total number of guesses the user made
   //    bestGame - The game with the least amount of guesses by the user
   public static void gameStats(int totalGames, int totalGuesses, int bestGame) {
      System.out.println("Overall results:");
      System.out.println("Total games   = " + totalGames);
      System.out.println("Total guesses = " + totalGuesses);
      System.out.println("Guesses/game  = " + round1(1.0 * totalGuesses/totalGames));
      System.out.println("Best game     = " + bestGame);
   }
   
   // Rounds the given value to one decimal and returns the result
   public static double round1(double num) {
      return Math.round(num * 10.0) / 10.0;
   }
}