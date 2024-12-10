package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.commands.AutoplayCommand;
import software.ulpgc.imageviewer.commands.Command;
import software.ulpgc.imageviewer.commands.NextImageCommand;
import software.ulpgc.imageviewer.commands.PreviousImageCommand;
import software.ulpgc.imageviewer.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;

    public MainFrame() {
        this.setTitle("Image Viewer IS2");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        setAppIcon();

        this.add(createImageDisplay(), BorderLayout.CENTER);
        this.add(createControlPanel(), BorderLayout.SOUTH);
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    private Component createImageDisplay() {
        Map<String, String> imagePaths = Map.of(
                "image1", "src/main/resources/software/ulpgc/imageviewer/images/1.jpg",
                "image2", "src/main/resources/software/ulpgc/imageviewer/images/2.jpg",
                "image3", "src/main/resources/software/ulpgc/imageviewer/images/3.jpg"
        );
        SwingImageDisplay display = new SwingImageDisplay(imagePaths);
        this.imageDisplay = display;
        return display;
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        Command nextCommand = new NextImageCommand(imageDisplay);
        Command previousCommand = new PreviousImageCommand(imageDisplay);
        AutoplayCommand autoplayCommand = new AutoplayCommand(imageDisplay);

        JButton previousButton = new JButton("Previous");
        previousButton.addActionListener(e -> previousCommand.execute());

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> nextCommand.execute());

        JToggleButton autoplayToggle = new JToggleButton("Autoplay");
        autoplayToggle.addItemListener(e -> {
            autoplayCommand.execute();
            autoplayToggle.setText(autoplayCommand.isAutoplayRunning() ? "Stop Autoplay" : "Autoplay");
        });

        panel.add(previousButton);
        panel.add(autoplayToggle);
        panel.add(nextButton);

        return panel;
    }

    private void setAppIcon() {
        java.net.URL iconUrl = getClass().getResource("/software/ulpgc/imageviewer/icons/logo.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(iconUrl);
        this.setIconImage(icon);
    }



}
