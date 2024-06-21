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
            System.out.println(charChecker);

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
        System.out.println(charFiller);






        Scanner guess = new Scanner(System.in);
        System.out.println("Player 2, you're up! ");

        System.out.print("The word has " + word.length() + " letters: ");
        for (int m = 0; m < word.length(); m++) {
            System.out.print("_ ");
        }

        System.out.println("\n");


        System.out.println("\nYou have 6 lives.");

        char[] letterList = word.toCharArray();

        boolean gameWinner = false;
        int lives = 6;
        while (lives > 0) {

            System.out.print("What character would you like to guess? ");
            theCharacter = guess.next().charAt(0);


            
            
            /*
            char target = theCharacter;
            boolean whileKey = false;
            while (!whileKey) {
                for (int i = 0; i < charArray.length; i++ ) {
                    if (charArray2[i] == target) {
                        System.out.print("Guess a different letter. ");
                        theCharacter = guess.next().charAt(0);
                        target = theCharacter;
                    } else {
                        whileKey = true;
                        break;
                    }
                }
            } 
                */
            



             int runThrough = 0;
            while (runThrough < word.length()) {
                if (theCharacter == letterList[runThrough]) {
                    charFiller.set(runThrough, theCharacter);
                } 
                runThrough++;
            }
            System.out.println("\n" + charFiller);



            char[] charArray2 = new char[character.size()];
            for (int x = 0; x < character.size(); x++) {
                charArray2[x] = charFiller.get(x);
            }



            int antiLivesCounter = 0;
            for (char c : charArray) {
                if (theCharacter == c) {
                    antiLivesCounter++;
                }
            }
            if (antiLivesCounter == 0) {
                lives--;
            }          
            System.out.println("\nYour lives: " + lives);


            if (Arrays.equals(letterList, charArray2)) {
                gameWinner = true;
                break;
            }
        
        }

        gameResult(gameWinner);

    }



    public static void gameResult(boolean winner) {

        if (winner) {
            System.out.println("Player 2 has won!");
            System.out.println("Easy word, innit?");
        } else {
            System.out.println("Player 1 has won!");
            System.out.println("impeccable word you have chosen");
        }

    }







    
    public static void main(String[] args) {

        // Intro
        Intro();

        // First Player
        createWord();


    }
}
