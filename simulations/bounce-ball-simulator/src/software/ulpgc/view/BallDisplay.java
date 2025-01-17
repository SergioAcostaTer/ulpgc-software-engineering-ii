package software.ulpgc.view;

import java.util.List;

import software.ulpgc.model.BallColor;

public interface BallDisplay {
    void draw(List<Circle> circles);
    void on(Grabbed grabbed);
    void off(Released released);

    record Circle(String id, int x, int y, int r, BallColor color) { 
        public boolean isAt(int x, int y) {
            return Math.abs((x - this.x)) < this.r && Math.abs((y - this.y)) < this.r;
        }
    }

    interface Grabbed {
        void at(Circle circle);
    }

    interface Released {
        void at(Circle circle);
    }
}
