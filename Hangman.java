import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {


    private static String theWord;
    private static char theCharacter;
    private static final ArrayList<Character> charChecker = new ArrayList<>();
    private static final ArrayList<Character> charFiller = new ArrayList<>();


    public static void Intro() {
        
        System.out.println("[[WELCOME TO HANGMAN]]");
    
    }

    public static void createWord() {

        try (Scanner create = new Scanner(System.in)) {

            //ArrayList<Character> word = new ArrayList<Character>()

            System.out.println("\nPlayer 1, you're up!");
            System.out.print("Please enter a word you would like your opponent to guess: ");
            theWord = create.nextLine();

            for (int i = 0; i < 2000; i++) {
                System.out.println(" ");
            }
            System.out.println("");

            // char[] word = theWord.toCharArray();

            for (int j = 0; j < theWord.length(); j++) {
                charChecker.add(theWord.charAt(j));
            }
            // System.out.println(charChecker);

            guessWord(theWord, charChecker);
        }
    }


    public static void createPhrase() {
        // empty for now
    }


    public static void guessWord(String word, ArrayList<Character> character) {

        char[] charArray = new char[character.size()];
        for (int z = 0; z < character.size(); z++) {
            charArray[z] = character.get(z);
        }

        char arrayFiller = '_';
        for (int l = 0; l < theWord.length(); l++) {
            charFiller.add(l, arrayFiller);
        }
        // System.out.println(charFiller);


        try (Scanner guess = new Scanner(System.in)) {
            System.out.println("Player 2, you're up! ");

            System.out.print("The word has " + word.length() + " letters: ");
            for (int m = 0; m < word.length(); m++) {
                System.out.print("_ ");
            }

            System.out.println("\n");
            System.out.println("\nYou have 6 lives.");

            char guessLetter = '~';
            char[] letterList = word.toCharArray();
            char[] guessedLetters = new char [6];
            for (int k = 0; k < guessedLetters.length; k++) {
                guessedLetters[k] = guessLetter;
            }


            boolean gameWinner = false;
            int lives = 6;
            int index = 0;
            while (lives > 0) {

                System.out.print("What character would you like to guess? ");
                theCharacter = guess.next().charAt(0);

                
                // WHILE LOOP ATTEMPT [PART 1]
                /*
                 boolean theKey = true;
                while (theKey) {
                    for (int j = 0; j < 6; j++) {
                        if (theCharacter != guessedLetters[j]) {

                        } else if (theCharacter == guessedLetters[j]) {
                            System.out.println("Try Again!");
                            theCharacter = guess.next().charAt(0);
                            break;
                        } else if (j == 6) {
                            theKey = false;
                            break;
                        }
                    }
                }
                 */
                
                    
                // WHILE LOOP ATTEMPT [PART 2]
                /* 
                System.out.println(letterList);
                System.out.println(guessedLetters);
                int counter9 = 0;
                boolean key = true;
                while (key) {
                    System.out.print("What character would you like to guess? ");
                    theCharacter = guess.next().charAt(0);
                    for (int d = 0; d < word.length(); d++) {
                        if (theCharacter == allChar[d]) {
                            System.out.print("Guess again");
                            theCharacter = guess.next().charAt(0);
                            allChar[d] = theCharacter;
                            key = false;
                        }
                    }
                    allChar[counter9] = theCharacter;
                }
                counter9++;
                */


                // [1] SETTING THE CHARACTER
                int runThrough = 0;
                while (runThrough < word.length()) {
                    if (theCharacter == letterList[runThrough]) {
                        charFiller.set(runThrough, theCharacter);
                    }
                    runThrough++;
                }

                
                // [1] STAYS FIXED HERE
                char[] charArray2 = new char[character.size()];
                for (int x = 0; x < character.size(); x++) {
                    charArray2[x] = charFiller.get(x);
                }

                
                // [2] CALCULATING LIVES
                int antiLivesCounter = 0;
                for (char c : charArray) {
                    if (theCharacter == c) {
                        antiLivesCounter++;
                    } 
                }
                if (antiLivesCounter == 0) {
                    lives--;
                    guessedLetters[index] = theCharacter;
                    index++;
                }       

                
                // [3] [DISPLAYING CONTENT]
                System.out.println("\nYour guessed letters: " + Arrays.toString(guessedLetters));
                System.out.println("\nThe word: " + charFiller);
                System.out.println("\nYour lives: " + lives);


                // [4] CHECKING GAME WINNER
                if (Arrays.equals(letterList, charArray2)) {
                    gameWinner = true;
                    break;
                }
            }

            gameResult(gameWinner, theWord);
        }
    }


    public static void gameResult(boolean winner, String word) {

        if (winner) {
            System.out.println("\nPlayer 2 has won!");
            System.out.println("Easy word, innit?\n");
        } else {
            System.out.println("\nThe word was " + word + "\n");
            System.out.println("\nPlayer 1 has won!");
            System.out.println("Impeccable word you have chosen.\n");
        }
    }


    public static void main(String[] args) {

        // Intro
        Intro();

        // First Player
        createWord();
        
    }
}
