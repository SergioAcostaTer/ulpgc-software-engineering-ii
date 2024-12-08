package software.ulpgc.kata4.architecture.charts;

import java.util.LinkedHashMap;
import java.util.Set;

public class Barchart {
    private final LinkedHashMap<String, Integer> count;
    private final String title;
    private final String xAxis;
    private final String yAxis;

    public Barchart(String title, String xAxis, String yAxis) {
        this.title = title;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        count = new LinkedHashMap<>();
    }

    public Barchart(){
        this.title = "title";
        this.xAxis = "xAxis";
        this.yAxis = "yAxis";
        count = new LinkedHashMap<>();
    }

    public int get(String category){
        return count.getOrDefault(category, 0);
    }

    public void add(String category, int value){
        count.put(category, count.getOrDefault(category, 0) + value);
    }

    public Set<String> keySet(){
        return count.keySet();
    }

    public String title() {
        return title;
    }

    public String xAxis() {
        return xAxis;
    }

    public String yAxis() {
        return yAxis;
    }
}
