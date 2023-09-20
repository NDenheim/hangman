import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Gameplay {

    private final WordStore standard = new WordStore();
    private String chosenWord;
    private int livesRemaining;
    private StringBuilder hiddenWord;
    private final Scanner charScanner = new Scanner(System.in);
    private static Hangman hangman;

    private static ArrayList<Character> lettersGuessed;
    private final String[] endGameCommands = {
            "Return to main menu",
            "Quit"
    };
    private final Scanner scanner = new Scanner(System.in);

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public String getChosenWord() {
        return chosenWord;
    }

    public void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord;
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }

    public void runGame(){
        gameReset();
        showHiddenWord();

        while (hiddenWord.toString().contains("_")){
            replace();
            printGameStats();
        }

        if (!hiddenWord.toString().contains("_")){
            System.out.println(ANSI_GREEN + "CONGRATS!! You completed the level after " + lettersGuessed.size() + " guesses! If you fancy a challenge, try a level with limited lives." + ANSI_RESET);
            runGameEndCommands();
        }
    }

    public void runGame(int startingLives, String chosenHangman){
        gameReset(startingLives);
        showHiddenWord();

        while (hiddenWord.toString().contains("_") && livesRemaining > 0){
            replace(chosenHangman);
            printGameStats(livesRemaining);
        }

        endGame();
    }

    private void replace() {
        System.out.println("Select a letter from a to z");
        char chosenChar = charScanner.next().toLowerCase().charAt(0);

        for (int i = 0; i < chosenWord.length() ; i++) {
            if (chosenWord.charAt(i) == chosenChar){
                hiddenWord.setCharAt((i*2), chosenChar);
            }
        }

        if (!(chosenChar+"").matches("[a-zA-Z]+")){
            System.out.println("\nUmmmm that's not a letter...Try again!");
        } else if (!chosenWord.contains(chosenChar+"") && !lettersGuessed.contains(chosenChar)) {
            System.out.println("\n" + "Sorry, that's not in the word!" + "\n");
        } else if (chosenWord.contains(chosenChar+"") && !lettersGuessed.contains(chosenChar)){
            System.out.println("\n" + "It's in!");
        }

        if (!lettersGuessed.contains(chosenChar) && (chosenChar+"").matches("[a-zA-Z]+")){
            lettersGuessed.add(chosenChar);
        } else if (lettersGuessed.contains(chosenChar)){
            System.out.println("\nYou've tried that already!");
        }
    }

    private void replace(String chosenHangman) {
        System.out.println("Select a letter from a to z");
        char chosenChar = charScanner.next().toLowerCase().charAt(0);

        for (int i = 0; i < chosenWord.length() ; i++) {
            if (chosenWord.charAt(i) == chosenChar){
                hiddenWord.setCharAt((i*2), chosenChar);
            }
        }

        if (!(chosenChar+"").matches("[a-zA-Z]+")){
            System.out.println("\nUmmmm that's not a letter...Try again!");
        } else if (!chosenWord.contains(chosenChar+"") && !lettersGuessed.contains(chosenChar)) {
            livesRemaining--;
            System.out.println("\n" + "Sorry, that's not in the word!" + "\n");
            hangman.selectHangman(chosenHangman, livesRemaining);
        } else if (chosenWord.contains(chosenChar+"") && !lettersGuessed.contains(chosenChar)){
            System.out.println("\n" + "It's in!");
        }

        if (!lettersGuessed.contains(chosenChar) && (chosenChar+"").matches("[a-zA-Z]+")){
            lettersGuessed.add(chosenChar);
        } else if (lettersGuessed.contains(chosenChar)){
            System.out.println("\nYou've tried that already!");
        }
    }

    public void gameReset(){
        setChosenWord(standard.selectWord());
        hiddenWord = new StringBuilder(chosenWord.length());
        lettersGuessed = new ArrayList<>();
        hangman = new Hangman();
        System.out.println("\nLET'S PLAY!!\n");
    }

    public void gameReset(int startingLives){
        setChosenWord(standard.selectWord());
        hiddenWord = new StringBuilder(chosenWord.length());
        setLivesRemaining(startingLives);
        lettersGuessed = new ArrayList<>();
        hangman = new Hangman();
        System.out.println("\nLET'S PLAY!!\n");
    }

    public StringBuilder showHiddenWord(){
        hiddenWord.append("_ ".repeat(chosenWord.length()));
        System.out.println(hiddenWord + "\n");
        return hiddenWord;
    }

    public void runGameEndCommands(){
        System.out.println("\nPlease select one of the following:");
        for (int i = 0; i < endGameCommands.length; i++) {
            printMessage((i+1) + ": " + endGameCommands[i]);
        }
        int chosenValue = scanner.nextInt();

        while (chosenValue != 1 && chosenValue != 2){
            System.out.println("\nSorry that wasn't one of the options...try again!");
            for (int i = 0; i < endGameCommands.length; i++) {
                printMessage((i+1) + ": " + endGameCommands[i]);
            }
            chosenValue = scanner.nextInt();
        }

        if (chosenValue == 1) {
            Commands.chooseLevel();
        } else {
            System.out.println("\nThanks for stopping by!");
        }

    }

    public void endGame(){
        if (hiddenWord.toString().contains("_") && livesRemaining == 0){
                System.out.println(ANSI_RED + "Sorry, you ran out of lives! The word was "+ getChosenWord() + ".\n"+ ANSI_RESET);
        }

        if (!hiddenWord.toString().contains("_")){
            System.out.println(ANSI_GREEN + "CONGRATS!! You completed the level with " + getLivesRemaining() + " lives remaining!"+ ANSI_RESET);
        }
        runGameEndCommands();
    }

    protected void printGameStats(){
        System.out.println("\n" + hiddenWord);
        System.out.println("\nLetters guessed: " + lettersGuessed + "\n");
    }

    protected void printGameStats(int livesRemaining){
        System.out.println("\n" + hiddenWord);
        System.out.println("\nLives remaining: " + livesRemaining);
        System.out.println("Letters guessed: " + lettersGuessed + "\n");
    }

    protected static void printMessage(String message) {
        System.out.println(message);
    }
}

