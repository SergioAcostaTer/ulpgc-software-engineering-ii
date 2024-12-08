package software.ulpgc.kata2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\\\Users\\\\Sergio\\\\Desktop\\\\ULPGC\\\\is2\\\\imdb\\\\title.basics.tsv");
        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();

        Map<String, Integer> stats = new HashMap<>();

        for(Title title: titles){
            String range = title.getRange();
            stats.put(range, stats.getOrDefault(range, 0)+1);
        }

        stats.forEach((range, count) -> System.out.println(range + " -> " + count));
    }
}
