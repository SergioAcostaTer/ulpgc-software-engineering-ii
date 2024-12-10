package software.ulpgc.imageviewer.commands;

import software.ulpgc.imageviewer.ImageDisplay;

public class NextImageCommand implements Command {
    private final ImageDisplay display;

    public NextImageCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        display.paint("next", 0);
    }
}