import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WordStoreTest {

    WordStore wordStore = new WordStore();

    private static final ArrayList<String> words = new ArrayList<>();
    private static final Random rand = new Random();

    static {
        words.add("alphabet");
        words.add("bench");
    }

    @Test
    void selectWord_CorrectWordChoice_ReturnsTrue() {
        int randomIndex = rand.nextInt(words.size());;
        String result = wordStore.selectWord();
        assertEquals(words.get(randomIndex), result) ;
    }
}