import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class WordDB {

    private HashMap<String, String[]> wordList;

    private ArrayList<String> categories;

    public WordDB(){
        try {
            wordList = new HashMap<>();
            categories = new ArrayList<>();

            String filePath = getClass().getClassLoader().getResource(CommonConstants.DATA_PATH).getPath();
            if (filePath.contains("%20")) filePath.replaceAll("%20", " ");
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                String category = parts[0];
            }
        }
    }

}
