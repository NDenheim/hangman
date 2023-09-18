import java.util.Arrays;
import java.util.Scanner;

public class Commands {
    private String[] commands = {
            "Play game",
            "Quit"
    };

    private String[] levels = {
            "Easy",
            "Standard",
            "Hard"
    };

    private Scanner myScanner = new Scanner(System.in);

    Gameplay play = new Gameplay();


    public void runCommands(){
        intro();
        numberedCommands();

        int chosenValue = myScanner.nextInt();

        while ( chosenValue <1 || chosenValue >2) {
            numberedCommands();
            chosenValue = myScanner.nextInt();
        }

        if (chosenValue == 1){
            chooseLevel();
            int chosenDifficulty = myScanner.nextInt();

            if (chosenDifficulty == 2) {
            play.runStandardGame();
            }
        } else if (chosenValue == 2 ) {
            System.out.println("Thanks for stopping by!");
        }
    }

    public void intro(){
        System.out.println("Welcome to hangman!");
    }

    public void numberedCommands(){
        System.out.println("Please select an option from the following:");
        for (int i = 0; i < commands.length; i++) {
            printMessage((i+1) + ": " + commands[i]);
        }
    }

    public void chooseLevel() {
        System.out.println("Choose a difficulty");
        for (int i = 0; i < levels.length; i++) {
            printMessage((i+1) + ": " + levels[i]);
        }
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }


//
//    private static final String[] USER_COMMANDS = {
//            "Play as visitor",
//            "Play as Zoo Keeper",
//            "Leave zoo"
//    };
//
//    public UserCommandRunner(Zoo zoo) {
//        super(USER_COMMANDS, "User");
//        this.zoo = zoo;
//    }
//
//    protected void runZooKeeperCommands() {
//        AnimalCommandRunner commandRunner = new ZooKeeperAnimalCommandRunner(zoo, UserType.zooKeeper);
//        commandRunner.runCommands();
//    }
//
//    protected void runVisitorCommands() {
//        AnimalCommandRunner commandRunner = new VisitorAnimalCommandRunner(zoo, UserType.visitor);
//        commandRunner.runCommands();
//    }
//
//    @Override
//    protected void beforeCommands() {
//    }
//
//    @Override
//    protected boolean handleUserSelection(int userSelection) {
//        if( userSelection == USER_COMMANDS.length ) {
//            System.out.println("Hope to see you again soon!");
//            zoo.shutdownZoo();
//            return false;
//        }
//
//        System.out.println("Performing user selection " + userSelection);
//        switch (userSelection) {
//            case 1:
//                runVisitorCommands();
//                break;
//            case 2:
//                runZooKeeperCommands();
//                break;
//        }
//
//        return true;

}
