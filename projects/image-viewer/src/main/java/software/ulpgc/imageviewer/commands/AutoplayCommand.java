package software.ulpgc.imageviewer.commands;

import software.ulpgc.imageviewer.ImageDisplay;

import javax.swing.*;

public class AutoplayCommand implements Command {
    private final ImageDisplay display;
    private Timer autoplayTimer;

    public AutoplayCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        if (isAutoplayRunning()) {
            stopAutoplay();
        } else {
            startAutoplay();
        }
    }

    public boolean isAutoplayRunning() {
        return autoplayTimer != null && autoplayTimer.isRunning();
    }

    private void startAutoplay() {
        autoplayTimer = new Timer(2000, e -> display.paint("next", 0));
        autoplayTimer.start();
    }

    private void stopAutoplay() {
        if (autoplayTimer != null) {
            autoplayTimer.stop();
        }
    }
}
