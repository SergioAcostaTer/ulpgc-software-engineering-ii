package software.ulpgc.kata3.windows;

import software.ulpgc.kata3.architecture.*;
import software.ulpgc.kata3.architecture.charts.Barchart;
import software.ulpgc.kata3.architecture.io.FileTitleLoader;
import software.ulpgc.kata3.architecture.io.ResetZoomCommand;
import software.ulpgc.kata3.architecture.deserializer.TsvTitleDeserializer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\\\Users\\\\Sergio\\\\Desktop\\\\ULPGC\\\\is2\\\\imdb\\\\title.basics.tsv");
        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();

        Map<String, Integer> stats = new LinkedHashMap<>();
        stats.put("0-30", 0);
        stats.put("31-60", 0);
        stats.put("61-90", 0);
        stats.put("91-120", 0);
        stats.put("121-150", 0);
        stats.put("+150", 0);

        for(Title title: titles){
            String range = title.getRange();
            stats.put(range, stats.getOrDefault(range, 0)+1);
        }
        Barchart barchart = new Barchart("Titles Duration", "Duration Range", "Frequency");
        stats.forEach(barchart::add);

        MainFrame mainFrame = new MainFrame();
        mainFrame.put("resetZoom", new ResetZoomCommand(barchart, mainFrame.barchartDisplay()));
        mainFrame.barchartDisplay().show(barchart);
        mainFrame.setVisible(true);

    }
}
