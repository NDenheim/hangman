import java.util.Scanner;

public class Commands {
    private static final String[] commands = {
            "Play game",
            "Quit"
    };

    private static final String[] levels = {
            "Easy       ->   Play without losing lives",
            "Standard   ->   Start with 10 lives",
            "Hard       ->   Start with 6 lives"
    };

    private static final Scanner myScanner = new Scanner(System.in);

    private static final Gameplay play = new Gameplay();

    public static void intro(){
        System.out.println("Welcome to Hangman!");
    }

    public static void runCommands(){
        numberedCommands();

        int chosenValue = myScanner.nextInt();

        while ( chosenValue <1 || chosenValue >2) {
            numberedCommands();
            chosenValue = myScanner.nextInt();
        }

        if (chosenValue == 1){
            chooseLevel();

        } else {
            System.out.println("Thanks for stopping by!");
        }
    }

    public static void numberedCommands(){
        System.out.println("\nPlease select one of the following:");
        for (int i = 0; i < commands.length; i++) {
            printMessage((i+1) + ": " + commands[i]);
        }
    }

    public static void chooseLevel() {
        System.out.println("\nChoose a difficulty:");
        for (int i = 0; i < levels.length; i++) {
            printMessage((i+1) + ": " + levels[i]);
        }

        int chosenDifficulty = myScanner.nextInt();

        if (chosenDifficulty == 1) {
            play.runGame();
        } else if (chosenDifficulty == 2) {
            play.runGame(10, "standard");
        } else if (chosenDifficulty == 3) {
            play.runGame(6, "hard");
        }
    }

    protected static void printMessage(String message) {
        System.out.println(message);
    }
}