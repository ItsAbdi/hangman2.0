import java.util.Random;
import java.util.Scanner;

public class hangman2_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] guesses = {"red", "blue", "green", "yellow", "black"};

        boolean weArePlaying = true;
        while (weArePlaying) {
            System.out.println("Welcome to the HangMan Game");
            char[] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray();
            int amountOfGuesses = randomWordToGuess.length;
            char[] playerGuess = new char[amountOfGuesses];

            for (int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_';
            }
            boolean wordIsGuessed = false;
            int tries = 0;

            while (!wordIsGuessed && tries != amountOfGuesses) {
                System.out.println("Current Guesses: ");
                printArray(playerGuess);
                System.out.printf("You have %d tries left.\n", amountOfGuesses - tries);
                System.out.println("enter a single character");
                char input = scanner.nextLine().charAt(0);
                tries++;

                if (input == '_') {
                    weArePlaying = false;
                    wordIsGuessed = true;

                } else {
                    for (int i = 0; i < randomWordToGuess.length; i++) {
                        if (randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }

                    if (isTheWordGuessed(playerGuess)) {
                        wordIsGuessed = true;
                        System.out.print("Congratulations you won!");
                    }
                }


            }
            if(!wordIsGuessed) System.out.println("You ran out of guesses :/");
            System.out.println("Do you want to play again? (yes/no)");
            String anotherGuess= scanner.nextLine();
            if (anotherGuess.equals("no"))weArePlaying=false;
        }
        System.out.println("Game Over");
    }

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array) {
        for (int i=0; i<array.length; i++){
            if (array[i]=='_')return false;
        }
return true;
    }



}



