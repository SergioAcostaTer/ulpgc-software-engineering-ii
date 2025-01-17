package software.ulpgc;

import software.ulpgc.controller.BallPresenter;
import software.ulpgc.model.Ball;
import software.ulpgc.service.BallSimulator;
import software.ulpgc.view.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        BallPresenter presenter = new BallPresenter(mainFrame.getBallDisplay(), new BallSimulator(0.001))
                .add(new Ball("1", -10, 2.0, 25, 0, -9.8, 1.0))
                .add(new Ball("2", -5, 1.8, 25, 0, -9.8, 0.95))
                .add(new Ball("3", 0, 1.6, 25, 0, -9.8, 0.90))
                .add(new Ball("4", 5, 1.4, 25, 0, -9.8, 0.85))
                .add(new Ball("5", 10, 1.2, 25, 0, -9.8, 0.80));
        presenter.execute();
        mainFrame.setVisible(true);
    }
}
