import java.util.Scanner;

public class Gameplay {

    WordStore standard = new WordStore();
    private String chosenWord = standard.selectWord();
    private int livesRemaining = 10;
//    private String hiddenWord;
StringBuilder hiddenWord=new StringBuilder(chosenWord.length());
    Scanner charScanner = new Scanner(System.in);

    public void runStandardGame(){
        System.out.println("LET'S PLAY!!");
        showHiddenWord();

        while (hiddenWord.toString().contains("_")){
            replace();
            System.out.println(hiddenWord);

            System.out.println("Lives remaining: " + livesRemaining);
        }
        System.out.println("CONGRATS!! You completed the level!");
    }

    private void replace() {
        System.out.println("Select a letter from a to z");
        char chosenChar = charScanner.next().toLowerCase().charAt(0);

        for (int i = 0; i < chosenWord.length() ; i++) {
            if (chosenWord.charAt(i) == chosenChar){
//                String charToString = chosenChar+ " ";
//                hiddenWord = hiddenWord.replace((hiddenWord.charAt(i*2+1)), chosenWord.charAt(i));
                hiddenWord.setCharAt((i*2), chosenChar);
            }
        }
        if (!chosenWord.contains(chosenChar+"")) {
            livesRemaining--;
            System.out.println("Sorry, that's not in the word!");
        } else {
            System.out.println("It's in!");

        }
    }


    public void showHiddenWord(){
        System.out.println(chosenWord);
        for (int i = 0; i < chosenWord.length() ; i++) {
//            hiddenWord = chosenWord.replaceAll("[A-Za-z ]", " _");
            hiddenWord.append("_ ");
        }
        System.out.println(hiddenWord);
    }
}
