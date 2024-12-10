package software.ulpgc.imageviewer.commands;

import software.ulpgc.imageviewer.ImageDisplay;

public class PreviousImageCommand implements Command {
    private final ImageDisplay display;

    public PreviousImageCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        display.paint("previous", 0);
    }
}