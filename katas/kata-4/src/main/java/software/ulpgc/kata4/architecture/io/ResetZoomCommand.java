package software.ulpgc.kata4.architecture.io;

import software.ulpgc.kata4.architecture.charts.Barchart;
import software.ulpgc.kata4.architecture.charts.BarchartDisplay;

public class ResetZoomCommand implements Command{
    private final Barchart barchart;
    private final BarchartDisplay display;

    public ResetZoomCommand(Barchart barchart, BarchartDisplay display) {
        this.barchart = barchart;
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(barchart);
    }
}
