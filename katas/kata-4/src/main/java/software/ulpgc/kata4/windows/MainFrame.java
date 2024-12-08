package software.ulpgc.kata4.windows;

import software.ulpgc.kata4.architecture.io.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final JFreeBarchartDisplay barchartDisplay;

    public MainFrame(){
        this.commands = new HashMap<>();
        this.barchartDisplay = new JFreeBarchartDisplay();


        setTitle("Kata 3");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createToolbar(), BorderLayout.NORTH);
        add(barchartDisplay, BorderLayout.CENTER);
    }

    private Component createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createResetZoomButton());
        return panel;

    }

    private Component createResetZoomButton() {
        JButton button = new JButton("Reset Zoom");
        button.addActionListener(e -> {
            Command command = commands.get("resetZoom");
            if (command != null){
                command.execute();
            }
        });
        return button;
    }

    public void put(String name, Command command){
        commands.put(name, command);
    }

    public JFreeBarchartDisplay barchartDisplay(){
        return barchartDisplay;
    }

}
