package software.ulpgc.model;

import java.awt.Color;

public enum BallColor {
    RED(Color.RED),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    ORANGE(Color.ORANGE),
    MAGENTA(Color.MAGENTA);

    private final Color awtColor;

    BallColor(Color awtColor) {
        this.awtColor = awtColor;
    }

    public Color getAwtColor() {
        return awtColor;
    }
}
