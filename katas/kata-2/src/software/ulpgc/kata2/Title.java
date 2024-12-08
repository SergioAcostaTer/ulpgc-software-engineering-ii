package software.ulpgc.kata2;

public class Title {
    private final String title;
    private final int year;
    private final int duration;

    public Title(String title, int year, int duration) {
        this.title = title;
        this.year = year;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public String getRange(){
        if(duration<=30)return "0-30";
        if(duration<=60)return "31-60";
        if(duration<=90)return "61-90";
        if(duration<=120)return "91-120";
        if(duration<=150)return "121-150";
        return "+150";
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", range=" + getRange() +
                '}';
    }
}
