import java.util.ArrayList;
import java.util.Random;

public class WordStore {

    private static ArrayList<String> words = new ArrayList<>();
    private static Random rand = new Random();

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

    }

    public String selectWord(){
        int randomIndex = rand.nextInt(words.size());
        return words.get(randomIndex);
    }

}
