import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

    private final WordStore standard = new WordStore();
    private String chosenWord;
    private static int livesRemaining;
    private StringBuilder hiddenWord;
    private final Scanner charScanner = new Scanner(System.in);
    private static Hangman hangman;

    private static ArrayList<Character> lettersGuessed;
    private final String[] endGameCommands = {
            "Return to main menu",
            "Quit"
    };
    private final Scanner scanner = new Scanner(System.in);

    public void runEasyGame(){
        gameReset(100);

        showHiddenWord();

        while (hiddenWord.toString().contains("_") && livesRemaining > 0){
            replace("standard");
//            hangman.drawStandardHangman(livesRemaining);
            printGameStats();
            if (livesRemaining == 0){
                System.out.println("\nSorry, you ran out of lives! The word was "+ chosenWord + "! \n");
                runGameEndCommands();
            }
        }

        if (!hiddenWord.toString().contains("_")){
            System.out.println("CONGRATS!! You completed the level!");
            runGameEndCommands();
        }
    }

    public void runStandardGame(){
        gameReset(10);

        showHiddenWord();

        while (hiddenWord.toString().contains("_") && livesRemaining > 0){
            replace("standard");
//            hangman.drawStandardHangman(livesRemaining);
            printGameStats();
            if (livesRemaining == 0){
                System.out.println("\nSorry, you ran out of lives! The word was "+ chosenWord + "! \n");
                runGameEndCommands();
            }
        }

        if (!hiddenWord.toString().contains("_")){
            System.out.println("CONGRATS!! You completed the level!");
            runGameEndCommands();
        }
    }

    public void runHardGame(){
        gameReset(6);

        showHiddenWord();

        while (hiddenWord.toString().contains("_") && livesRemaining > 0){
            replace("hard");
//            hangman.drawHardHangman(livesRemaining);
            printGameStats();

            if (livesRemaining == 0){
                System.out.println("Sorry, you ran out of lives! The word was "+ chosenWord + "!");
                runGameEndCommands();
            }
        }

        if (!hiddenWord.toString().contains("_")){
            System.out.println("CONGRATS!! You completed the level with " + livesRemaining + " lives remaining!");
            runGameEndCommands();
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
            System.out.println("\nUmmmm that's not a letter...Try again");
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

    public void gameReset(int startingLives){
        chosenWord = standard.selectWord();
        hiddenWord = new StringBuilder(chosenWord.length());
        livesRemaining = startingLives;
        lettersGuessed = new ArrayList<>();
        hangman = new Hangman();
        System.out.println("\nLET'S PLAY!!\n");
    }

    public void showHiddenWord(){
        System.out.println(chosenWord);
        hiddenWord.append("_ ".repeat(chosenWord.length()));
        System.out.println(hiddenWord);
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
            Commands.runCommands();
        } else {
            System.out.println("\nThanks for stopping by!");
        }

    }

    protected void printGameStats(){
        System.out.println("\n" + hiddenWord);
        System.out.println("Lives remaining: " + livesRemaining);
        System.out.println("Letters guessed: " + lettersGuessed + "\n");
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }
}
