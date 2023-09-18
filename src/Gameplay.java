import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

    WordStore standard = new WordStore();
    private String chosenWord;
    private static int livesRemaining;
    StringBuilder hiddenWord;
    Scanner charScanner = new Scanner(System.in);
    Hangman standardHangman = new Hangman();
    private static ArrayList<String> lettersGuessed;
    private final String[] endGameCommands = {
            "Return to main menu",
            "Quit"
    };
    Scanner scanner = new Scanner(System.in);



    public void runStandardGame(){
        chosenWord = standard.selectWord();
        hiddenWord = new StringBuilder(chosenWord.length());
        livesRemaining = 10;
        lettersGuessed = new ArrayList<>();

        System.out.println("LET'S PLAY!!");
        showHiddenWord();

        while (hiddenWord.toString().contains("_")){
            replace();
            System.out.println("\n" + hiddenWord);

            System.out.println("Lives remaining: " + livesRemaining);
            System.out.println("Letters guessed: " + lettersGuessed + "\n");

        }
        System.out.println("CONGRATS!! You completed the level!");
        runGameEndCommands();
    }

    private void replace() {
        System.out.println("Select a letter from a to z");
        char chosenChar = charScanner.next().toLowerCase().charAt(0);

        for (int i = 0; i < chosenWord.length() ; i++) {
            if (chosenWord.charAt(i) == chosenChar){
                hiddenWord.setCharAt((i*2), chosenChar);
            }
        }
        if (!chosenWord.contains(chosenChar+"")) {
            livesRemaining--;
            System.out.println("Sorry, that's not in the word!" + "\n");
            standardHangman.drawStandardHangman(livesRemaining);
        } else {
            System.out.println("It's in!");
        }

        lettersGuessed.add(String.valueOf(chosenChar));

    }


    public void showHiddenWord(){
        System.out.println(chosenWord);
        hiddenWord.append("_ ".repeat(chosenWord.length()));
        System.out.println(hiddenWord);
    }

    public void runGameEndCommands(){
        System.out.println("Please select one of the following:");
        for (int i = 0; i < endGameCommands.length; i++) {
            printMessage((i+1) + ": " + endGameCommands[i]);
        }
        int chosenValue = scanner.nextInt();

        while (chosenValue != 1 && chosenValue != 2){
            System.out.println("Sorry that wasn't one of the options...try again!");
            for (int i = 0; i < endGameCommands.length; i++) {
                printMessage((i+1) + ": " + endGameCommands[i]);
            }
            chosenValue = scanner.nextInt();
        }

        if (chosenValue == 1) {
            Commands.runCommands();
        } else {
            System.out.println("Thanks for stopping by!");
        }



    }

    protected void printMessage(String message) {
        System.out.println(message);
    }
}
