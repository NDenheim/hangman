public class Hangman {

    public void drawStandardHangman(int lives){
        if (lives == 9){
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("________");
        } else if (lives == 8) {
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        } else if (lives == 7) {
            System.out.println("    ________");
            System.out.println("    |/    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        } else if (lives == 6) {
            System.out.println("    ________");
            System.out.println("    |/     |");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        } else if (lives == 5) {
            System.out.println("    ________");
            System.out.println("    |/     |");
            System.out.println("    |     (_)");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        } else if (lives == 4) {
            System.out.println("    ________");
            System.out.println("    |/     |");
            System.out.println("    |     (_)");
            System.out.println("    |      |");
            System.out.println("    |      |");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        } else if (lives == 3) {
            System.out.println("    ________");
            System.out.println("    |/     |");
            System.out.println("    |     (_)");
            System.out.println("    |      |");
            System.out.println("    |      |");
            System.out.println("    |     /");
            System.out.println("    |    ");
            System.out.println("____|____");
        } else if (lives == 2) {
            System.out.println("    ________");
            System.out.println("    |/     |");
            System.out.println("    |     (_)");
            System.out.println("    |      |");
            System.out.println("    |      |");
            System.out.println("    |     / \\");
            System.out.println("    |    ");
            System.out.println("____|____");
        } else if (lives == 1) {
            System.out.println("    ________");
            System.out.println("    |/     |");
            System.out.println("    |     (_)");
            System.out.println("    |     \\|");
            System.out.println("    |      |");
            System.out.println("    |     / \\");
            System.out.println("    |    ");
            System.out.println("____|____");
        } else if (lives == 0) {
            System.out.println("    ________");
            System.out.println("    |/     |");
            System.out.println("    |     (_)");
            System.out.println("    |     \\|/");
            System.out.println("    |      |");
            System.out.println("    |     / \\");
            System.out.println("    |    ");
            System.out.println("____|____");
        }
    }
}
