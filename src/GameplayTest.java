import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameplayTest {

    private Gameplay play;
    public String chosenWord;
    private static int livesRemaining;
    private static ArrayList<Character> lettersGuessed;


    @BeforeEach
    void setUp(){
        play = new Gameplay();
        play.gameReset(10);
    }

    @Test
    void gameReset_ResetsValues_ReturnsTrue(){
        play.gameReset();
        assertEquals(10, livesRemaining);
//        assertArrayEquals([], lettersGuessed);
    }

    @Test
      void showHiddenWord_ConvertsLetters_ReturnsTrue() {
        chosenWord = "carrot";
        StringBuilder result = play.showHiddenWord();
        assertEquals("_ _ _ _ _ _ ", result.toString());
    }
}