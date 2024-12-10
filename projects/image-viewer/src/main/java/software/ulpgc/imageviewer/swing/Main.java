package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.ImageDisplay;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            ImageDisplay display = mainFrame.getImageDisplay();
            display.paint("image1", 0);
            display.paint("image2", 400);
            display.paint("image3", 800);
        });
    }
}
