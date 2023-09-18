import java.util.ArrayList;
import java.util.Random;

public class WordStore {

    private static final ArrayList<String> words = new ArrayList<>();
    private static final Random rand = new Random();

    static{
        words.add("alphabet");
        words.add("bench");
        words.add("colony");
        words.add("dinosaur");
        words.add("engineer");
        words.add("fruits");
        words.add("gargantuan");
        words.add("hippopotamus");
        words.add("iguana");
        words.add("jumper");
        words.add("kangaroo");
        words.add("laptop");
        words.add("monopoly");
        words.add("nutrients");
        words.add("oranges");
        words.add("petulant");
        words.add("queen");
        words.add("rhinoceros");
        words.add("staples");
        words.add("tricycle");
        words.add("umbrella");
        words.add("volcano");
        words.add("wallowing");
        words.add("xylophone");
        words.add("yacht");
        words.add("zebra");
    }

    public String selectWord(){
        int randomIndex = rand.nextInt(words.size());
        return words.get(randomIndex);
    }

}
