import java.util.ArrayList;
import java.util.HashMap;

public class WordDB {

    private HashMap<String, String[]> wordList;

    private ArrayList<String> categories;

    public WordDB(){
        try {
            wordList = HashMap<>();
            categories = new ArrayList<>();
        }
    }

}
